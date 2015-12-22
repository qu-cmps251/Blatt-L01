import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		typeBox.addItem("Warrior");
		typeBox.addItem("Thief");
		typeBox.addItem("Wizard");
		typeBox.setBounds(60, 80, 100, 30);
		thePane.add(typeBox);

		goBtn = new JButton("Start");
		goBtn.setBounds(125, 120, 100, 30);
		goBtn.addActionListener(new BtnListener());
		thePane.add(goBtn);

		this.setContentPane(thePane);
	}


	
	class BtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("You chose name: " + nameField.getText());
			System.out.println("You chose type: "
					+ typeBox.getSelectedItem().toString());
			
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
