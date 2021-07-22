package unitConverter;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class currency_converter extends MyUnitConvertor implements I {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					currency_converter frame = new currency_converter();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	


	public currency_converter() {
		super();
		setBounds(100, 100, 1103, 564);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		String[] curr = {"currency","Rupees","Dollar","Peso","Dollar"};
		Label("CURRENCY CONVERTOR");
		comboBox("india","america","phillippine","canada",curr);
		textField();
		Label();
		commonButtons();
		double india = 101.38, america = 1.36, phillippine = 68.56, canada = 1.73;
		convertLogic(india,america,phillippine,canada);

	}
	
	public void convertLogic(double india, double america, double phillippine, double canada)
	{
		JButton convert = new JButton("CONVERT");
		convert.setForeground(Color.WHITE);
		convert.setBackground(Color.GREEN);
		convert.setFont(new Font("Tahoma", Font.BOLD, 14));
		convert.setBounds(95, 428, 123, 44);
		add(convert);
		
		convert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ExceptionHandling
				try {
					if(firstBox.getSelectedIndex()==0 || secondBox.getSelectedIndex()==0 || t1.getText()==null)
					{
						//GUI mode of exception Handling
						JFrame f = new JFrame(); 
					    JOptionPane.showMessageDialog(f,"Units to convert are unselected and the unit value are is null","Alert",JOptionPane.WARNING_MESSAGE);
					    //handling exception by throwing self created objects 
					    throw new checkException("Exception found!!");
					}
				}
				
				catch(checkException ex)
				{
					System.out.println(ex.getMessage());
					System.out.println("The Units was unselected and Values in text field was NULL");
				}
				
				double valueToConv = Double.parseDouble(t1.getText());
				
				double valueInPounds = 0.0;
				
				switch(firstBox.getSelectedItem().toString())
				{
				   case "india": valueInPounds = valueToConv/india; break;
				   case "america": valueInPounds = valueToConv/america; break;
				   case "phillippine": valueInPounds = valueToConv/phillippine; break;
				   case "canada": valueInPounds = valueToConv/canada; break;
				
				
				}
				
				double finalValue = 0.0;
				switch(secondBox.getSelectedItem().toString())
				{
				   case "india": finalValue = valueInPounds * india; break;
				   case "america": finalValue = valueInPounds * america; break;
				   case "phillippine": finalValue = valueInPounds * phillippine; break;
				   case "canada": finalValue = valueInPounds * canada; break;
				
				
				
				}
				
				
				t2.setText(finalValue + "");
			}
		});
	}

}
