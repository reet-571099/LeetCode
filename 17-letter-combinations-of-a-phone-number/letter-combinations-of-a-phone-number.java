class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length()==0) return res;

        Map<Character,String> dictPhtoLetter = new HashMap<>();
        dictPhtoLetter.put('2',"abc");
        dictPhtoLetter.put('3', "def");
        dictPhtoLetter.put('4', "ghi");
        dictPhtoLetter.put('5', "jkl");
        dictPhtoLetter.put('6', "mno");
        dictPhtoLetter.put('7', "pqrs");
        dictPhtoLetter.put('8', "tuv");
        dictPhtoLetter.put('9', "wxyz");

        backtrack(digits,0,new StringBuilder(),res,dictPhtoLetter);

        return res;
    }

    private void backtrack(String digits, int idx, StringBuilder comb, List<String> res, Map<Character, String> digitToLetters) {

        if(idx == digits.length())
        {
            res.add(comb.toString());
            return;
        }

        String letters = digitToLetters.get(digits.charAt(idx));
        for(char letter : letters.toCharArray())
        {
            comb.append(letter);
            backtrack(digits,idx+1,comb,res,digitToLetters);
            comb.deleteCharAt(comb.length()-1);
        }
    }
}