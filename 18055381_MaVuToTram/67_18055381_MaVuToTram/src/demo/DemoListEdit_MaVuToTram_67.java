package demo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DemoListEdit_MaVuToTram_67 extends JFrame implements ActionListener {
	private JLabel lblTitle;
	private JTextField txtInput;
	private JButton btnAdd;
	private JButton btnRemove;
	private JList lstName;
	private DefaultListModel lstModelName;
	public DemoListEdit_MaVuToTram_67() {
		setSize(500, 300);
		setTitle("List Edit");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		lstModelName = new DefaultListModel();
		lstName = new JList(lstModelName);
		add(new JScrollPane(lstName), BorderLayout.CENTER);
		
		Box pRight = Box.createVerticalBox();
		Box bInput = Box.createHorizontalBox();
		Box bButton = Box.createHorizontalBox();
		
		bInput.add(Box.createRigidArea(new Dimension(10, 0)));
		bInput.add(lblTitle = new JLabel("Input Name: "));
		bInput.add(txtInput = new JTextField(20));
		bInput.add(Box.createRigidArea(new Dimension(10, 0)));
		
		bButton.add(Box.createRigidArea(new Dimension(10, 0)));
		bButton.add(btnAdd = new JButton("Add Item"));
		bButton.add(Box.createRigidArea(new Dimension(20, 0)));
		bButton.add(btnRemove = new JButton("Remove Item"));
		
		pRight.add(Box.createRigidArea(new Dimension(20, 20)));
		pRight.add(bInput, BorderLayout.NORTH);
		pRight.add(Box.createRigidArea(new Dimension(20, 20)));
		pRight.add(bButton);
		pRight.add(Box.createRigidArea(new Dimension(170, 170)));
		add(pRight, BorderLayout.EAST);
		
		btnAdd.addActionListener(this);
		btnRemove.addActionListener(this);
	}
	public static void main(String[] args) {
		new DemoListEdit_MaVuToTram_67().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnAdd)) {
			if(txtInput.getText().equals(""))
				JOptionPane.showConfirmDialog(this, "Chua nhap ten!!","Warning",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
			else {
				lstModelName.addElement(txtInput.getText());
				txtInput.setText("");
			}
		}
		else {
			int selection = JOptionPane.showConfirmDialog(this,"B???n c?? mu???n x??a ?","Th??ng b??o",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(selection == JOptionPane.YES_OPTION)
				lstModelName.removeElement(lstName.getSelectedValue());
		}
		
	}
}
