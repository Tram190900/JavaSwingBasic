package demo;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DemoCheckBox_MaVuToTram_67 extends JFrame implements ItemListener {
	private javax.swing.JTextField txt_text;
	private JCheckBox bold;
	private JCheckBox italic;
	public DemoCheckBox_MaVuToTram_67() {
		setTitle("Demo check box");
		setSize(300, 130);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel p1 = new JPanel();
		txt_text = new JTextField("Watch the font style change",20);
		txt_text.setFont(new Font("Serif",Font.PLAIN,16));
		p1.add(txt_text);
		add(p1, BorderLayout.NORTH);
		
		Box b = Box.createVerticalBox();
		Box bButton = Box.createHorizontalBox();
		bButton.add(bold = new JCheckBox("Bold"));
		bButton.add(italic = new JCheckBox("Italic"));
		b.add(bButton);
		add(b,BorderLayout.CENTER);
		
		bold.addItemListener(this);
		italic.addItemListener(this);
	}
	public static void main(String[] args) {
		new DemoCheckBox_MaVuToTram_67().setVisible(true);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		Font f = txt_text.getFont();
		if(e.getItem()==bold)
			txt_text.setFont(new Font(f.getName(),f.getStyle()^Font.BOLD,f.getSize()));
		if(e.getItem()==italic)
			txt_text.setFont(new Font(f.getName(),f.getStyle()^Font.ITALIC,f.getSize()));
		
	}
}
