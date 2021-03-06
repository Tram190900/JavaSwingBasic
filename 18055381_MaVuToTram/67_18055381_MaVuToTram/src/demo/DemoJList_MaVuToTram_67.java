package demo;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DemoJList_MaVuToTram_67 extends JFrame implements ListSelectionListener {
	private JTextField txtItems;
	private JList lstEntry;
	public DemoJList_MaVuToTram_67() {
		setTitle("Simple JList");
		setSize(300, 210);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel pJList = new JPanel();
		pJList.setBorder(BorderFactory.createTitledBorder("Simple JList"));
		String[] entries = {"Entry 1","Entry 2","Entry 3","Entry 4","Entry 5","Entry 6"};
		
		lstEntry = new JList(entries);
		lstEntry.setVisibleRowCount(4);
		JScrollPane lstPane = new JScrollPane(lstEntry);
		pJList.add(lstPane);
		add(pJList,BorderLayout.CENTER);
		
		Box b = Box.createVerticalBox();
		b.setBorder(BorderFactory.createTitledBorder("List Selection"));
		Box b1 = Box.createHorizontalBox();
		b1.add(Box.createRigidArea(new Dimension(30,0)));
		b1.add(new JLabel("Last Selection: "));
		b1.add(txtItems = new JTextField(20));
		b1.add(Box.createRigidArea(new Dimension(30,0)));
		
		b.add(Box.createRigidArea(new Dimension(10,10)));
		b.add(b1);
		b.add(Box.createRigidArea(new Dimension(10,10)));
		add(b,BorderLayout.SOUTH);
		
		lstEntry.addListSelectionListener(this);
	}
	public static void main(String[] args) {
		new DemoJList_MaVuToTram_67().setVisible(true);
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		txtItems.setText(lstEntry.getSelectedValue().toString());
		
	}
	
}
