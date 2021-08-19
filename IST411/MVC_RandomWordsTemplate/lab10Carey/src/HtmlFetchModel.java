
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 *
 * @author ruc230
 */
public class HtmlFetchModel {
    private URLConnection URL;
    private String Html;
    HtmlFetchModel()
    {
    }

    String getURLHtml(String URLString) {
        try {
            URL = new URL("https://" + URLString).openConnection();
            Scanner scan = new Scanner(URL.getInputStream());
            scan.useDelimiter("\\Z");
            Html = scan.next();
            scan.close();            
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return Html;
    }
}
