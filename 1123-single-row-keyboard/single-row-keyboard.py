class Solution:
    def calculateTime(self, keyboard: str, word: str) -> int:
        d = {}
        for i in range(len(keyboard)):
            d[keyboard[i]] = i
        res = 0
        temp = 0
        for c in word:
            res += abs(d[c]-temp)
            temp = d[c]
        return res
        