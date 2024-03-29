import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String filePath;
    public HashMap<String, Integer> stringDigits;
    public Solution(String filePath){
        this.filePath = filePath;
        this.stringDigits = new HashMap<>() {{
            put("one", 1);
            put("two", 2);
            put("three", 3);
            put("four", 4);
            put("five", 5);
            put("six", 6);
            put("seven", 7);
            put("eight", 8);
            put("nine", 9);
        }};
    }
        public int Solve1() {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                int result = 0;
                while ((line = reader.readLine()) != null) {
                    StringBuilder extractedDigits=new StringBuilder();
                    for (int i = 0; i < line.length(); i++) {
                        char currentChar = line.charAt(i);
                        if (Character.isDigit(currentChar)) {
                            extractedDigits.append(currentChar);
                        }
                    }
                    result += ((extractedDigits.charAt(0) - '0') * 10 + extractedDigits.charAt(extractedDigits.length() - 1) - '0');
                }
                return result;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return -1;
    }
    public int Solve2() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int result = 0;
            while ((line = reader.readLine()) != null) {
                int firstDigit = -1;
                int lastDigit = -1;
                int firstIndex = line.length();
                int lastIndex = -1;
                for(Map.Entry<String, Integer> kvp : stringDigits.entrySet()) {
                    int index = line.indexOf(kvp.getKey());
                    if (line.contains(kvp.getKey()) && index < firstIndex) {
                        firstDigit = kvp.getValue();
                        firstIndex = index;
                    }
                }
                for(Map.Entry<String, Integer> kvp : stringDigits.entrySet()) {
                    int index = line.lastIndexOf(kvp.getKey());
                    if (line.contains(kvp.getKey()) && index > lastIndex) {
                        lastDigit = kvp.getValue();
                        lastIndex = index;
                    }
                }
                for (int i = 0; i < firstIndex; ++i) {
                    if (Character.isDigit(line.charAt(i))) {
                       firstDigit = line.charAt(i) - '0';
                       firstIndex = i;
                       break;
                    }
                }
                for(int i = line.length() - 1; i >= lastIndex; --i) {
                    if (Character.isDigit(line.charAt(i))) {
                        lastDigit = line.charAt(i) - '0';
                        lastIndex = i;
                        break;
                    }
                }
                result += firstDigit * 10 + lastDigit;
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
