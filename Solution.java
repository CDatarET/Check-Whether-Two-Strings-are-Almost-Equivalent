class Solution {
    private HashMap<Character, Integer> freq(String word){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < word.length(); i++){
            map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
        }

        return map;
    }

    public boolean checkAlmostEquivalent(String word1, String word2) {
        HashMap<Character, Integer> m1 = freq(word1);
        HashMap<Character, Integer> m2 = freq(word2);

        for(char c : m1.keySet()){
            if(m2.get(c) == null){
                if(m1.get(c) > 3){
                    return false;
                }
            }
            else{
                if(Math.abs(m1.get(c) - m2.get(c)) > 3){
                    return false;
                }

                m2.remove(c);
            }
        }

        for(char c : m2.keySet()){
            if(m2.get(c) > 3){
                return false;
            }
        }

        return true;
    }
}
