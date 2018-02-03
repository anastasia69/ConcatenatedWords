import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Anastasia on 03.02.2018.
 */

public class ReadFile {

    private static Set<String> dataList = new HashSet<>();

    private static Set<String> readFileAndSortData(String fileName) {

       try {
            Stream<String> stream = Files.lines(Paths.get(fileName));

            dataList = stream
                    .sorted((o1, o2) -> Integer.compare(o2.length(), o1.length()))
                    .collect(Collectors.toCollection(LinkedHashSet::new));

        }catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }

    public static Set<String> returnSortedData(String fileName) {
        return readFileAndSortData(fileName)
                .stream()
                .sorted((o1, o2) -> Integer.compare(o2.length(), o1.length()))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
