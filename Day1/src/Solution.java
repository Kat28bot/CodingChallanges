import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public String filePath;
    public Solution(String filePath){
        this.filePath = filePath;
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

}
