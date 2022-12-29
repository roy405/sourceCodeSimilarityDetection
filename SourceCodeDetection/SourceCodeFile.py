import string
import nltk
import numpy as np
import os
import pandas as pd
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.decomposition import TruncatedSVD
from sklearn.metrics.pairwise import cosine_similarity
from collections import Counter
import urllib.request
from flask import Flask, flash, request, redirect, render_template
from werkzeug.utils import secure_filename


class SourceCodeFile:
    document_list = []

    def read_files(self, document_list):
        new_doc_list = []
        for doc in document_list:
            with open(doc, 'r') as f:
                text = ""
                for line in f:
                    text += line
                new_doc_list.append(text)
        return new_doc_list


