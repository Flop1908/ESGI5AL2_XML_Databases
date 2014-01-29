package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.ConnectionWS;
import Model.User;

@SuppressWarnings("serial")
public class ConnectionView extends JFrame {

	private JPanel container = new JPanel();	
	private JLabel lbl_title = new JLabel("Authentification");
	private JLabel lbl_pseudo = new JLabel("Pseudo : ");
	private JTextField jtf_pseudo = new JTextField("");
	private JLabel lbl_password = new JLabel("Password : ");
	private JTextField jtf_password = new JTextField("");
	private JButton but_ok = new JButton("Se connecter");
	
	public ConnectionView(){
		this.setTitle("Authentification");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		container.setLayout(new BorderLayout());
		Font police = new Font("Arial", Font.BOLD, 14);
		
		JPanel jpanel1 = new JPanel();				
		jtf_pseudo.setFont(police);
		jtf_pseudo.setPreferredSize(new Dimension(150, 30));
		jpanel1.add(lbl_pseudo);
		jpanel1.add(jtf_pseudo);
		
		JPanel jpanel2 = new JPanel();
		jtf_password.setFont(police);
		jtf_password.setPreferredSize(new Dimension(150, 30));	
		jpanel2.add(lbl_password);
		jpanel2.add(jtf_password);
		
		JPanel jpanel3 = new JPanel();
		jpanel3.add(but_ok);
		
		
		but_ok.addActionListener(new ButtonOkListener(this));
		container.add(jpanel1, BorderLayout.NORTH);
		container.add(jpanel2, BorderLayout.CENTER);
		container.add(jpanel3, BorderLayout.SOUTH);
		this.setContentPane(container);
		this.setVisible(true);            
	}
	
	class ButtonOkListener implements ActionListener{
		ConnectionView cview;
		public ButtonOkListener(ConnectionView cv) {
			// TODO Auto-generated constructor stub
			this.cview = cv;
		}

		public void actionPerformed(ActionEvent e) {
			
			ConnectionWS c = new ConnectionWS();
			try {
				if(c.Connection(jtf_pseudo.getText(), jtf_password.getText())) {
					User user = new User(jtf_pseudo.getText());
					c.GetXML(user);
					cview.setVisible(false);					
					new MainView(user);
				}
				//else jtf_password.setText("NON");
			} catch (IOException ioe) {
				// TODO Auto-generated catch block
				ioe.printStackTrace();
			}
		}
	}
}
