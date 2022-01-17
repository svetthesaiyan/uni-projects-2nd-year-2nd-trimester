package database_GUI_workspace;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame
{
	Connection connection	   =null;
	PreparedStatement statement=null;
	ResultSet result		   =null;
	
	JPanel upPanel  =new JPanel();
	JPanel midPanel =new JPanel();
	JPanel downPanel=new JPanel();

	JLabel firstNameLabel=new JLabel("Име: ");
	JLabel lastNameLabel =new JLabel("Фамили�?: ");
	JLabel sexLabel      =new JLabel("Пол: ");
	JLabel ageLabel      =new JLabel("Възра�?т: ");
	JLabel salaryLabel   =new JLabel("Заплата: ");

	JTextField firstNameField=new JTextField();
	JTextField lastNameField =new JTextField();
	JTextField ageField      =new JTextField();
	JTextField salaryField   =new JTextField();

	String[] item={"Мъж", "Жена"};
	JComboBox<String> sexCombo=new JComboBox<String>(item);

	JButton addButton   =new JButton("Добав�?не");
	JButton deleteButton=new JButton("Изтриване");
	JButton editButton  =new JButton("Редактиране");

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

		this.add(midPanel);

		// ------------------Долен панел------------------

		this.add(downPanel);

		// ---------------------------------------

		addButton.addActionListener(new AddAction());

		this.setVisible(true);
	}

	class AddAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
//			System.out.println(firstNameField.getText() + " " + lastNameField.getText() + " " + sexCombo.getSelectedItem() + " " + ageField.getText() + " " + salaryField.getText());
			connection=DBConnection.getConnection();	// връзката с базата данни
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
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
		}
	}
}
