/* Example 7.6
GUIWindow.java
The main view for a GUI-based temperature conversion 
program that coverts from Fahrenheit to Celsius and back again.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class GUIWindow extends JFrame{

   // >>>>>>> The model <<<<<<<<

   // Declare and intantiate the thermometer    
   private Thermometer thermo;

   // >>>>>>> The view <<<<<<<<

   // Declare and instantiate the window objects.
   private JLabel fahrLabel;
   private JLabel celsiusLabel;         
   private JTextField fahrField;  
   private JTextField celsiusField;
   private JButton fahrButton;
   private JButton celsiusButton;
   // Constructor
   public GUIWindow(){
      setTitle("F to C Converter");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(300,200);
   	
   	thermo = new Thermometer();
      // Set up panels to organize widgets and
      // add them to the window
   	fahrLabel        = new JLabel("Degrees Fahrenheit");
    celsiusLabel     = new JLabel("Degrees Celsius");         
    fahrField    = new JTextField("32.0");  
    celsiusField = new JTextField("0.0");
    fahrButton      = new JButton("Convert>>");
    celsiusButton   = new JButton("<<Convert");
      Container container = getContentPane();
      container.setLayout(null);
      fahrLabel.setBounds(20,20,100,20);
      container.add(fahrLabel);
      celsiusLabel.setBounds(150,20,100,20);
      container.add(celsiusLabel);
      fahrField.setBounds(20,60,100,20);
      container.add(fahrField);
      celsiusField.setBounds(150,60,100,20);
      container.add(celsiusField);
      fahrButton.setBounds(20,100,100,20);
      container.add(fahrButton);
      celsiusButton.setBounds(150,100,100,20);
      container.add(celsiusButton);
//      check = new JCheckBox("Units");
  //    check.setBounds(20, 140, 100,20);
    //  container.add(check);
      // Attach a listener to the convert button
      fahrButton.addActionListener(new FahrenheitListener());
      CelsiusListener cl;
      cl = new CelsiusListener(); 
      celsiusButton.addActionListener(cl); 
      setVisible(true);    //Make the window visible
   }
   
   // >>>>>>> The controller <<<<<<<<

   private class FahrenheitListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         String input = fahrField.getText();       // Obtain input
         double fahr = Double.parseDouble(input);  // Convert to double
         double celsius = (fahr-32.0)*5./9.;
         String ans = String.format("%2.2f", celsius);
         celsiusField.setText(ans);       // output result
       }
   }

   private class CelsiusListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         String input = celsiusField.getText();        // Obtain input
         double celsius = Double.parseDouble(input);   // Convert to double
         double fahr = celsius*9.0/5.0+32.0;
         String ans = String.format("%2.2f", fahr);
         fahrField.setText(ans);                 // Output result
      }
   }

}
