package lab2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class GUIGiaiPhuongTrinhBacHai extends JFrame implements ActionListener {
	private JLabel lblTitle;
	private JTextField txtNhapA;
	private JTextField txtNhapB;
	private JTextField txtNhapC;
	private JTextField txtKQ;
	private JButton btnGiai;
	private JButton btnXoa;
	private JButton btnThoat;
	public GUIGiaiPhuongTrinhBacHai() {
		setTitle("Giải phương trình bậc hai");
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		//Tittle
		add(lblTitle = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI",SwingConstants.CENTER),BorderLayout.NORTH);
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Serif",Font.BOLD,20));
		
		//Input
		JPanel pInput = new JPanel();
		pInput.setLayout(new BoxLayout(pInput, BoxLayout.Y_AXIS));
		Border borderIpnut = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titleBorderInput = new TitledBorder(borderIpnut, "Nhập vào các số a, b, c");
		pInput.setBorder(titleBorderInput);
		JPanel pNhapA = new JPanel();
		JLabel lblA;
		pNhapA.add(lblA = new JLabel("Nhập a: ")); pNhapA.add(txtNhapA = new JTextField(20));
		pInput.add(pNhapA);
		JPanel pNhapB = new JPanel();
		JLabel lblB;
		pNhapB.add(lblB = new JLabel("Nhập b: ")); pNhapB.add(txtNhapB = new JTextField(20));
		pInput.add(pNhapB);
		JPanel pNhapC = new JPanel();
		JLabel lblC;
		pNhapC.add(lblC = new JLabel("Nhập c: ")); pNhapC.add(txtNhapC = new JTextField(20));
		pInput.add(pNhapC);
		JPanel pKQ = new JPanel();
		JLabel lblKQ;
		pKQ.add(lblKQ = new JLabel("Kết quả nhận được: ")); pKQ.add(txtKQ = new JTextField(20));
		txtKQ.setEditable(false);
		pInput.add(pKQ);
		
		lblA.setPreferredSize(lblKQ.getPreferredSize());
		lblB.setPreferredSize(lblKQ.getPreferredSize());
		lblC.setPreferredSize(lblKQ.getPreferredSize());
		
		add(pInput,BorderLayout.CENTER);
		
		//Tác vụ
		JPanel pButton = new JPanel();
		Border borderButtom = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titleBorderButton = new TitledBorder(borderIpnut, "Chọn tác vụ");
		pButton.setBorder(titleBorderButton);
		pButton.add(btnGiai = new JButton("Giải"));
		pButton.add(btnXoa = new JButton("Xóa rỗng"));
		pButton.add(btnThoat = new JButton("Thoát"));
		add(pButton,BorderLayout.SOUTH);
		
		btnGiai.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);
	}
	public static void main(String[] args) {
		new GUIGiaiPhuongTrinhBacHai().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnGiai)) {
			if(txtNhapA.getText().equals("") || txtNhapB.getText().equals("") || txtNhapC.getText().equals("")) {
				JOptionPane.showConfirmDialog(this, "Nhập đủ ba số a, b, c","Thông báo",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
			}
			else {
				GiaiPhuongTrinhBacHai kq = new GiaiPhuongTrinhBacHai(Integer.parseInt(txtNhapA.getText()),Integer.parseInt(txtNhapB.getText()),Integer.parseInt(txtNhapC.getText()));
				txtKQ.setText(kq.giaiPhuongTrinhBacHai());
			}	
		}
		else if(e.getSource().equals(btnXoa)) {
			txtNhapA.setText("");
			txtNhapB.setText("");
			txtNhapC.setText("");
			txtKQ.setText("");
			txtNhapA.setFocusable(true);
		}
		else {
			int selection = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát chương trình ?",
					"Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(selection == JOptionPane.YES_OPTION)
				System.exit(0);
		}
		
	}
}
