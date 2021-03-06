package uebung06.name.panitz.oose13.dialogue;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Dialogue extends JFrame{
	final JTextField inputField = new JTextField(20);
	final JTextField outputField = new JTextField(20);
	final JPanel p = new JPanel();

	Dialogue(final ButtonLogic logic) {
		final JButton button = new JButton(logic.getDescription());
		button.addActionListener
		(new ActionListener() {
			public void actionPerformed (ActionEvent actionEvent) {
				outputField.setText(logic.eval(inputField.getText().trim()));
			}
		});
		p.setLayout (new BorderLayout());
		p.add(inputField, BorderLayout.NORTH);
		p.add(button, BorderLayout.CENTER);
		p.add(outputField, BorderLayout.SOUTH);
		getContentPane().add(p);
		pack();
		setVisible(true);
	}
}