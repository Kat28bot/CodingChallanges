import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public String filePath;
    public Solution(String filePath) {
        this.filePath = filePath;
    }

    public int Solve1() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int result = 0;
            ArrayList<String> lines=new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                lines.add(line);

            }
            for(int i=0;i<lines.size();i++){
                ArrayList<String> NumIndexes=getNumbersIndexes(lines.get(i));
            }
            for(int i=1;i<lines.size()-1;i++){
                String prevLine=(lines.get(i-1));
                String currLine=(lines.get(i));
                ArrayList<String> NumIndexes=getNumbersIndexes(currLine);
                String nextLine=(lines.get(i+1));
                for(String numIndex:NumIndexes){
                    for(char c:numIndex.toCharArray()){
                        char prevChar=prevLine.charAt(Integer.parseInt(String.valueOf(c)));
                        char nextChar=nextLine.charAt(Integer.parseInt(String.valueOf(c)));
                        int number = Integer.parseInt(currLine.substring(Integer.parseInt(String.valueOf(numIndex.charAt(0))),
                                Integer.parseInt(String.valueOf(numIndex.charAt(numIndex.length() - 1)))));
                        if(!Character.isDigit(prevChar)&&prevLine.charAt(prevChar)!='.'){
                            result=result+ number;
                            break;
                        }else if(!Character.isDigit(nextChar)&&nextLine.charAt(nextChar)!='.'){
                            result=result+ number;
                            break;
                        }else{
                            
                        }
                    }
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }
    public ArrayList<String> getNumbersIndexes(String line){
        ArrayList<String> result=new ArrayList<>();
        for(int i=0;i<line.length();i++){
            while(!Character.isDigit(line.charAt(i))){
                i++;
            }
            String num="";
            while(Character.isDigit(line.charAt(i))){
               num=num+line.charAt(i);
                i++;
            }
            result.add(num);
        }
        return result;
    }
    //                String currLine=reader.readLine(),nextLine=null;
//                if((nextLine = reader.readLine()) != null){
//                    System.out.println(line+"\n"+currLine+"\n"+nextLine+"\n");
//                }else{
//                    System.out.println(line+"\n"+currLine+"\n"+"\n");
//                }
    // System.out.println(line+"\n"+currLine+"\n"+nextLine+"\n");
}
