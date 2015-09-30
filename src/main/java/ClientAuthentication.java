import net.iharder.Base64;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
public class ClientAuthentication {

    public static int Authenticate(String urlStr, String user, String pass, String outFilePath) {
        try {
            // URL url = new URL ("http://ip:port/download_url");
            URL url = new URL(urlStr);
            String authStr = user + ":" + pass;
            String authEncoded = Base64.encodeBytes(authStr.getBytes());

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + authEncoded);

            File file = new File(outFilePath);
            InputStream in = (InputStream) connection.getInputStream();
            OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
            for (int b; (b = in.read()) != -1;) {
                out.write(b);
            }
            out.close();
            in.close();
            return connection.getResponseCode();
        }
        catch (Exception e) {
        }

        return 401;

    }

}