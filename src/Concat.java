import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Anastasia on 03.02.2018.
 */

public class Concat {

    private Set<String> sortedList;
    private Set<String> concatWordsList = new HashSet<>();
    private String tempWord;

    public List<String> FindLongestWord(String fileName) {
        assert fileName != null;

        sortedList = ReadFile.returnSortedData(fileName);
        assert sortedList != null;

        sortedList.forEach(word -> {
            tempWord = word;
            isConcat(word);
        });

        List<String> result = concatWordsList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .skip(concatWordsList.size() - 2)
                .collect(Collectors.toList());

        result.add(String.valueOf(concatWordsList.size()));

        return result;
    }

    private void isConcat(String word) {

        for (int i = 0; i < word.length(); i++){
            String leftPart = word.substring(0, i+1);
            String rightPart = word.substring(i+1);

            if (sortedList.contains(leftPart)) {
                if (sortedList.contains(rightPart)){
                    concatWordsList.add(tempWord);

                    break;
                }
                isConcat(rightPart);
            }
        }
    }
}
