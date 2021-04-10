package f_OOP2;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AnoInner_01 {
	public static void main(String[] args) {
		Button button = new Button("은서버튼");
		
		ActionListener eventHandler = new EventHandler();
		
		button.addActionListener(eventHandler);
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("은서버튼 눌림");
			}
		});;
	}
}

class EventHandler implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("은서버튼 눌림");
	}
}
