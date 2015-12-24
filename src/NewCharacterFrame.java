import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewCharacterFrame extends JFrame {
	private JTextField nameField;
	private JComboBox<String> typeBox;
	private JButton goBtn;
	private JLabel errorMsg;
	private JButton clrBtn;

	public NewCharacterFrame() {
		this.setBounds(100, 100, 350, 200);
		this.setTitle("Create a New Character");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel thePane = new JPanel();
		thePane.setLayout(null);

		JLabel introTxt = new JLabel("<html>Welcome to the Legend of Blatt. Please enter the<br>following information to create your character.</html>");
		introTxt.setBounds(10, -100, 400, 250);
		thePane.add(introTxt);

		JLabel nameL = new JLabel("Name:");
		nameL.setBounds(10, 50, 40, 30);
		thePane.add(nameL);
		nameField = new JTextField(20);
		nameField.setBounds(60, 50, 200, 30);
		thePane.add(nameField);

		JLabel typeL = new JLabel("Type:");
		typeL.setBounds(10, 80, 40, 30);
		thePane.add(typeL);
		typeBox = new JComboBox<String>();
		typeBox.addItem("--Choose--");
		typeBox.addItem("Warrior");
		typeBox.addItem("Thief");
		typeBox.addItem("Wizard");
		typeBox.setBounds(60, 80, 100, 30);
		typeBox.addItemListener(new cBoxListener());
		thePane.add(typeBox);

		clrBtn = new JButton("Clear");
		clrBtn.setBounds(65,120,100,30);
		clrBtn.addActionListener(new ClrListener());
		thePane.add(clrBtn);
		
		goBtn = new JButton("Start");
		goBtn.setBounds(185, 120, 100, 30);
		goBtn.addActionListener(new BtnListener());
		thePane.add(goBtn);
		
		errorMsg = new JLabel("Error: Choose name and type.");
		errorMsg.setBounds(10,150,200,30);
		errorMsg.setVisible(false);
		thePane.add(errorMsg);
		
		this.setContentPane(thePane);
	}

	class cBoxListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if (e.getStateChange() == ItemEvent.SELECTED) {
				System.out.printf("%s was selected\n", e.getItem().toString());
			}
			else if (e.getStateChange() == ItemEvent.DESELECTED) {
				System.out.printf("%s was deselected\n", e.getItem().toString());
			}
			
			//nameField.setText("Loser!");
		}
		
	}
	
	class ClrListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			nameField.setText("");
			typeBox.setSelectedIndex(0);
		}
	}
	
	class BtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("You chose name: " + nameField.getText());
			System.out.println("You chose type: "
					+ typeBox.getSelectedItem().toString());
			
			if (nameField.getText().trim().equals("")) {
				errorMsg.setVisible(true);
				return;
			}
			
			if (typeBox.getSelectedIndex() == 0) {
				errorMsg.setVisible(true);
				return;
			}
			
			int numtype=1;
			switch(typeBox.getSelectedItem().toString()) {
			case "Warrior":
				numtype = 1;
				break;
			case "Wizard":
				numtype = 3;
				break;
			case "Thief":
				numtype = 2;
				break;
			}
			
			Player p = new Player(nameField.getText(), numtype);
			NewCharacterFrame.this.dispose();
			new Blatt(p);
		}
	}

	public static void main(String args[]) {
		NewCharacterFrame n = new NewCharacterFrame();
		n.setVisible(true);
	}
}
