
/**
 *
 * @author ruc230
 */

public class App {
    public static void main(String[] args) {
        HtmlFetchModel model = new HtmlFetchModel();
        HtmlFetchView view = new HtmlFetchView(model);
        HtmlFetchController controller = new HtmlFetchController(model, view);
        
        view.setVisible(true);
    }
}


