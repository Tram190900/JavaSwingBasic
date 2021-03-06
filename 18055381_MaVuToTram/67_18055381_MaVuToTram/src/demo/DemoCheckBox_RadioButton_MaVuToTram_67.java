package demo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DemoCheckBox_RadioButton_MaVuToTram_67 extends JFrame implements ActionListener, ItemListener {
	private JCheckBox chkItalic;
	private JRadioButton radLeft;
	private JRadioButton radRight;
	private JLabel lbl;
	private ButtonGroup group;
	public DemoCheckBox_RadioButton_MaVuToTram_67() {
		setTitle("Demo CheckBox and RadioButton");
		setSize(300, 120);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		b1.add(chkItalic = new JCheckBox("Italic"));
		b1.add(radLeft = new JRadioButton("Left",true));
		b1.add(radRight = new JRadioButton("Right"));
		group = new ButtonGroup();
		group.add(radLeft);group.add(radRight);
		b.add(Box.createRigidArea(new Dimension(10, 10)));
		b.add(b1);
		add(b,BorderLayout.NORTH);
		
		lbl = new JLabel("Hello World");
		lbl.setFont(new Font("Serif",Font.PLAIN,16));
		add(lbl);
		
		chkItalic.addItemListener(this);
		radLeft.addActionListener(this);
		radRight.addActionListener(this);
	}
	public static void main(String[] args) {
		new DemoCheckBox_RadioButton_MaVuToTram_67().setVisible(true);
	}
	@Override	
	public void itemStateChanged(ItemEvent e) {
		if(e.getItem()==chkItalic)
			lbl.setFont(new Font(lbl.getFont().getName(), lbl.getFont().getStyle()^Font.ITALIC, lbl.getFont().getSize()));
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(radLeft))
			lbl.setHorizontalAlignment(SwingConstants.LEFT);
		else if(obj.equals(radRight))
			lbl.setHorizontalAlignment(SwingConstants.RIGHT);
	}
}
