import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class Day3 {
    ArrayList<String> fileToArray(String file) throws FileNotFoundException {
        ArrayList<String> array = new ArrayList<>();
        Scanner scanner = new Scanner(new File(file));
        while (scanner.hasNextLine()) {
            array.add(scanner.nextLine());
        }
        return array;
    }

    void findGammaAndEpsilon(ArrayList<String> array) {
        String gamma = "";
        String epsilon = "";
        String[] bit;
        for (int i = 0; i < array.get(0).length(); i++) {
            int counterZero = 0;
            int counterOne = 0;
            Iterator iterator = array.iterator();

            while (iterator.hasNext()) {
                String line = (String) iterator.next();
                System.out.println(line);
                bit = line.split("");
                System.out.println(bit[i]);

                if (bit[i].equals("0")) {
                    counterZero++;
                }
                if (bit[i].equals("1")) {
                    counterOne++;
                }
            }
            if (counterZero > counterOne) {
                gamma += "0";
                epsilon += "1";
            }
            if (counterOne >= counterZero) {
                gamma += "1";
                epsilon += "0";
            }
        }
        System.out.println("Gamma: " + gamma);
        System.out.println("epsilon: " + epsilon);
        System.out.println("Decimal Gamma: " + Integer.parseInt(gamma, 2));
        System.out.println("Decimal Epsilon: " + Integer.parseInt(epsilon, 2));
        System.out.println("Multiply: " + Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2));
    }

    ArrayList<String> oxygenGeneratorRating(ArrayList<String> array, int bitNumber) {
        ArrayList<String> arrayOnes = new ArrayList<>();
        ArrayList<String> arrayZeros = new ArrayList<>();
        String[] bit;
        int countOnes = 0;
        int countZeros = 0;
        arrayZeros.clear();
        arrayOnes.clear();
        Iterator iterator = array.iterator();
            while (iterator.hasNext()) {
                String line = (String) iterator.next();
                bit = line.split("");
                    if (bit[bitNumber].equals("0")) {
                        countZeros++;
                        arrayZeros.add(line);
                    }
                    if (bit[bitNumber].equals("1")) {
                        countOnes++;
                        arrayOnes.add(line);
                    }
            }
            if (countZeros > countOnes) {
                array = arrayZeros;
            } else {
                array = arrayOnes;
            }
        if(array.size() != 1) {
            bitNumber++;
            oxygenGeneratorRating(array, bitNumber);
        } else {
            System.out.println("Oxygen generator rating: " + Integer.parseInt(array.get(0), 2));
        }
        return array;
}

    ArrayList<String> co2Scrubber(ArrayList<String> array, int bitNumber){
        ArrayList<String> arrayOnes = new ArrayList<>();
        ArrayList<String> arrayZeros = new ArrayList<>();
        String[] bit;
        int countOnes = 0;
        int countZeros = 0;
        arrayZeros.clear();
        arrayOnes.clear();
        Iterator iterator = array.iterator();
            while (iterator.hasNext()) {
                String line = (String) iterator.next();
                bit = line.split("");
                if (bit[bitNumber].equals("0")) {
                    countZeros++;
                    arrayZeros.add(line);
                }
                if (bit[bitNumber].equals("1")) {
                    countOnes++;
                    arrayOnes.add(line);
                }
            }
        if (countOnes < countZeros) {
            array = arrayOnes;
        } else {
            array = arrayZeros;
        }
        if(array.size() != 1) {
            bitNumber++;
            co2Scrubber(array, bitNumber);
        } else {
            System.out.println("Co2 scrubber: " + Integer.parseInt(array.get(0),2));
        }
        return array;

    }
    public static void main(String[] args) throws FileNotFoundException {

        Day3 advent = new Day3();
        ArrayList<String> report = advent.fileToArray("diagnostic_report.txt");
        advent.findGammaAndEpsilon(report);
        advent.oxygenGeneratorRating(report, 0);
        advent.co2Scrubber(report,0);
    }
}