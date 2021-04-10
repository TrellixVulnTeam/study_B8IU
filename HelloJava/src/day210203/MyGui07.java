package day210203;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class MyGui07 extends JFrame {

	private JPanel contentPane;
	JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyGui07 frame = new MyGui07();
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
	public MyGui07() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ta = new JTextArea();
		ta.setBounds(12, 10, 210, 241);
		contentPane.add(ta);

		JButton btn1 = new JButton("2");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myClick(e);
			}
		});
		btn1.setBounds(234, 11, 44, 23);
		contentPane.add(btn1);

		JButton btn2 = new JButton("3");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myClick(e);
			}
		});
		btn2.setBounds(290, 11, 44, 23);
		contentPane.add(btn2);

		JButton btn3 = new JButton("4");
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myClick(e);
			}
		});
		btn3.setBounds(346, 11, 44, 23);
		contentPane.add(btn3);

		JButton btn4 = new JButton("5");
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myClick(e);
			}
		});
		btn4.setBounds(234, 44, 44, 23);
		contentPane.add(btn4);

		JButton btn5 = new JButton("6");
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myClick(e);
			}
		});
		btn5.setBounds(290, 44, 44, 23);
		contentPane.add(btn5);

		JButton btn6 = new JButton("7");
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myClick(e);
			}
		});
		btn6.setBounds(346, 44, 44, 23);
		contentPane.add(btn6);

		JButton btn7 = new JButton("8");
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myClick(e);
			}
		});
		btn7.setBounds(234, 77, 44, 23);
		contentPane.add(btn7);

		JButton btn8 = new JButton("9");
		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myClick(e);
			}
		});
		btn8.setBounds(290, 77, 44, 23);
		contentPane.add(btn8);
	}

	public void myClick(MouseEvent e) {
		int i = Integer.valueOf(((JButton)e.getSource()).getText());
		String result = i + " * 1 = " + i;
		for (int j = 2; j < 10; j++) {
			result += "\n" + i + " * " + j + " = " + (i * j);
		}
		ta.setText(result);
	}
}
