import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<String>();
        if(digits.isEmpty()) return result;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(result.peek().length()==i){
                String t = result.remove();
                for(char s : mapping[x].toCharArray())
                    result.add(t+s);
            }
        }
        return result;
    }
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//
//    }
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
