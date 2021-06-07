package day210203;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MyGui08 extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyGui08 frame = new MyGui08();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyGui08() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl1 = new JLabel("나");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setBounds(102, 72, 57, 15);
		contentPane.add(lbl1);
		
		JLabel lbl2 = new JLabel("컴");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setBounds(102, 110, 57, 15);
		contentPane.add(lbl2);
		
		JButton btn = new JButton("결과");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int random = (int)(Math.random() * 2);
				if (random == 0) {
					tf2.setText("홀");
				} else {
					tf2.setText("짝");
				}
				
				if (!"홀".equals(tf1.getText()) && !"짝".equals(tf1.getText())) {
					tf3.setText("올바르지 않은 값");
				}else if(tf2.getText().equals(tf1.getText())) {
					tf3.setText("승리");
				} else {
					tf3.setText("패배");
				}
			}
		});
		btn.setBounds(82, 147, 97, 23);
		contentPane.add(btn);
		
		tf1 = new JTextField();
		tf1.setText("홀");
		tf1.setHorizontalAlignment(SwingConstants.CENTER);
		tf1.setBounds(229, 69, 116, 21);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setHorizontalAlignment(SwingConstants.CENTER);
		tf2.setBounds(229, 107, 116, 21);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		tf3 = new JTextField();
		tf3.setHorizontalAlignment(SwingConstants.CENTER);
		tf3.setBounds(229, 148, 116, 21);
		contentPane.add(tf3);
		tf3.setColumns(10);
	}

}
