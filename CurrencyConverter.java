import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {

    @SuppressWarnings("UseSpecificCatch")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Currency Converter");
        System.out.print("Enter Base Currency (e.g., USD, INR): ");
        String baseCurrency = scanner.next().toUpperCase();
        System.out.print("Enter Target Currency (e.g., EUR, JPY): ");
        String targetCurrency = scanner.next().toUpperCase();
        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();
        try {
            String urlStr = "https://api.exchangerate-api.com/v4/latest/" + baseCurrency;
            URL url = URI.create(urlStr).toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();
            String searchKey = "\"" + targetCurrency + "\":";
            int index = response.indexOf(searchKey);
            if (index != -1) {
                int start = index + searchKey.length();
                int end = response.indexOf(",", start);
                if (end == -1) end = response.indexOf("}", start);
                String rateStr = response.substring(start, end).trim();
                double rate = Double.parseDouble(rateStr);
                double convertedAmount = amount * rate;
                System.out.printf("\n%.2f %s = %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);
            } else {
                System.out.println("Invalid target currency or data not found.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }
}
