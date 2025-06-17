class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        Map<Character, String> numberToLetters = new HashMap<>();
        numberToLetters.put('2', "abc");
        numberToLetters.put('3', "def");
        numberToLetters.put('4', "ghi");
        numberToLetters.put('5', "jkl");
        numberToLetters.put('6', "mno");
        numberToLetters.put('7', "pqrs");
        numberToLetters.put('8', "tuv");
        numberToLetters.put('9', "wxyz");

        LinkedList<String> result = new LinkedList<>();
        result.add(""); 

        for (char digit : digits.toCharArray()) {
            String letters = numberToLetters.get(digit); 
            int size = result.size();

            for (int i = 0; i < size; i++) {
                String combination = result.poll();
                for (char letter : letters.toCharArray()) {
                    result.add(combination + letter);
                }
            }
        }

        return result;
    }
}
