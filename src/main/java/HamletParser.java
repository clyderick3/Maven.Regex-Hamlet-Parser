import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private static String hamletData;
    static String originalHamlet = "Hamlet";
    static String originalHoratio = "Horatio";
    static String leon = "Leon";
    static String tariq = "Tariq";

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public static String replaceHamlet(){
        Pattern pattern = Pattern.compile(originalHamlet);
        Matcher matcher = pattern.matcher(hamletData);
        hamletData = matcher.replaceAll(leon);
        return hamletData;
    }

    public static String replaceHoratio(){
        Pattern pattern = Pattern.compile(originalHoratio);
        Matcher matcher = pattern.matcher(hamletData);
        hamletData = matcher.replaceAll(tariq);
        return hamletData;
    }

    public static void toPrint(){
        System.out.println(hamletData);
    }

}
