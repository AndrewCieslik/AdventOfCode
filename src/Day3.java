import java.io.*;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {
        String gamma ="";
        String epsilon = "";
        String[] bit;

        try{
            for(int i = 0; i < 12; i++) {

                Scanner scanner=new Scanner(new File("diagnostic_report.txt"));
                int counterZero = 0;
                int counterOne = 0;

                while(scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    System.out.println(line);
                    bit = line.split("");
                    System.out.println(bit[i]);

                    if (bit[i].equals("0")) {
                        counterZero++;
                    }
                    if (bit[i].equals("1")) {
                        counterOne++;
                    }
                    System.out.println("Zeros" + counterZero);
                    System.out.println("One" + counterOne);

                }
                System.out.println("########################################################################");

                if(counterZero > counterOne){
                    gamma += "0";
                    epsilon += "1";
                }
                if (counterZero < counterOne){
                    gamma += "1";
                    epsilon +="0";
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Gamma: " + gamma);
        System.out.println("epsilon: " + epsilon);
        System.out.println("Decimal Gamma: "+ Integer.parseInt(gamma,2));
        System.out.println("Decimal Epsilon: "+ Integer.parseInt(epsilon,2));
        System.out.println("Multiply: " + Integer.parseInt(gamma,2)*Integer.parseInt(epsilon,2));
    }
}
