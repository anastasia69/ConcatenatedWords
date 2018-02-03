import java.util.List;

/**
 * Created by Anastasia on 03.02.2018.
 */

public class Main {

    public static void main(String[] args) {

        Concat concat = new Concat();

        List <String> result = concat.FindLongestWord("words.txt");
        System.out.println("The 1st longest concatenated word - " + result.get(1) + "\n" +
                "The 2nd longest concatenated word - " + result.get(0) + "\n" +
                "The total number of concatenated words - " + result.get(2));

    }
}
