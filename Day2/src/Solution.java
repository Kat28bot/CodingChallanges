import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Solution {
    public String filePath;
    int red;
    int green;
    int blue;

    public Solution(String filePath, int red, int green, int blue ) {
        this.filePath = filePath;
        this.red=red;
        this.green=green;
        this.blue=blue;
    }
    public int Solve1() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int result = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts=line.split(":");

                int ID=Integer.parseInt(parts[0].split(" ")[1]);
                String[] games=parts[1].split(";");
                boolean possible= true;
                for(String game : games){
                    String[] colors=game.split(",");
                    for (String color:colors){
                      // System.out.println(color);
                        String[] colour=color.split(" ");
                     //   System.out.println(colour[1]+"x"+colour[2]);
                        if((colour[2].contains("red")&&Integer.parseInt(colour[1])>red)||(colour[2].contains("green")&&Integer.parseInt(colour[1])>green)
                                ||(colour[2].contains("blue")&&Integer.parseInt(colour[1])>blue)){
                           // System.out.println(colour[1]+" "+colour[0]);
                            possible=false;
                            break;
                        }
                    }
                    if(!possible){
                        break;
                    }
                }
               // System.out.println(ID);
                if(possible){
                 //   System.out.println(ID);
                    result+=ID;
                }
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
                String[] parts=line.split(":");

                int red=0, green=0, blue=0;
                String[] games=parts[1].split(";");
                for(String game : games){
                    String[] colors=game.split(",");
                    for (String color:colors){
                        // System.out.println(color);
                        String[] colour=color.split(" ");
                        //   System.out.println(colour[1]+"x"+colour[2]);
                        if(colour[2].contains("red")&&Integer.parseInt(colour[1])>red){
                            red=Integer.parseInt(colour[1]);
                        }
                        else if(colour[2].contains("green")&&Integer.parseInt(colour[1])>green){
                            green=Integer.parseInt(colour[1]);
                        }
                        else if(colour[2].contains("blue")&&Integer.parseInt(colour[1])>blue){
                            blue=Integer.parseInt(colour[1]);
                        }

                    }

                }
                // System.out.println(ID);
                result+=red*green*blue;
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
