import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class aula_9_0210 {
    public static void main(String[] args) {
        String urlStringEmpresaA = "https://starksystem.vercel.app:443/api";
        String urlStringEmpresaB = "https://brrobotics.vercel.app:443/api";

        getDesconto("Empresa A", urlStringEmpresaA);
        getDesconto("Empresa B", urlStringEmpresaB);
    }

    public static void getDesconto(String empresa, String urlString) {
        try {
            URL url = new URL(urlString);
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
                    System.out.println(empresa + ": " + response.toString());
                }
            } else {
                System.out.println("Erro " + connection.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
