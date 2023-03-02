# sourceCodeSimilarityDetection
A web based protoype similarly detection tool developed as the core artefact of a research project. The application consists of a ReactJS based front end and Python Flask and MongoDB backend with the core logic of the system written full in Python. *The sole purpose of this application is to assist in the detection of similarity in source code (mainly fundamentals and core learning aspects of programming) and the generated results is in no shape or form, meant to indicate plagiarism directly, similar to any other tools for plagiarism detection.* For this iteration of the project, it only supports plagiarism detection for Java (.java) and C# (.cs) files, but not between the two. Fundamentally, because of the similar nature of source code (keywords, syntax based), it is difficult to accurately identify the similarity. Hence the core logic focuses on indentation, spacing, variable naming, method signatures and other aspects of programming that can be considered as funamentally distinctive. 

The core logic behind the similarity detection tool is composed of two NLP concepts: Latent Semantic Analysis (LSA) and Cosine Similarity.

## **Latent Semantic Analysis (LSA):** 
A statistical concept used in Natural Language Processing to identify and analyze the relationships between between documents and the terms that are contained across the documents. Conducting LSA in a set of documents is actually a multi-step process, which consists of other Natural Language Processing concepts put together, which are:
 - Document Preprocessing
 - TFIDF
 - SVD

## **Consine Similarity**: 
A mathematical concept used to the consine between two vectors in a multidimensional vector space (in the case of this application, the tfidf  weight matrix that is created by preprocessing the source code files). While Eucledian Distance can also be a potential similarity detection metric, which uses the distance between vectors to measure the similarity, certain underlying similarities are more prone to be deteced by consine similarity because of the cosine angle based detection.

# Functionalities and  Similarity Detection Engine Logic:

- ## Authentication and Document Upload:
Upon logging into the system, the user can upload a set of documents (multiple items, drag and drop or file upload through the file explorer), the file uploader instantly uploads all the files to the project location (this would essentially be stored on the storage of a server if it was deployed at an externally hosted web server) and into the database. The files are then fed into the logic system to be processed for similarity detection and results processing. 
 
- ## Document Processing:

 - ### Preprocessing:
The documents are added into an array where each document consists of all the information as strings. Since the main focus are the terms in the documents, various forms of preprocessing steps are applied to each document (elements of the array) such as lower case conversion (to convert any upper case characters to lower case), punctuation removal (remove punctuations) and tokenization (tokenizing each of the terms in the documents using nltk tokenization library).
 
 - ### Term Frequency-Inverse Document Frequency - TFIDF: 
Since source code is meant to be similar because of the keywords used in programming, these keywords are to be removed from the document, hence they are not part of the similarity detection process. Certain stopwords are indicated and fed into the sklearn tfidf vectorizer to create a term-document vector based on their frequency while removing the stop words from the processed set of documents. The frequency is denoted by weights that TFIDF itself assigns to the terms and their underlying documents. This multidimensional vector is ultimately projected using a pandas DataFrame.
 
 - ### Singular Value Decomposition - SVD: 
A matrix decomposition technique that is used to decomposed vectors or matrices into linear form of the original data, by reducing noise and creating simplified versions of the matrix. While simplied, directly analysing this transformed data can get difficult, but the positive effects of vector simplication in the similarity detection process is quite significant. It directly aids the similarity detection algorithm is optimizing the process creating a more decomponsed, simpler matrix. This concludes the final step of the document processing or LSA process and the output of this is passed onto the similarity detection algorithm for deriving the similarity scores.
 
- ## Similarity Detection:

 - ### Applying the Consine Similarity Algorithm:
The consine similarity algorithm is used to calcualte the consine angle between the vectors across the document term matrix, which ultimately creates a vector with each document in both y and x axis and their respective similarity scores with comparison to one another. This generated matrix is considered as the final output that consists of all similarity scores between all documents that were uploaded into the system.

- ## Presenting the documents:
The final matrix that contains the similiarty weights between the documents is consume by the front end through an API call and is presented to the user. The left pane of the results window consists of a preview of the file, while the right pane consists of all other files along with the similarity score compared to the file that is selected as is being view in the left pane. This is done by manipulating the matrix this is sent from the backend. Upon clicking any of the documents on the list on the right pane, that specific document is projected on the left pane and the list changes with other documents and similarity score with respect to the main document in preview.

# How to run
- ## Frontend Web-Server:
  - Install Nodejs
  - Go to the similaritydetect folder and open terminal
  - run following commands
  ```
  npm start
  ```
- ## Backend Server:
  - The python backend in developed using flask micro web framework for light api development. An IDE that runs flask applications locally (such as PyCharm) is required => Otherwise an Apache server can server the backend APIs with custom configurations.
  - The backend also requires a MongoDB database instance running and configured into the app.py file for user authentication and it requires an user to be registered into the Database system. The system is configured to work with NonSQL databases primarily.
