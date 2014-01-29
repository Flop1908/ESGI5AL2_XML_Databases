package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.ConnectionWS;
import Model.User;

public class MainView extends JFrame{

	private JPanel container = new JPanel();
	private JButton but_maj = new JButton("Mise à jour ");
	private JButton but_xpath = new JButton("XPATH");
	
	public MainView(User user){
		
		this.setTitle("Menu");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		container.setLayout(new BorderLayout());
		
		JPanel jpanel1 = new JPanel();
		jpanel1.add(but_maj);
		but_maj.addActionListener(new ButtonMajListener(this));
		
		JPanel jpanel2 = new JPanel();
		jpanel2.add(but_xpath);
		but_xpath.addActionListener(new ButtonXPathListener(this));
		
		container.add(jpanel1, BorderLayout.NORTH);
		container.add(jpanel2, BorderLayout.CENTER);
		this.setContentPane(container);
		this.setVisible(true); 
		
	}
	
	class ButtonMajListener implements ActionListener{
		MainView mview;
		public ButtonMajListener(MainView mv) {
			// TODO Auto-generated constructor stub
			this.mview = mv;
		}

		public void actionPerformed(ActionEvent e) {
			
			mview.setVisible(false);
			new DatabasesView();
		}
	}
	
	class ButtonXPathListener implements ActionListener{
		MainView mview;
		public ButtonXPathListener(MainView mv) {
			// TODO Auto-generated constructor stub
			this.mview = mv;
		}

		public void actionPerformed(ActionEvent e) {
			
			mview.setVisible(false);
			new XPathView();
		}
	}
}
