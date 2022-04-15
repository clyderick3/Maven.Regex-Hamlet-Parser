import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    //start with tests. Test code before implementing.

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        //Given
        String hamlet = "Hamlet";
        String expected = "Leon";
        //When
        Pattern pattern = Pattern.compile(hamlet);
        Matcher matcher = pattern.matcher(expected);
        String actual = matcher.replaceAll(expected);
        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testChangeHoratioToTariq() {
        //Given
        String horatio = "Horatio";
        String expected = "Tariq";
        //When
        Pattern pattern = Pattern.compile(horatio);
        Matcher matcher = pattern.matcher(expected);
        String actual = matcher.replaceAll(expected);
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {
        //Given
        String expected = "Horatio";
        //When
        Pattern pattern = Pattern.compile(expected);
        Matcher matcher = pattern.matcher(expected);
        Integer count = 0;
        //Then
        while (matcher.find()) {
            count++;
        }
        Assert.assertTrue(count > 0);
    }

    @Test
    public void testFindHamlet() {
    }
}