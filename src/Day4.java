import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Day4 {
    String lastNumber;
    int fastestIterationAllArrays;
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
    String[][] findWinnerArray(List<String> list) throws FileNotFoundException {
        File file = new File("day4.txt");
        Scanner scanner = new Scanner(file);

        String[][] winnerArray = new String[5][5];
        String[][] array = new String[5][5];
        fastestIterationAllArrays = list.size();
        scanner.nextLine();
        while(scanner.hasNextLine()) {
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            for (int k = 0; k < 5; k++) {                           //write array in rows to array[][]
                String line = scanner.nextLine();
                int j = 0;
                for (int i = 0; i < 5; i++) {
                    array[k][i] = "" + line.charAt(j) + line.charAt(j + 1);
                    j += 3;
                }
            }
            int fastestIteration = list.size();
            //check horizontal lines in array
            for (int row = 0; row < 5; row++) {
                int horizontalCounter = 0;
                for (int i = 0; i < list.size(); i++) {             //take first number from list
                    for (int j = 0; j < 5; j++) {                   //is this number in row in position from 0 to 4?
                        if (array[row][j].equals(list.get(i))) {
                            horizontalCounter++;
                            //System.out.println(array[row][j]);
                            if (horizontalCounter == 5) {           //every number is different
                                System.out.println("horyzontal, iteration: " + i + " last number: " + list.get(i));
                                if (i < fastestIteration) {
                                    fastestIteration = i;
                                }
                            }
                        }
                    }
                }
            }
            //check vertical lines in array
            for (int column = 0; column < 5; column++) {
                int verticalCounter = 0;
                for (int i = 0; i < list.size(); i++) {                  //take first number from list
                    for (int j = 0; j < 5; j++) {
                        if (array[j][column].equals(list.get(i))) {//is number in column?
                            //System.out.println(array[j][column]);
                            verticalCounter++;
                            if (verticalCounter == 5) {
                                System.out.println("vertical, iteration: " + i + " last number: " + list.get(i));
                                if (i < fastestIteration) {
                                    fastestIteration = i;
                                }
                            }
                        }
                    }
                }
            }
            //System.out.println(fastestIteration);
            if(fastestIteration < fastestIterationAllArrays){
                fastestIterationAllArrays = fastestIteration;
                for(int i = 0; i < 5; i++){
                    for(int j = 0; j <5; j++){
                        winnerArray[i][j] = array[i][j];
                    }
                }
            }
        }
        System.out.println();
        System.out.println("Fastest iteration in all arrays: " + fastestIterationAllArrays);
        System.out.println("Bingo last number: " + list.get(fastestIterationAllArrays));
        lastNumber = list.get(fastestIterationAllArrays);
        return winnerArray;
    }
    void countWinningNumber(String[][] array, List<String> list){
        //winning number is sum of non-bingo numbers in array multiply by last bingo number
        int sum = 0;
        String[][] nonBingoArray = new String[5][5];
        nonBingoArray = array.clone();
        for(int k = 0; k <= fastestIterationAllArrays; k++) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    if (array[i][j].equals(list.get(k))) {
                        nonBingoArray[i][j] = "0";
                    }
                }
            }
        }
        System.out.print("Non-bingo array: ");
        for (int i = 0; i < nonBingoArray.length; i++) {
            for (int j = 0; j <nonBingoArray.length; j++) {
                System.out.print(nonBingoArray[i][j] + " ");
                String withoutSpaces = nonBingoArray[i][j].replace(" ","");
                sum+=Integer.valueOf(withoutSpaces);
            }
        }
        System.out.println();
        System.out.println("Sum non-bingo numbers: " + sum);
        System.out.println("Last bingo number: " + lastNumber);
        System.out.println("Winning number! (Sum * Last bingo number): " + sum * Integer.valueOf(lastNumber));
    }
    public static void main(String[] args) throws FileNotFoundException {
        Day4 advent = new Day4();
        List<String> numbers = advent.numbersToList("day4.txt");
        String[][] winnerArray = advent.findWinnerArray(numbers);
        advent.countWinningNumber(winnerArray,numbers);
    }
}

