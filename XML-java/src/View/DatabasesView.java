package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Model.ConnectionWS;
import Model.Database;
import Model.User;

public class DatabasesView extends JFrame implements ActionListener, ListSelectionListener{
	
	private JPanel container = new JPanel();
	private String databases;
	private JList listbox;
	private ArrayList<Database> listDatabases = new ArrayList<Database>();
	private	Vector listData;
	private JButton but_select = new JButton("Valider");
	private JLabel lbl_static = new JLabel("Select Database : ");
	private JLabel lbl_select = new JLabel("");

	public DatabasesView(){
		
		this.setTitle("Databases");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		container.setLayout(new BorderLayout());
		
		DOMParser dp = new DOMParser();
		try {
			listData = new Vector();
			listbox = new JList(listData);
			listbox.addListSelectionListener( this );
			
			dp.parse("database.xml");
			Document doc = dp.getDocument();
			

			if(doc.hasChildNodes()){
		        NodeList nl = doc.getChildNodes().item(0).getChildNodes();
		        
		        //System.out.println(nl.item(0).getChildNodes().getLength());
		        for(int i = 0; i < nl.getLength();i++){
		        	
			        if(nl.item(i).getNodeName() == "database") {
			        	NodeList nl_database = nl.item(i).getChildNodes();
			        	
			        	for(int j = 0; j < nl_database.getLength();j++){
			        		if(nl_database.item(j).getNodeName() == "name"){
			        			System.out.println(nl_database.item(j).getTextContent());
			        			Database database = new Database(nl_database.item(j).getTextContent());
			        			listData.addElement( nl_database.item(j).getTextContent() );
			        		}
			        	}
			        }
		        }
		            
		    }
			listbox.setListData( listData );
			
			JPanel jpanel1 = new JPanel();
			jpanel1.add(lbl_static);
			jpanel1.add(lbl_select);
			
			JPanel jpanel2 = new JPanel();
			jpanel2.add(but_select);
			but_select.addActionListener( this );
			
			container.add(listbox, BorderLayout.NORTH);
			container.add(jpanel1, BorderLayout.CENTER);
			container.add(jpanel2, BorderLayout.SOUTH);

		} 
		catch(SAXException e){}        
        catch(IOException e1){}
		
		
		
		this.setContentPane(container);
		this.setVisible(true); 
	}
	
	public void valueChanged( ListSelectionEvent event )
 	{
		if( event.getSource() == listbox && !event.getValueIsAdjusting() )
		{
			String stringValue = (String)listbox.getSelectedValue();
			if( stringValue != null )
				lbl_select.setText( stringValue );
		}
 	}

	public void actionPerformed(ActionEvent e) {
		
		if( lbl_select.getText() != null )
		{
			/*listData.addElement( stringValue );
			listbox.setListData( listData );*/
		}
	}
}
