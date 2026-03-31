import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> hm1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm1.put(ch, hm1.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> hm2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {   
            char ch = t.charAt(i);             
            hm2.put(ch, hm2.getOrDefault(ch, 0) + 1);
        }

        return hm1.equals(hm2);
    }
}