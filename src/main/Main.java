package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        String soubor = "src/main/resources/Day1_input.txt";

        List<Integer> seznam = new ArrayList<>();

        int combinedValue = 0;
        int hodnota = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(soubor))) {
            String line;
            Pattern pattern = Pattern.compile("\\d");

            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                StringBuilder digits = new StringBuilder();

                // Najdeme všechny číslice v řádku
                while (matcher.find()) {
                    digits.append(matcher.group());
                }

                if (digits.length() >= 2) {
                    // zjistím první a poslední číslici  - v řádku jsou min. 2 čísla
                    int firstDigit = Character.getNumericValue(digits.charAt(0));
                    int lastDigit = Character.getNumericValue(digits.charAt(digits.length() - 1));
                    combinedValue = firstDigit * 10 + lastDigit;
                    System.out.println("Kalibrační hodnota: " + combinedValue);
                    seznam.add(combinedValue);


                } else {
                    //řádek, kde je jen jedno číslo
                    int firstDigit = Character.getNumericValue(digits.charAt(0));
                    hodnota = firstDigit * 10 + firstDigit;
                    System.out.println("Kalibrační hodnota: " + hodnota);
                    seznam.add(hodnota);
                }
            }
        } catch (IOException e) {
            System.err.println("Chyba při čtení souboru: " + e.getMessage());
        }

        System.out.println(seznam);
        int sum = seznam.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(sum);

    }
}



