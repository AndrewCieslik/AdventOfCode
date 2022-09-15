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
    void bingo(List<String> list) throws FileNotFoundException {
        File file = new File("day4test.txt");
        Iterator iterator = list.iterator();
        String[][] array = new String[5][5];
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        scanner.nextLine();
        //while(iterator.hasNext()) {
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
            int whichArray = 0;
            int x0 = 0;
            int x1 = 0;
            int x2 = 0;
            int x3 = 0;
            int x4 = 0;
            for (int k = 0; k < list.size(); k++) {
                for (int i = 0; i < 5; i++) {
                    if (list.get(k).equals(array[i][0])) {
                        x0++;
                    }
                    if (list.get(k).equals(array[i][1])) {
                        x1++;
                    }
                    if (list.get(k).equals(array[i][2])) {
                        x2++;
                    }
                    if (list.get(k).equals(array[i][3])) {
                        x3++;
                    }
                    if (list.get(k).equals(array[i][4])) {
                        x4++;
                    }
                    if ((x0+x1+x2+x3+x4 == 5) && (x0 > 0 && x1 > 0 && x2 > 0 && x3 > 0 && x4 > 0)) {
                                System.out.println("Bingo!" + "how fast(iteration):" + k + " number: " + list.get(k));
                                System.out.println("Horizontal: " + x0 + " " + x1 + " " + x2 + " " + x3 + " " + x4);
                                break;
                    }
                }
                if (x0 == 5 || x1 == 5 || x2 == 5 || x3 == 5 || x4 == 5){
                        System.out.println("Bingo!" + "how fast(iteration):" + k + " number: " + list.get(k));
                        System.out.println("Vertical: " + x0 + " " + x1 + " " + x2 + " " + x3 + " " + x4);
                        break;
                }
            }
            System.out.println(whichArray);
            whichArray++;
        //}
    }

    public static void main(String[] args) throws FileNotFoundException {
        Day4 advent = new Day4();
        List<String> numbers = advent.numbersToList("day4test.txt");
        advent.bingo(numbers);
        }

    }

