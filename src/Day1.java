import java.io.*;

public class Day1 {
    public static void main(String[] args) {
        BufferedReader reader;
        int counter = 0;
        try {
            reader = new BufferedReader(new FileReader("lista.txt"));
            String line = reader.readLine();
            int firstLine = 0;
            int secondLine = 0;

            while (line != null) {
                System.out.println(line);
                try{
                    firstLine = Integer.parseInt(line);
                }
                catch (NumberFormatException ex){
                    ex.printStackTrace();
                }
                // read next line
                line = reader.readLine();
                if(line == null){
                    break;
                }
                try{
                    secondLine = Integer.parseInt(line);
                }
                catch (NumberFormatException ex){
                    ex.printStackTrace();
                }
                if(secondLine > firstLine) {
                    counter++;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Counter: " + counter);
    }
}