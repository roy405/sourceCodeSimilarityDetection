import string
import nltk
import numpy as np
import os
import pandas as pd
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.decomposition import TruncatedSVD
from sklearn.metrics.pairwise import cosine_similarity
from collections import Counter

from SourceCodeFile import SourceCodeFile as source_Code_Files


class PreProcessing:
    input_Document_List = []

    def preProcessing(self, input_Document_List):
        corrected_doc_list = []
        for doc in input_Document_List:
            lowerCaseConverted = doc.lower()
            punctuationRemoval = lowerCaseConverted.translate(str.maketrans('', '', string.punctuation))
            tokenization = nltk.word_tokenize(punctuationRemoval)
            corrected_doc_list.append(str(tokenization))

        return corrected_doc_list

    def tFIDFTransformation(self, corrected_doc_list):
        global stop_words_list
        stop_words_list = [
            'private', 'for', 'get', 'set', 'public',
            'return', 'static', 'print', 'string', 'int',
            'integer', 'import', 'java', 'void', 'boolean',
            'protected', 'default', 'abstract', 'break', 'byte',
            'catch', 'try', 'char', 'class', 'do',
            'double', 'else', 'new', 'null', 'package',
            'if', 'else if', 'float', 'interface', 'long',
            'this', 'throw', 'throws', 'while', 'foreach',
            'data'
        ]
        tfidf = TfidfVectorizer(stop_words=stop_words_list)
        doc_matrix = tfidf.fit_transform(corrected_doc_list)
        return doc_matrix

    def tfidfResults(self, doc_matrix):
        global stop_words_list
        stop_words_list = [
            'private', 'for', 'get', 'set', 'public',
            'return', 'static', 'print', 'string', 'int',
            'integer', 'import', 'java', 'void', 'boolean',
            'protected', 'default', 'abstract', 'break', 'byte',
            'catch', 'try', 'char', 'class', 'do',
            'double', 'else', 'new', 'null', 'package',
            'if', 'else if', 'float', 'interface', 'long',
            'this', 'throw', 'throws', 'while', 'foreach',
            'data'
        ]
        tfidf = TfidfVectorizer(stop_words=stop_words_list)
        doc_matrix = tfidf.fit_transform(doc_matrix)
        doc_term_matrix = doc_matrix.todense()
        pd.set_option('display.max_rows', 500)
        pd.set_option('display.max_columns', 500)
        pd.set_option('display.width', 1000)

        df = pd.DataFrame(doc_term_matrix, columns=tfidf.get_feature_names())
        return df

    def singularValueDecomposition(self, doc_matrix):
        svd = TruncatedSVD(n_components=2).fit(doc_matrix)
        decomposed = svd.transform(doc_matrix)
        return decomposed
