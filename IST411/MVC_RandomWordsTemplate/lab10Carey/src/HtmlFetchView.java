/**
 *
 * @author ruc230
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HtmlFetchView extends JFrame{
    private JTextField httpURL;
    private JButton getCodeButton;
    private JTextArea httpResults;
    private HtmlFetchModel model;
    
    HtmlFetchView(HtmlFetchModel model){
        this.model = model;
        httpURL = new JTextField(50);
        getCodeButton = new JButton("Get HTTP");
        httpResults = new JTextArea();
        httpResults.setColumns(60);
        httpResults.setLineWrap(true);
        httpResults.setRows(60);
        JPanel content = new JPanel();
        content.add(httpURL);
        content.add(getCodeButton);
        content.add(httpResults);
        this.setContentPane(content);
        this.pack();
        this.setTitle("HTTP Retrieval Tool");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                  
    }
  
    public void addGetCodeButtonListener(ActionListener al) 
    {    
        getCodeButton.addActionListener(al);
    }
    
    public String getURL()
    {
        return httpURL.getText();
    }
    
    public void htmlResults(String results) {
        httpResults.setText(results);
    }
}
