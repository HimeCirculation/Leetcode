from itertools import product

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if(digits == ""):
            return []
        sets = {2: "abc", 3: "def", 4: "ghi", 5: "jkl", 6: "mno", 7: "pqrs", 8: "tuv", 9: "wxyz"}
        return ["".join(x) for x in product(*[sets[int(a)] for a in digits])]
        
