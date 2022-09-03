import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {
    public static void main(String[] args) {
        int position = 0;
        int depth = 0;

        Submarine yellowSubmarine = new Submarine(0,0);

        try {
            BufferedReader reader = new BufferedReader(new FileReader("move.txt"));
            String line = reader.readLine();

            do{
                System.out.println(line);
                if(line.contains("forward")){

                    position += Integer.parseInt(String.valueOf(line.charAt(8)));
                    yellowSubmarine.setPosition(position);
                }
                if(line.contains("up")){

                    depth -= Integer.parseInt(String.valueOf(line.charAt(3)));
                    yellowSubmarine.setDepth(depth);
                }
                if(line.contains("down")){

                    depth += Integer.parseInt(String.valueOf(line.charAt(5)));
                    yellowSubmarine.setDepth(depth);

                }
                line = reader.readLine();

            } while (line != null);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Position: " + yellowSubmarine.getPosition());
        System.out.println("Depth: " + yellowSubmarine.getPosition());
        System.out.println("Multiply: " + yellowSubmarine.getPosition() * yellowSubmarine.getDepth());
    }
}