import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'getPhoneNumber' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String getPhoneNumber(String s) {
        HashMap<String, String> wordToDigit = new HashMap<>();
        wordToDigit.put("zero", "0");
        wordToDigit.put("one", "1");
        wordToDigit.put("two", "2");
        wordToDigit.put("three", "3");
        wordToDigit.put("four", "4");
        wordToDigit.put("five", "5");
        wordToDigit.put("six", "6");
        wordToDigit.put("seven", "7");
        wordToDigit.put("eight", "8");
        wordToDigit.put("nine", "9");

        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        String currentDigit = wordToDigit.get(words[0]);
        int count = 1;

        for (int i = 1; i < words.length; i++) {
            if (wordToDigit.containsKey(words[i])) {
                if (words[i].equals(words[i - 1])) {
                    count++;
                } else {
                    if (count >= 2) {
                        result.append("double");
                        if (count >= 3) {
                            result.append("triple");
                        }
                    }
                    result.append(currentDigit);
                    count = 1;
                }
                currentDigit = wordToDigit.get(words[i]);
            }
        }

        if (count >= 2) {
            result.append("double");
            if (count >= 3) {
                result.append("triple");
            }
        }
        result.append(currentDigit);

        return result.toString();
    }

}

public class solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s  = sc.nextLine();


        String result = Result.getPhoneNumber(s);

        System.out.println(result);


    }
}
