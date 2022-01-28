package database_GUI_workspace;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MyFrame extends JFrame
{
	Connection connection	   =null;
	PreparedStatement statement=null;
	ResultSet result		   =null;
	int id;
	
	JPanel upPanel  =new JPanel();
	JPanel midPanel =new JPanel();
	JPanel downPanel=new JPanel();

	JLabel firstNameLabel=new JLabel("Име: ");
	JLabel lastNameLabel =new JLabel("Фамилия: ");
	JLabel sexLabel      =new JLabel("Пол: ");
	JLabel ageLabel      =new JLabel("Възраст: ");
	JLabel salaryLabel   =new JLabel("Заплата: ");

	JTextField firstNameField=new JTextField();
	JTextField lastNameField =new JTextField();
	JTextField ageField      =new JTextField();
	JTextField salaryField   =new JTextField();

	String[] item={"Мъж", "Жена"};
	JComboBox<String> sexCombo	 =new JComboBox<String>(item);
	JComboBox<String> personCombo=new JComboBox<String>();

	JButton addButton    =new JButton("Добавяне");
	JButton deleteButton =new JButton("Изтриване");
	JButton editButton   =new JButton("Редактиране");
	JButton searchButton =new JButton("Търсене по име");
	JButton refreshButton=new JButton("Опресни");
	
	JTable table		=new JTable();
	JScrollPane myScroll=new JScrollPane(table);

	public MyFrame() // конструктор (използва същото име като .java класа)
	{
		this.setSize(400, 600); // задаваме шаблонни стойности на размера на прозореца, като го отваряме за пръв път
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // като затворим прозореца, прекратяваме цялата програма

		this.setLayout(new GridLayout(3, 1));

		// ------------------Горен панел---------------------

		upPanel.setLayout(new GridLayout(5, 2));
		upPanel.add(firstNameLabel);
		upPanel.add(firstNameField);
		upPanel.add(lastNameLabel);
		upPanel.add(lastNameField);
		upPanel.add(sexLabel);
		upPanel.add(sexCombo);
		upPanel.add(ageLabel);
		upPanel.add(ageField);
		upPanel.add(salaryLabel);
		upPanel.add(salaryField);

		this.add(upPanel);

		// ------------------Междинен панел------------------

		midPanel.add(addButton);
		midPanel.add(deleteButton);
		midPanel.add(editButton);
		midPanel.add(searchButton);
		midPanel.add(refreshButton);
		midPanel.add(personCombo);

		this.add(midPanel);

		// ------------------Долен панел------------------
		
		myScroll.setPreferredSize(new Dimension(350, 150));
		downPanel.add(myScroll);
		
		this.add(downPanel);

		// -----------------------------------------------

		table		 .addMouseListener (new MouseAction());
		addButton	 .addActionListener(new AddAction());
		deleteButton .addActionListener(new DeleteAction());
		editButton   .addActionListener(new EditAction());
		searchButton .addActionListener(new SearchAction());
		refreshButton.addActionListener(new RefreshAction());
		
		refreshTable();
		refreshCombo();

		this.setVisible(true);
	}
	
	public void refreshCombo()
	{
		personCombo.removeAllItems();
		
		String sql="select id, fname, lname from person";	// SQL командата е дефинирана в тип 'String' и се ползва по-надолу с командата 'prepareStatement()', за да се изпълни
		
		connection=DBConnection.getConnection();	// връзката с базата данни
		String item="";
		
		try
		{
			statement=connection.prepareStatement(sql);
			result=statement.executeQuery();
			while(result.next())
			{
				item=result.getObject(1).toString()+". "+result.getObject(2).toString()+" "+result.getObject(3).toString();
				personCombo.addItem(item);
			}
		}
		catch(SQLException e) {e.printStackTrace();}
	}
	
	public void refreshTable()
	{
		connection=DBConnection.getConnection();
		try 
		{
			statement=connection.prepareStatement("select * from person");	// SQL кодът е директно вкаран като аргумент на `prepareStatement()`
			result=statement.executeQuery();
			table.setModel(new MyModel(result));
		}
		catch(SQLException e) {e.printStackTrace();}
		catch(Exception e) 	  {e.printStackTrace();}
	}
	
	public void clearForm()
	{
		firstNameField.setText("");
		lastNameField .setText("");
		ageField	  .setText("");
		salaryField   .setText("");
	}

	class AddAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			connection=DBConnection.getConnection();	
			String sql="insert into person(fname, lname, sex, age, salary) values(?, ?, ?, ?, ?)";
			
			try
			{
				statement=connection.prepareStatement(sql);
				statement.setString(1, firstNameField.getText());
				statement.setString(2, lastNameField .getText());
				statement.setString(3, sexCombo.getSelectedItem().toString());
				statement.setInt   (4, Integer.parseInt(ageField   .getText()));
				statement.setFloat (5, Float.parseFloat(salaryField.getText()));
				
				statement.execute();
				refreshTable();
				refreshCombo();
				clearForm();
			}
			catch(SQLException e1) {e1.printStackTrace();}
		}
	}
	
	class DeleteAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			connection=DBConnection.getConnection();
			String sql="delete from person where id=?";
			
			try
			{
				statement=connection.prepareStatement(sql);
				statement.setInt(1, id);
				statement.execute();
				
				refreshTable();
				refreshCombo();
				clearForm();
				id=-1;
			}
			catch(SQLException e1) {e1.printStackTrace();}
		}
	}
	
	class EditAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			int row=table.getSelectedRow();
			String value=(table.getModel().getValueAt(row, 0).toString());
			
			connection=DBConnection.getConnection();
			String sql="update person set fname=?, lname=?, sex=?, age=?, salary=? where id="+value;
			
			try
			{
				statement=connection.prepareStatement(sql);
				statement.setString(1, firstNameField.getText());
				statement.setString(2, lastNameField .getText());
				statement.setString(3, sexCombo		 .getSelectedItem().toString());
				statement.setString(4, ageField		 .getText());
				statement.setString(5, salaryField	 .getText());
				
				statement.executeUpdate();
				refreshTable();
			}
			catch(Exception e1) {e1.printStackTrace();}
		}
	}
	
	class SearchAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			connection=DBConnection.getConnection();
			String sql="select * from person where fname=?";
			
			try
			{
				statement=connection.prepareStatement(sql);
				statement.setString(1, firstNameField.getText());
				result=statement.executeQuery();
				table.setModel(new MyModel(result));
			}
			catch(SQLException e1) {e1.printStackTrace();}
			catch(Exception e1)    {e1.printStackTrace();}
		}
	}
	
	class RefreshAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {refreshTable();}
	}
	
	class MouseAction implements MouseListener
	{
		@Override
		public void mouseClicked(MouseEvent e)
		{
			int row=table.getSelectedRow();
			id=Integer.parseInt   (table.getValueAt(row, 0).toString());
			
			firstNameField.setText(table.getValueAt(row, 1).toString());
			lastNameField .setText(table.getValueAt(row, 2).toString());
			ageField	  .setText(table.getValueAt(row, 4).toString());
			salaryField   .setText(table.getValueAt(row, 5).toString());
			
			if(table.getValueAt(row, 3).toString().equals("М"))
				sexCombo.setSelectedIndex(0);
			else
				sexCombo.setSelectedIndex(1);
		}

		@Override
		public void mousePressed (MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered (MouseEvent e) {}
		@Override
		public void mouseExited  (MouseEvent e) {}
	}
}
