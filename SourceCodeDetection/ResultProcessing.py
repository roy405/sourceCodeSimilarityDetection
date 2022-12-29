import pandas as pd
import numpy as np
from sklearn.feature_extraction.text import TfidfVectorizer


class ResultProcessing:
    simDetect = []

    def results(self, simDetect):
        pd.set_option('display.max_rows', 500)
        pd.set_option('display.max_columns', 500)
        pd.set_option('display.width', 1000)

        numrows = len(simDetect)
        numcolumns = len(simDetect[0])
        dFSIM = pd.DataFrame(simDetect, index=np.arange(numrows), columns=np.arange(numcolumns))
        return dFSIM
