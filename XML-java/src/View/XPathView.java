package View;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class XPathView extends JFrame {

	private JPanel container = new JPanel();
	private JTextField jtf_command = new JTextField("");
	private JButton but_exec = new JButton("Exécuter");
	private JTextArea jta_result = new JTextArea();
	
	public XPathView(){
		
		this.setTitle("Authentification");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		container.setLayout(new BorderLayout());
		
		JPanel jpanel1 = new JPanel();				
		jtf_command.setPreferredSize(new Dimension(350, 30));
		jpanel1.add(jtf_command);
		
		JPanel jpanel2 = new JPanel();
		jpanel2.add(but_exec);
		
		JPanel jpanel3 = new JPanel();				
		jta_result.setPreferredSize(new Dimension(400, 300));
		jpanel3.add(jta_result);
		
		container.add(jpanel1, BorderLayout.NORTH);
		container.add(jpanel2, BorderLayout.CENTER);
		container.add(jpanel3, BorderLayout.SOUTH);
		this.setContentPane(container);
		this.setVisible(true);  
	}
}
