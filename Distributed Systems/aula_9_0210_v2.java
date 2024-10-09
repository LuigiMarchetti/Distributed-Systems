import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


public class aula_9_0210_v2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        sb.append("https://mrl0vy3w26.execute-api.sa-east-1.amazonaws.com/api");

        sb.append("/soma/"); // poderia ser soma, subtracao, divide, multiplica

        int number1 = 10; // qualquer número
        int number2 = 25; // qualquer número

        sb.append(number1).append("/").append(number2);

        try {
            // Create a URL object
            URL url = new URL(sb.toString());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) { // Check if response is OK
                try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String responseLine;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                    System.out.println("O resultado da operação é: " + response.toString());
                }
            } else {
                System.out.println("Erro " + connection.getResponseCode());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
