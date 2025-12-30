/*
Problem - Given an array of strings, group anagrams together.
Approach 1 - Sorting the given string and storing it as a key because if you sort anagrams they all become same string
Time Complexity - O(n*k log k)
Space Complexity - O(n)
Approach 2 - Each string is hashed using a product of unique primes corresponding to each character.Hashes serve as keys in a map to group anagrams together.
The result is a collection of string lists sharing the same hash.
Time Complexity - O(n*k)
Space Complexity - O(n)
 */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagram {
    private static final int[] PRIMES = {
            2,3,5,7,11,13,17,19,23,29,31,37,41,
            43,47,53,59,61,67,71,73,79,83,89,97,101
    };
    public List<List<String>> groupAnagramsBySorting(String[] strs){
        HashMap<String,List<String>> anagramMap = new HashMap<>();
        for(String s : strs){
            char[] chars =s.toCharArray();
            Arrays.sort(chars);// sorting the string to store it as key
            String sortedStrKey = new String(chars);
            //check if key is already present in map
            if(!anagramMap.containsKey(sortedStrKey)){
                anagramMap.put(sortedStrKey,new ArrayList<>());//creates an empty list to that key
            }
            anagramMap.get(sortedStrKey).add(s);//adds the value to the list
        }
        return new ArrayList<>(anagramMap.values());
    }
    public List<List<String>> groupAnagramsByPrimeProduct(String[] strs){
        HashMap<BigInteger,List<String>> primeMap = new HashMap<>();
        for(String s : strs){
            BigInteger key = BigInteger.ONE;
            for(char c : s.toCharArray()){
                key=key.multiply(BigInteger.valueOf(PRIMES[c-'a']));
            }
            primeMap.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(primeMap.values());
    }
}
