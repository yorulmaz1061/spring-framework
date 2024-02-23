import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CalculatorParameterizedTests {
    @ParameterizedTest
    //you can select parameter type according to your needs.
    @ValueSource(strings = {"Java", "JS", "TS"})
    void testCase1(String args) {
        Assertions.assertTrue(!args.isEmpty());
//Now my test case will run three times at first args will be accepted as Java, later on JS and TS
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9})
    void testCase2(int number) {
        Assertions.assertEquals(0, number % 3);
//Now my test case will run three times at first args will be accepted as 3, later on 6 and 9
    }

    //Test will run for empty source as well
    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "TS"})
    @EmptySource
    void testCase3(String args) {
        Assertions.assertTrue(!args.isEmpty());
    }

    //Test will run for empty source and null source as well
    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "TS"})
    @EmptySource
    @NullSource
    void testCase4(String args) {
        Assertions.assertTrue(!args.isEmpty());
    }

    //Test will run for  null and empty source as well
    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "TS"})
    @NullAndEmptySource
    void testCase5(String args) {
        Assertions.assertTrue(!args.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testCase6(String args) {
        Assertions.assertNotNull(args);

    }

    static String[] stringProvider() {
        return new String[]{"a", "b", "c"};
    }

    @ParameterizedTest
    @CsvSource({"10,20,30","20,20,40","40,40,80"})
    void testCase7(int num1, int num2, int result) {
        Assertions.assertEquals(result,Calculator.add(num1,num2));
    }
    @ParameterizedTest
    //Below for location of the file and for skipping title line
    @CsvFileSource(resources = "/sample-data.csv",numLinesToSkip = 1)
    void testCase6(int num1, int num2, int result){
        Assertions.assertEquals(result, Calculator.add(num1,num2));
    }




}
