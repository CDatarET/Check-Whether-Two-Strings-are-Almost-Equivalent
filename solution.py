class Solution:
    def checkAlmostEquivalent(self, word1: str, word2: str) -> bool:
        c1 = Counter(word1)
        c2 = Counter(word2)

        for x in c1:
            if x not in c2:
                if c1[x] > 3:
                    return False
            else:
                if abs(c1[x] - c2[x]) > 3:
                    return False
                
                c2.pop(x)
        
        for x in c2:
            if c2[x] > 3:
                return False
        
        return True
