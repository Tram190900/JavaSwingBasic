package lab1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChuyenDoF extends JFrame implements ActionListener {
	private JPanel panel;
	private JButton btn_KetQua;
	private JLabel lblKetQua;
	private JButton btn_KetThuc;
	private JTextField txtDoF;
	public ChuyenDoF() {
		this.setTitle("Chuyển độ F thành độ C");
		this.setSize(300, 150);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.add(new JLabel("Độ F cần chuyển thành độ C:"));
		txtDoF = new JTextField(4);
		panel.add(txtDoF);
		panel.add(new JLabel("Độ C nhận được sau khi chuyển: "));
		lblKetQua = new JLabel(" ...");
		panel.add(lblKetQua);
		btn_KetQua = new JButton("Xuất kết quả");
		btn_KetThuc = new JButton("Kết thúc");
		panel.add(btn_KetQua);
		panel.add(btn_KetThuc);
		add(panel);
		
		btn_KetQua.addActionListener(this);
		btn_KetThuc.addActionListener(this);
	}
	public static void main(String[] args) {
		new ChuyenDoF().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btn_KetThuc)) {
			System.exit(0);
		}
		else {
			int doF,doC;
			doF = Integer.parseInt(txtDoF.getText());
			doC = (doF - 32)*5/9;
			lblKetQua.setText(doC+"");
		}
	}
}
