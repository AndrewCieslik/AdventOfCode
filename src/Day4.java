import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day4 {
    List<String> numbersToList(String textfile) {
        File file = new File(textfile);
        List<String> numbers = null;
            try {
                Scanner scanner = new Scanner(file);
                String line = scanner.nextLine();
                numbers = Arrays.asList(line.split("\\s*,\\s*"));
                System.out.println(numbers);

            } catch (FileNotFoundException e) {}
            return numbers;
    }

    String[][] numberToArray(String textfile){
        File file = new File(textfile);
        String[][] array = new String[5][5];
        try {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            scanner.nextLine();
            for(int k = 0; k < 5; k++) {
                String line = scanner.nextLine();
                System.out.println(line);
                int j = 0;
                    for (int i = 0; i < 5; i++) {
                        array[k][i] = "" + line.charAt(j) + line.charAt(j + 1);
                        j += 3;
                        //System.out.println(array[k][i]);
                    }
            }

        } catch (FileNotFoundException e) {}
        return array;
    }
    String[][] bingo(List<String> list) throws FileNotFoundException {
        File file = new File("day4.txt");
        Iterator iterator = list.iterator();
        int whichArray = 0;
        int winnerArray = 0;
        int minIterations = 0;
        String[][] minArray = new String[5][5];
        String[][] array = new String[5][5];
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        while(iterator.hasNext()) {
            scanner.nextLine();
            for (int k = 0; k < 5; k++) {
                String line = scanner.nextLine();
                System.out.println(line);
                int j = 0;
                for (int i = 0; i < 5; i++) {
                    array[k][i] = "" + line.charAt(j) + line.charAt(j + 1);
                    j += 3;
                    //System.out.println(array[k][i]);
                }
            }
            int x0 = 0;
            int x1 = 0;
            int x2 = 0;
            int x3 = 0;
            int x4 = 0;
            boolean horizontalWasFound = false;
            for (int z = 0; z < list.size(); z++) {
                for (int i = 0; i < 5; i++) {
                    if (list.get(z).equals(array[i][0])) {
                        x0++;
                    }
                    if (list.get(z).equals(array[i][1])) {
                        x1++;
                    }
                    if (list.get(z).equals(array[i][2])) {
                        x2++;
                    }
                    if (list.get(z).equals(array[i][3])) {
                        x3++;
                    }
                    if (list.get(z).equals(array[i][4])) {
                        x4++;
                    }
                    if ((x0+x1+x2+x3+x4 == 5) && (x0 > 0 && x1 > 0 && x2 > 0 && x3 > 0 && x4 > 0)) {
                        System.out.println("Bingo!" + "how fast(iteration):" + z + " number: " + list.get(z));
                        System.out.println("Horizontal: " + x0 + " " + x1 + " " + x2 + " " + x3 + " " + x4);
                        System.out.println("Array number: " + whichArray);
                        horizontalWasFound = true;
                        if(whichArray == 0){
                            minIterations = z;
                        }
                        if (z < minIterations) {
                            minIterations = z;
                            minArray = array;
                        }
                        break;
                    }
                }
                if(horizontalWasFound == true){
                    break;
                }
                if (x0 == 5 || x1 == 5 || x2 == 5 || x3 == 5 || x4 == 5){
                    System.out.println("Bingo!" + "how fast(iteration):" + z + " number: " + list.get(z));
                    System.out.println("Vertical: " + x0 + " " + x1 + " " + x2 + " " + x3 + " " + x4);
                    System.out.println("Array number: " + whichArray);
                        if(whichArray == 0){
                            minIterations = z;
                        }
                        if (z < minIterations) {
                            minIterations = z;
                            minArray = array;
                        }
                    break;
                }
            }
            whichArray++;
            System.out.println("Fastest iteration: " + minIterations);
        }
        return minArray;
    }
    void printDoubleArray(String[][] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                System.out.println("WINNER TABLE: " + array[i][j]);
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Day4 advent = new Day4();
        List<String> numbers = advent.numbersToList("day4.txt");
        advent.bingo(numbers);
        advent.printDoubleArray(advent.bingo(numbers));
        }
    }

