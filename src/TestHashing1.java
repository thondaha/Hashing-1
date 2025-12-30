import java.util.ArrayList;

public class TestHashing1 {
    void main(){
        Anagram anagram = new Anagram();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(anagram.groupAnagramsBySorting(strs));
        System.out.println(anagram.groupAnagramsByPrimeProduct(strs));
        //Test Isomorphic Strings
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        Boolean isIsomorphic = isomorphicStrings.isIsomorphic("egg","add");
        System.out.println(isIsomorphic + " given Strings are isomorphic"); // true check
        System.out.println(isomorphicStrings.isIsomorphic("foo","bar") + " given Strings are not isomorphic"); // false check
        WordPattern  wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern("abba","dog cat cat dog") + " given words follow the same pattern");
        System.out.println(wordPattern.wordPattern("abba","dog cat cat fish") + " given words don't follow the same pattern");// pattern miss match check
    }
}
