package demo;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class DemoComboBox_MaVuToTram_67 extends JFrame implements ActionListener {
	private JLabel lbl;
	private JComboBox cont;
	public DemoComboBox_MaVuToTram_67() {
		setTitle("Demo ComboBox");
		setSize(340, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		lbl = new JLabel("The quick brown fox jumps over the lazy dog",SwingConstants.CENTER);
		lbl.setFont(new Font("Serif",Font.PLAIN,16));
		add(lbl,BorderLayout.CENTER);
		
		cont = new JComboBox();
		cont.addItem("Serif");
		cont.addItem("SansSerif");
		cont.addItem("Monospaced");
		add(cont,BorderLayout.SOUTH);
		
		cont.addActionListener(this);
	}
	public static void main(String[] args) {
		new DemoComboBox_MaVuToTram_67().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Font f = lbl.getFont();
		String fontName = (String)cont.getSelectedItem();
		lbl.setFont(new Font(fontName,f.getStyle(),f.getSize()));
		
	}
}
