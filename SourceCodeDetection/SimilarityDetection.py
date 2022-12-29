from sklearn.metrics.pairwise import cosine_similarity


class SimilarityDetection:
    decomposed = []

    def detectSimilarity(self, decomposed):
        similarityDetection = cosine_similarity(decomposed, decomposed)
        return similarityDetection
