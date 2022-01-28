package database_GUI_workspace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
	static Connection connection=null;
	
	static Connection getConnection()
	{
		try
		{
			Class.forName("org.h2.Driver");
			connection=DriverManager.getConnection("jdbc:h2:tcp://localhost/C:\\Users\\svet_\\Desktop\\Програмиране\\2ра Година, 2ри Триместър\\Практикум по ООП и БД\\PersonDB", "sa", "1234");
		}
		catch(ClassNotFoundException e) {e.printStackTrace();}
		catch(SQLException e) 			{e.printStackTrace();}
		
		return connection;
	}
}
