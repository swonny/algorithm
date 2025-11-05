import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        final boolean result1 = input.contains("D2");
        final boolean result2 = input.contains("d2");
        if (result1 || result2) {
            System.out.println("D2");

        } else {
            System.out.println("unrated");
        }
    }
}



