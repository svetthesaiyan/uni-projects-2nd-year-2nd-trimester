 package database_GUI_workspace;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class NewFrame extends JFrame
{
	JTabbedPane tab=new JTabbedPane();
	
	JPanel personPanel	 =new JPanel();
	JPanel carPanel   	 =new JPanel();
	JPanel rentPanel  	 =new JPanel();
	JPanel referencePanel=new JPanel();
	
	public NewFrame()
	{
		this.setSize(400, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tab.add("Хора", personPanel);
		tab.add("Коли", carPanel);
		tab.add("Наем", rentPanel);
		tab.add("Справка", referencePanel);
		
		this.add(tab);
		
		this.setVisible(true);
	}
}
