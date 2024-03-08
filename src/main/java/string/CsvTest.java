package string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CsvTest {

    public static void main(String[] args) throws IOException {
        final File file = new File("/Users/choeseung-won/ready-to-work/algorithm/src/main/java/string/test.csv");
        final BufferedReader br = new BufferedReader(new FileReader(file));
        final String[] strings = br.readLine().split(",");

        System.out.println(Arrays.toString(strings));
    }
}
