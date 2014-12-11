package Window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTable;

public class GUIWindow {

	
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	private int sum = 0;
	private int add1 = 0;
	private int add10 = 0;
	private int add100 = 0;
	private JTable table;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIWindow window = new GUIWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow][grow]", "[grow][grow][grow]"));
		
		
		
		JRadioButton Add1Button = new JRadioButton("Add 1");
		Add1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(add1 == 0){
					add1 = 1;
				} else if(add1 == 1){
					add1 = 0;
				}
			}
		});
		frame.getContentPane().add(Add1Button, "cell 1 0");
		
		JRadioButton add10Button = new JRadioButton("Add 10");
		add10Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(add10 == 0){
					add10 = 10;
				} else if(add10 == 10){
					add10 = 0;
				}
			}
		});
		frame.getContentPane().add(add10Button, "cell 1 1");

		
		JRadioButton add100Button = new JRadioButton("Add 100");
		add100Button.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(add100 == 0){
					add100 = 100;
				} else if(add100 == 100){
					add100 = 0;
				}
			}
		});
		
		table = new JTable();
		frame.getContentPane().add(table, "cell 0 2,grow");
		frame.getContentPane().add(add100Button, "cell 1 2");

		
		JTextArea outputWindow = new JTextArea();
		outputWindow.setFont(new Font("Optima", Font.PLAIN, 35));
		outputWindow.setToolTipText("Output from additions");
		outputWindow.setForeground(SystemColor.windowText);
		outputWindow.setBackground(SystemColor.window);
		outputWindow.setText(Integer.toString(sum));
		outputWindow.setEditable(false);
		frame.getContentPane().add(outputWindow, "cell 0 1,alignx center,aligny center");
		
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//read the state of the buttons, and sum the results. 
				sum = add1 + add10 + add100;
				outputWindow.setText(Integer.toString(sum));
			}
		});
		frame.getContentPane().add(btnCalculate, "cell 0 0");
	}

}
