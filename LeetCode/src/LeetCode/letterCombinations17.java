package LeetCode;

import java.util.List;

public class letterCombinations17 {
    String[] numToAlp = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return
        List<String> sub = letterCombinations(digits.substring(1));
    }
}
