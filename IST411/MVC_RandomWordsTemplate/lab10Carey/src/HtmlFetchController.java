
/**
 *
 * @author ruc230
 */
import java.awt.event.*;

public class HtmlFetchController {
    private HtmlFetchModel model;
    private HtmlFetchView view;

    HtmlFetchController(HtmlFetchModel model, HtmlFetchView view) {
        this.model = model;
        this.view = view;
                
        class ButtonListener implements ActionListener {            
            public void actionPerformed(ActionEvent e)
            {
                view.htmlResults(model.getURLHtml(view.getURL()));
            }
        }
        view.addGetCodeButtonListener(new ButtonListener());                        
    }        
}
