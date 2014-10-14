// Justin Mercado
// PS4
package MainPackage;

import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import MainPackage.CalcGUI;
import java.text.*;

public class CalcGUI extends JPanel implements ActionListener {
	
	private double IA;
	private double years;
	private double AIR;
	
	// Calculate Button
	private JButton btCalculate;

	// Labels to identify the fields
	private JLabel IALabel;
	private JLabel yearsLabel;
	private JLabel AIRLabel;
	private JLabel FVLabel;

	// Strings for the labels
	private static String IAString = "Investment Amount";
	private static String yearsString = "Years";
	private static String AIRString = "Annual Interest Rate";
	private static String FVString = "Future Value";

	// Fields for data entry
	private JFormattedTextField IAField;
	private JFormattedTextField yearsField;
	private JFormattedTextField AIRField;
	private JFormattedTextField FVField;

	// Formats to format and parse numbers
	private NumberFormat IAFormat;
	private NumberFormat AIRFormat;
	private NumberFormat FVFormat;


	public CalcGUI() {
		super(new BorderLayout());
		double FV= 0;
		
		// Calculate Button
		btCalculate = new JButton("Calculate");
		btCalculate.addActionListener(this);
		
		// Create the labels.
		IALabel = new JLabel(IAString);
		yearsLabel = new JLabel(yearsString);
		AIRLabel = new JLabel(AIRString);
		FVLabel = new JLabel(FVString);

		// Create the text fields and set them up.
		IAField = new JFormattedTextField(IAFormat);
		IAField.setValue(new Double(IA));
		IAField.setColumns(10);

		yearsField = new JFormattedTextField();
		yearsField.setValue(new Double(years));
		yearsField.setColumns(10);

		AIRField = new JFormattedTextField(AIRFormat);
		AIRField.setValue(new Double(AIR));
		AIRField.setColumns(10);

		FVField = new JFormattedTextField(FVFormat);
		FVField.setValue(new Double(FV));
		FVField.setColumns(10);
		FVField.setEditable(false);
		FVField.setForeground(Color.red);

		// Tell accessibility tools about label/textfield pairs.
		IALabel.setLabelFor(IAField);
		yearsLabel.setLabelFor(yearsField);
		AIRLabel.setLabelFor(AIRField);
		FVLabel.setLabelFor(FVField);

		// Lay out the labels in a panel.
		JPanel labelPane = new JPanel(new GridLayout(0, 1));
		labelPane.add(IALabel);
		labelPane.add(yearsLabel);
		labelPane.add(AIRLabel);
		labelPane.add(FVLabel);

		// Layout the text fields in a panel.
		JPanel fieldPane = new JPanel(new GridLayout(0, 1));
		fieldPane.add(IAField);
		fieldPane.add(yearsField);
		fieldPane.add(AIRField);
		fieldPane.add(FVField);
	       

		// Put the panels in this panel, labels on left,
		// text fields on right.
		setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		add(labelPane, BorderLayout.CENTER);
		add(fieldPane, BorderLayout.LINE_END);
		add(btCalculate, BorderLayout.AFTER_LAST_LINE);
	}
	

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		double IA = Double.parseDouble(IAField.getText());
		double years = Double.parseDouble(yearsField.getText());
		double AIR = Double.parseDouble(AIRField.getText());
		
		Calculate FV = new Calculate(IA, years, AIR);
		
		double answer = FV.FutureValue();
		
		FVField.setValue(new Double(answer));
		FVField.setText(String.format("%.2f", answer));
		}    
    
    public static void main(String[] args) {
    	//Create and set up the window.
        JFrame frame = new JFrame("Calculate Future Value");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add contents to the window.
        frame.add(new CalcGUI());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}
