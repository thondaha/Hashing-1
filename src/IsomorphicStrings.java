/*
Problem - Given a pattern and a string str, find if str follows the same pattern.
Approach - I check the pattern matching using two hash maps to ensure a one-to-one, consistent pattern mapping between the strings.
Time Complexity - O(n)
Space Complexity - O(n)
 */

import java.util.HashMap;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (mapST.containsKey(c1)) {
                if(!mapST.get(c1).equals(c2)) {
                    return false;
                }
            }
            else  {
                mapST.put(c1, c2);
            }
           if (mapTS.containsKey(c2)) {
                if(!mapTS.get(c2).equals(c1)) {
                    return false;
                }
            }
           else  {
               mapTS.put(c2, c1);
           }
        }
        return true;
    }
}
