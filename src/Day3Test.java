import org.junit.jupiter.api.Test;

import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Day3Test {

    @Test
    void calculateOxygenTest() {
        Day3 advent = new Day3();
        ArrayList<String> arrayTest = new ArrayList<>();
        arrayTest.add("11");
        arrayTest.add("00");
        assertEquals(arrayTest,advent.oxygenGeneratorRating(arrayTest, 0));

    }


}