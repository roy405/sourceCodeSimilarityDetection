from flask import Flask, jsonify, json, flash, redirect, request, abort
from flask_pymongo import PyMongo
from datetime import datetime
from flask_bcrypt import Bcrypt
from flask_cors import CORS
from flask_jwt_extended import JWTManager
from flask_jwt_extended import create_access_token
from werkzeug.utils import secure_filename
import os
import json
import pandas as pd
import ntpath
import pdfkit as kit
import Preprocessing
import ResultProcessing
import SimilarityDetection
import SourceCodeFile

app = Flask(__name__)

app.config['MONGO_DBNAME'] = 'detectionAuth'
app.config['MONGO_URI'] = 'mongodb://localhost:27017/detectionAuth'
app.config['JWT_SECRET_KEY'] = 'secret'

# Files Upload
UPLOAD_FOLDER = 'C:/Users/royce/Desktop/Files/Plagiarism Detection Tool/similarity-detect/public/uploads'
PDF_FOLDER = "C:/Users/royce/Desktop/Files/Plagiarism Detection Tool/similarity-detect/public/pdfFiles"
app.secret_key = "secret key"
app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER
app.config['MAX_CONTENT_LENGTH'] = 16 * 1024 * 1024

mongo = PyMongo(app)
bcrypt = Bcrypt(app)
jwt = JWTManager(app)
CORS(app)

ALLOWED_EXTENSIONS = {'txt', '.java'}


def allowed_file(filename):
    return '.' in filename and filename.rsplit('.', 1)[1].lower() in ALLOWED_EXTENSIONS


# Upload Mechanism
@app.route('/upload', methods=['POST'])
def upload_file():
    result = ""
    print("start")
    # if request.method == 'POST':
    print(len(request.files))
    print(request.files)
    print(request.files.getlist('file'))
    if len(request.files) == 0:
        print("flash")
        flash('No file part')

    files = request.files.getlist('file')
    for file in files:
        filename = secure_filename(file.filename)
        print(filename)
        file.save(os.path.join(app.config['UPLOAD_FOLDER'], filename))
        result = jsonify('Files Successfully Uploaded')
    return result


# Registration Mechanism
@app.route('/users/registration', methods=['POST'])
def register():
    users = mongo.db.user
    first_name = request.get_json()['first_name']
    last_name = request.get_json()['last_name']
    email = request.get_json()['email']
    password = bcrypt.generate_password_hash(request.get_json()['password'])
    created = datetime.utcnow()

    user_id = users.insert({
        'first_name': first_name,
        'last_name': last_name,
        'email': email,
        'password': password,
        'created': created
    })

    new_user = users.find_one({'_id': user_id})
    result = {'email': new_user['email'] + 'registered'}
    return jsonify({'result': result})


# Login Mechanism
@app.route('/users/login', methods=['POST'])
def login():
    users = mongo.db.user
    # data = json.load(request.get_data())
    # print(data)
    data = request.get_json()
    print(data["email"])
    email = request.get_json()['email']
    password = request.get_json()['password']
    result = ""

    response = users.find_one({'email': email})

    if response:
        if bcrypt.check_password_hash(response['password'], password):
            access_token = create_access_token(identity={
                'first_name': response['first_name'],
                'last_name': response['last_name'],
                'email': response['email']
            })
            return jsonify({'token': access_token})
        else:
            return abort(404)
    else:
        return abort(100)


# Plagiarism Detection Process
@app.route('/process')
def getSourceCodeFiles():
    directoryListing = os.listdir(UPLOAD_FOLDER)
    filesAdd = []
    for item in directoryListing:
        filesAdd.append(UPLOAD_FOLDER + '/' + item)
    print(filesAdd)
    src = SourceCodeFile.SourceCodeFile()
    new_doc_file = src.read_files(filesAdd)
    pre_process = Preprocessing.PreProcessing()
    processed_files = pre_process.preProcessing(new_doc_file)
    tfidfFile = pre_process.tFIDFTransformation(processed_files)
    # tfidfResProcess = ResultProcessing.ResultProcessing().tfidfResults(tfidfFile)
    tfidfResProcess = Preprocessing.PreProcessing().tfidfResults(processed_files)
    svdFile = pre_process.singularValueDecomposition(tfidfFile)
    simDetect = SimilarityDetection.SimilarityDetection().detectSimilarity(svdFile)
    resProcess = ResultProcessing.ResultProcessing().results(simDetect)
    # print(len(tfidfResProcess))
    # print(len(resProcess))
    # print(tfidfResProcess.keys())
    # print(tfidfResProcess["address"])
    dataList = dict()
    # new_dict = dict([(value, key) for key, value in tfidfResProcess.items()])

    tfidProcFiles = dict()
    for (key, value) in tfidfResProcess.items():
        for count in range(0, len(value)):
            if count not in tfidProcFiles:
                tfidProcFiles[count] = dict()
            tempDict = tfidProcFiles[count]
            tempDict[key] = value[count]
            tfidProcFiles[count] = tempDict
    # print(tfidProcFiles)

    for x in range(0, len(resProcess)):
        process = resProcess[x]
        filePath = filesAdd[x]
        # tfid = tfidfResProcess[x]
        # print(tfid)

        processes = dict()
        for y in range(0, len(process)):
            processes[y] = process[y]

        dataDict = dict()
        dataDict["file"] = filePath
        dataDict["info"] = processes
        dataList[x] = dataDict

    print("data list " + str(dataList))
    return jsonify(info=dataList, tfidResult=tfidProcFiles)


@app.route('/saveResults', methods=["POST"])
def saveResults():
    results = mongo.db.results


@app.route('/results', methods=["GET"])
def getResults():
    return "value"


if __name__ == '__main__':
    app.run()
