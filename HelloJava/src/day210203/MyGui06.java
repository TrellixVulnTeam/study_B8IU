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

public class MyGui06 extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JButton btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyGui06 frame = new MyGui06();
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
	public MyGui06() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf1 = new JTextField();
		tf1.setText("1");
		tf1.setHorizontalAlignment(SwingConstants.CENTER);
		tf1.setBounds(12, 110, 58, 21);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		JLabel lbl = new JLabel("에서");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setBounds(82, 113, 57, 15);
		contentPane.add(lbl);
		
		tf2 = new JTextField();
		tf2.setText("10");
		tf2.setHorizontalAlignment(SwingConstants.CENTER);
		tf2.setColumns(10);
		tf2.setBounds(177, 110, 58, 21);
		contentPane.add(tf2);
		
		tf3 = new JTextField();
		tf3.setHorizontalAlignment(SwingConstants.CENTER);
		tf3.setBounds(364, 110, 58, 21);
		contentPane.add(tf3);
		tf3.setColumns(10);
		
		btn = new JButton("까지의 합");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = 0;
				for (int i = Integer.valueOf(tf1.getText()); i < Integer.valueOf(tf2.getText()) + 1; i++) {
					result += i;
				}
				tf3.setText(String.valueOf(result));
			}
		});
		btn.setBounds(255, 109, 97, 23);
		contentPane.add(btn);
	}

}
