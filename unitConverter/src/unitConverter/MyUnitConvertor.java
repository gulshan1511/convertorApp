package unitConverter;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


class checkException extends Exception
{
	public checkException(String n) {
		super(n);
	}
}

interface I{
	public void Label(String labelName);
	public void comboBox(String first, String second, String third, String fourth, String[] value);
	public void textField();
	public void Label();
	public void commonButtons();
	public void convertLogic(double kilometer, double centimeter, double meter, double milimeter);
	public void currCovButton();
}

public class MyUnitConvertor extends JFrame implements I{

	private JPanel contentPane;
	JTextField t1;
	JTextField t2;
	JComboBox firstBox; 
	JComboBox secondBox;
	JLabel firstBoxLabel;
	JLabel secondBoxLabel;
	JButton convert;
	JButton reset;
	JButton exit;
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String[] units = {"unit","km","cm","m","mm"};
					MyUnitConvertor frame = new MyUnitConvertor();
					frame.Label("UNIT CONVERTER");
					frame.comboBox("kilometer", "centimeter", "meter", "milimeter", units);
					frame.textField();
					frame.Label();
					frame.commonButtons();
					double kilometer = 0.001, centimeter = 100, meter = 1, milimeter = 1000; 
					frame.convertLogic(kilometer,centimeter,meter,milimeter);
					frame.currCovButton();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	


	public MyUnitConvertor() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1103, 564);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setForeground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		firstBox = new JComboBox();
		secondBox = new JComboBox();
		t1 = new JTextField();
		t2 = new JTextField();
		firstBoxLabel = new JLabel("---");
		secondBoxLabel = new JLabel("---");
		exit = new JButton("EXIT");
		convert = new JButton("CONVERT");
		reset = new JButton("RESET");
	}
	
	public void Label(String labelName)
	{
		JLabel lblUnitConvertor = new JLabel(labelName);
		lblUnitConvertor.setForeground(Color.RED);
		lblUnitConvertor.setFont(new Font("Candara Light", Font.BOLD, 36));
		lblUnitConvertor.setBounds(373, 10, 400, 44);
		contentPane.add(lblUnitConvertor);
	}
	
	public void comboBox(String first, String second, String third, String fourth, String[] value)
	{
		
		firstBox.setForeground(Color.MAGENTA);
		
		firstBox.setModel(new DefaultComboBoxModel(new String[] {"select", first, second, third, fourth}));
		firstBox.setToolTipText("");
		firstBox.setEditable(true);
		firstBox.setFont(new Font("Tahoma", Font.BOLD, 18));
		firstBox.setBounds(95, 126, 340, 44);
		contentPane.add(firstBox);
		
		
		secondBox.setForeground(Color.MAGENTA);
		secondBox.setModel(new DefaultComboBoxModel(new String[] {"select", first, second, third, fourth}));
		secondBox.setEditable(true);
		secondBox.setFont(new Font("Tahoma", Font.BOLD, 18));
		secondBox.setBounds(596, 126, 349, 44);
		contentPane.add(secondBox);
		
		//EventListeners
		firstBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int pos = firstBox.getSelectedIndex();
				firstBoxLabel.setText(value[pos]);
			}
		});
		secondBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int pos = secondBox.getSelectedIndex();
				secondBoxLabel.setText(value[pos]);
			}
		});
	}
	public void textField()
	{
		
		t1.setFont(new Font("Tahoma", Font.BOLD, 18));
		t1.setBounds(95, 238, 340, 53);
		contentPane.add(t1);
		t1.setColumns(10);
		
		
		t2.setFont(new Font("Tahoma", Font.BOLD, 18));
		t2.setColumns(10);
		t2.setBounds(596, 238, 349, 53);
		contentPane.add(t2);
		
		JLabel lblNewLabel = new JLabel("FROM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(95, 80, 95, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("TO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(596, 84, 79, 21);
		contentPane.add(lblNewLabel_1);
	}
	
	
	
	public void Label()
	{
		firstBoxLabel.setForeground(Color.MAGENTA);
		firstBoxLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		firstBoxLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		firstBoxLabel.setBounds(95, 319, 340, 33);
		contentPane.add(firstBoxLabel);
		
		
		secondBoxLabel.setForeground(Color.MAGENTA);
		secondBoxLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		secondBoxLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		secondBoxLabel.setBounds(596, 319, 349, 33);
		contentPane.add(secondBoxLabel);
	}
	
	public void commonButtons()
	{
		
		exit.setForeground(Color.WHITE);
		exit.setBackground(Color.RED);
		exit.setFont(new Font("Tahoma", Font.BOLD, 16));
		exit.setBounds(596, 428, 95, 44);
		contentPane.add(exit);
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		reset.setBackground(Color.BLUE);
		reset.setForeground(Color.WHITE);
		reset.setFont(new Font("Tahoma", Font.BOLD, 14));
		reset.setBounds(333, 428, 95, 44);
		contentPane.add(reset);
		
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstBox.setSelectedIndex(0);
				secondBox.setSelectedIndex(0);
				t1.setText(null);
				t2.setText(null);
			}
			
		});
	}
	
	public void convertLogic(double kilometer, double centimeter, double meter, double milimeter)
	{
		convert.setForeground(Color.WHITE);
		convert.setBackground(Color.GREEN);
		convert.setFont(new Font("Tahoma", Font.BOLD, 14));
		convert.setBounds(95, 428, 123, 44);
		contentPane.add(convert);
		
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
				
				double valueInMeter = 0.0;
				
				switch(firstBox.getSelectedItem().toString())
				{
				   case "kilometer": valueInMeter = valueToConv/kilometer; break;
				   case "centimeter": valueInMeter = valueToConv/centimeter; break;
				   case "meter": valueInMeter = valueToConv/meter; break;
				   case "milimeter": valueInMeter = valueToConv/milimeter; break;
				
				
				
				}
				
				double finalValue = 0.0;
				switch(secondBox.getSelectedItem().toString())
				{
				   case "kilometer": finalValue = valueInMeter * kilometer; break;
				   case "centimeter": finalValue = valueInMeter * centimeter; break;
				   case "meter": finalValue = valueInMeter * meter; break;
				   case "milimeter": finalValue = valueInMeter * milimeter; break;
				
				
				
				}
				
				
				t2.setText(finalValue+"");
			}
		});
	}
	
	public void currCovButton()
	{
		JButton currConvtor = new JButton("CURRENCY CONVERTOR");
		currConvtor.setBackground(Color.DARK_GRAY);
		currConvtor.setForeground(Color.WHITE);
		currConvtor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		currConvtor.setBounds(845, 428, 191, 44);
		contentPane.add(currConvtor);
		
		//Listeners
		
		
		
		
		currConvtor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new currency_converter();
			}
		});
	}
}
