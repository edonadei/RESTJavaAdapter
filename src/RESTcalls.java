import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class RESTcalls {

    public static void APIPost(String string, String URL) {
        try {
            URL url = new URL(URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // PAS BON, à modifier
            String urlParameters = "update=" + URLEncoder.encode(string, java.nio.charset.StandardCharsets.UTF_8.toString());

            conn.setRequestMethod("POST");
            conn.setRequestProperty("User-Agent", "Java client");
            conn.addRequestProperty("content-type", "application/x-www-form-urlencoded");

            conn.setDoOutput(true);
            OutputStream stream = conn.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(stream);
            writer.write(urlParameters);
            writer.close();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200)
            {
                System.out.println("Fail, error " + responseCode + " when sending to API");
                System.exit(0);
            }
            System.out.println("\nSending 'POST' request to URL : " + url);
            //System.out.println("Post parameters : " + urlParameters);
            System.out.println("Response Code : " + responseCode);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void APIGet(String string, String URL) {
        try {
            URL url = new URL(URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // PAS bon, à modifier
            String urlParameters = "update=" + URLEncoder.encode(string, java.nio.charset.StandardCharsets.UTF_8.toString());

            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Java client");
            conn.addRequestProperty("content-type", "application/x-www-form-urlencoded");

            conn.setDoOutput(true);
            OutputStream stream = conn.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(stream);
            writer.write(urlParameters);
            writer.close();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200)
            {
                System.out.println("Fail, error " + responseCode + " when sending to API");
                System.exit(0);
            }
            System.out.println("\nSending 'GET' request to URL : " + url);
            //System.out.println("Post parameters : " + urlParameters);
            System.out.println("Response Code : " + responseCode);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
