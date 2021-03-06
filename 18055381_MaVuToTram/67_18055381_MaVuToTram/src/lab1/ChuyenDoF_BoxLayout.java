package lab1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChuyenDoF_BoxLayout extends JFrame implements ActionListener {
	private JTextField txtDoF;
	private JLabel lblDoC;
	private JPanel pannel;
	private JTextField txtDoC;
	private JButton btnKetQua;
	private JButton btnThoat;
	public ChuyenDoF_BoxLayout() {
		this.setTitle("Chuyen do F thanh do C");
		this.setSize(250,150);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Box b = Box.createVerticalBox();
		Box pDoF = Box.createHorizontalBox();
		Box pDoC = Box.createHorizontalBox();
		Box pButton = Box.createHorizontalBox();
		
		JLabel lblDoF;
		pDoF.add(Box.createRigidArea(new Dimension(10, 0)));
		pDoF.add(lblDoF = new JLabel("Do F can chyen: "));
		txtDoF = new JTextField(3);
		pDoF.add(txtDoF);
		pDoF.add(Box.createRigidArea(new Dimension(10, 0)));
		
		JLabel lblC;
		pDoC.add(Box.createRigidArea(new Dimension(10, 0)));
		pDoC.add(lblC = new JLabel("Ket qua nhan duoc: "));
		txtDoC = new JTextField(3);
		pDoC.add(txtDoC);
		pDoC.add(Box.createRigidArea(new Dimension(10, 0)));
		
		lblDoF.setPreferredSize(lblC.getPreferredSize());;
		
		pButton.add(Box.createHorizontalGlue());
		pButton.add(btnKetQua = new JButton("Xuat ket qua"));
		pButton.add(Box.createHorizontalGlue());
		pButton.add(btnThoat = new JButton("Ket thuc"));
		pButton.add(Box.createHorizontalGlue());
		
		b.add(Box.createRigidArea(new Dimension(10, 10)));
		b.add(pDoF);
		b.add(Box.createRigidArea(new Dimension(10, 10)));
		b.add(pDoC);
		b.add(Box.createRigidArea(new Dimension(10, 10)));
		b.add(pButton);
		
		add(b,BorderLayout.NORTH);
		
		txtDoF.addActionListener(this);
		btnKetQua.addActionListener(this);
		btnThoat.addActionListener(this);
	}
	public static void main(String[] args) {
		new ChuyenDoF_BoxLayout().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(txtDoF) || obj.equals(btnKetQua)) {
			int doF, doC;
			doF = Integer.parseInt(txtDoF.getText());
			doC = (doF-32)*5/9;
			txtDoC.setText(Integer.toString(doC));
		}
		else
			System.exit(0);
	}
}
