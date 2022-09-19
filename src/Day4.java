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
            } catch (FileNotFoundException e) {}
            return numbers;
    }
    String[][] numberToArray(String textfile){
        File file = new File(textfile);
        String[][] array = new String[5][5];
        try {
            Scanner scanner = new Scanner(file);


        } catch (FileNotFoundException e) {}
        return array;
    }
    String[][] bingo(List<String> list) throws FileNotFoundException {
        File file = new File("day4.txt");
        Scanner scanner = new Scanner(file);

        String[][] winnerArray = new String[5][5];
        String[][] array = new String[5][5];
        scanner.nextLine();
        scanner.nextLine();

        for(int k = 0; k < 5; k++) {                           //write number to arrray
                String line = scanner.nextLine();
                int j = 0;
                for (int i = 0; i < 5; i++) {
                    array[k][i] = "" + line.charAt(j) + line.charAt(j + 1);
                    j += 3;
                }
        }
        int fastestIteration = list.size();
        //check horizontal lines in array
        for(int row = 0; row < 5; row++) {
            int horizontalCounter = 0;
            for (int i = 0; i < list.size(); i++) {             //take first number from list
                for (int j = 0; j < 5; j++) {                   //is this number in row in position from 0 to 4?
                    if (array[row][j].equals(list.get(i))) {
                        horizontalCounter++;
                        if (horizontalCounter == 5) {           //every number is different
                            System.out.println("horyzontal, iteration: " + i + " last number: " + list.get(i));
                            if(i < fastestIteration){
                                fastestIteration = i;
                            }
                        }
                    }
                }
            }
        }
        //check vertical lines in array
        for(int column = 0; column < 5; column++) {
            int verticalCounter = 0;
            for (int i = 0; i < list.size(); i++) {             //take first number from list
                for (int j = 0; j < 5; j++) {
                    if (array[j][column].equals(list.get(i))) {
                        verticalCounter++;
                        if (verticalCounter == 5) {
                            System.out.println("vertical, iteration: " + i + " last number: " + list.get(i));
                            if(i < fastestIteration){
                                fastestIteration = i;
                            }
                        }

                    }
                }
            }
        }
        System.out.println(fastestIteration);
        return winnerArray;
    }
    void printDoubleArray(String[][] array){
        for(int j = 0; j < array.length; j++){
            System.out.println("WINNER TABLE: " + array[0][j]);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Day4 advent = new Day4();
        List<String> numbers = advent.numbersToList("day4.txt");
        advent.bingo(numbers);
       // advent.printDoubleArray(advent.bingo(numbers));
    }
}

