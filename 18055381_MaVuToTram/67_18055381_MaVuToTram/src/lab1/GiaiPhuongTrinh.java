package lab1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class GiaiPhuongTrinh extends JFrame implements ActionListener {
	private JPanel panelTitle;
	private JLabel lblTitle;
	private Box bInput;
	private Box bNhapA;
	private Box bNhapB;
	private Box bNhapC;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private Box bKetQua;
	private JTextField txtKQ;
	private JPanel panelTacVu;
	private Box bTacVu;
	private JButton btnGiai;
	private JButton btnXoa;
	private JButton btnThoat;
	public GiaiPhuongTrinh() {
		this.setTitle("Giai phuong trinh bac hai");
		this.setSize(450, 360);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panelTitle = new JPanel();
		panelTitle.setBackground(Color.BLUE);
		lblTitle = new JLabel("GIAI PHUONG TRINH HAC HAI", SwingConstants.CENTER);
		lblTitle.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		panelTitle.add(lblTitle);
		add(panelTitle,BorderLayout.NORTH);
		
		bInput = Box.createVerticalBox();
		bNhapA = Box.createHorizontalBox();
		bNhapB = Box.createHorizontalBox();
		bNhapC = Box.createHorizontalBox();
		bKetQua = Box.createHorizontalBox();
		
		bNhapA.add(Box.createRigidArea(new Dimension(40, 0)));
		JLabel lblA;
		bNhapA.add(lblA = new JLabel("Nhap A: "));
		bNhapA.add(txtA = new JTextField(15));
		bNhapA.add(Box.createRigidArea(new Dimension(40, 0)));
		
		bNhapB.add(Box.createRigidArea(new Dimension(40, 0)));
		JLabel lblB;
		bNhapB.add(lblB = new JLabel("Nhap B: "));
		bNhapB.add(txtB = new JTextField(15));
		bNhapB.add(Box.createRigidArea(new Dimension(40, 0)));
		
		bNhapC.add(Box.createRigidArea(new Dimension(40, 0)));
		JLabel lblC;
		bNhapC.add(lblC = new JLabel("Nhap C: "));
		bNhapC.add(txtC = new JTextField(15));
		bNhapC.add(Box.createRigidArea(new Dimension(40, 0)));
		
		bKetQua.add(Box.createRigidArea(new Dimension(40, 0)));
		JLabel lblKQ;
		bKetQua.add(lblKQ = new JLabel("Ket qua: "));
		bKetQua.add(txtKQ = new JTextField(15));
		bKetQua.add(Box.createRigidArea(new Dimension(40, 0)));
		
		lblA.setPreferredSize(lblKQ.getPreferredSize());
		lblB.setPreferredSize(lblKQ.getPreferredSize());
		lblC.setPreferredSize(lblKQ.getPreferredSize());
		
		bInput.add(Box.createRigidArea(new Dimension(25, 25)));
		bInput.add(bNhapA);
		bInput.add(Box.createRigidArea(new Dimension(25, 25)));
		bInput.add(bNhapB);
		bInput.add(Box.createRigidArea(new Dimension(25, 25)));
		bInput.add(bNhapC);
		bInput.add(Box.createRigidArea(new Dimension(25, 25)));
		bInput.add(bKetQua);
		bInput.add(Box.createRigidArea(new Dimension(15, 15)));
		
		add(bInput,BorderLayout.CENTER);
		
		panelTacVu = new JPanel();
		panelTacVu.setBorder(BorderFactory.createTitledBorder("Chon tac vu"));
		bTacVu = Box.createHorizontalBox();
		bTacVu.add(Box.createRigidArea(new Dimension(50, 0)));
		bTacVu.add(btnGiai = new JButton("Giai"));
		bTacVu.add(Box.createRigidArea(new Dimension(10, 0)));
		bTacVu.add(btnXoa = new JButton("Xoa rong"));
		bTacVu.add(Box.createRigidArea(new Dimension(10, 0)));
		bTacVu.add(btnThoat = new JButton("Thoat"));
		bTacVu.add(Box.createRigidArea(new Dimension(50, 0)));
		
		panelTacVu.add(bTacVu);
		panelTacVu.setPreferredSize(new Dimension(0, 70));
		//panelTacVu.add(Box.createRigidArea(new Dimension(20, 20)));
		add(panelTacVu,BorderLayout.SOUTH);
		
		btnGiai.addActionListener(this);
		btnThoat.addActionListener(this);
		btnXoa.addActionListener(this);
	}
	public static void main(String[] args) {
		new GiaiPhuongTrinh().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnXoa)) {
			txtA.setText("");
			txtB.setText("");
			txtC.setText("");
			txtKQ.setText("");
		}
		else if (obj.equals(btnThoat)){
			System.exit(0);
		}
		else {
			int soA, soB, soC;
			//String kq;
			soA = Integer.parseInt(txtA.getText());
			soB = Integer.parseInt(txtB.getText());
			soC = Integer.parseInt(txtC.getText());
			txtKQ.setText(giaiPhuongTrinh(soA, soB, soC));
		}
	}
	private String giaiPhuongTrinh(int a, int b, int c) {
		String s ="";
		if (a == 0) {
            if (b == 0) {
                return s+ "Ph????ng tr??nh v?? nghi???m!";
            } else {
                return s + "Ph????ng tr??nh c?? m???t nghi???m:" + (-c / b);
            }
        }
        // t??nh delta
        float delta = b*b - 4*a*c;
        float x1;
        float x2;
        // t??nh nghi???m
        if (delta > 0) {
            x1 = (float) ((-b + Math.sqrt(delta)) / (2*a));
            x2 = (float) ((-b - Math.sqrt(delta)) / (2*a));
            return s + "Ph????ng tr??nh c?? 2 nghi???m l??: " + x1 + " v?? " + x2;
        } else if (delta == 0) {
            x1 = (-b / (2 * a));
            return s + "Ph????ng tr??nh c?? nghi???m k??p: "+ x1;
        } else {
            return s + "Ph????ng tr??nh v?? nghi???m!";
        }
	}
}
