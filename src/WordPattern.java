/*
Problem - Given two strings s and t, determine if they are isomorphic.
Approach - I check isomorphism using two hash maps to ensure a one-to-one, consistent character mapping between the strings.
Time Complexity - O(n)
Space Complexity - O(1)
 */

import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;
        HashMap<Character, String> mapPS = new HashMap<>();
        HashMap<String, Character> mapSP = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String w = words[i];
            if (mapPS.containsKey(ch)) {
                if (!mapPS.get(ch).equals(w)) {
                    return false;
                }
            }
            else {
                mapPS.put(ch, w);
            }
            if(mapSP.containsKey(w)){
                if (!mapSP.get(w).equals(ch)) {
                    return false;
                }
            }
            else {
                mapSP.put(w, ch);
            }
        }
        return true;
    }
}
