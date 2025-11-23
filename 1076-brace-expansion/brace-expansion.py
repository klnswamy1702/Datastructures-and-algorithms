class Solution:
    def expand(self, s: str) -> List[str]:
        start = s.find("{")
        if start == -1:
            return [s]
        
        end = s.find("}")

        letters = sorted(s[start+1:end].split(","))
        suffixes = self.expand(s[end+1:])
        words = []
        for letter in letters:
            for suffix in suffixes:
                words.append(s[:start] + letter + suffix)
                
        return words