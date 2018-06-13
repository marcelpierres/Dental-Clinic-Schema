import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;

public class Frame {
	static Connection connect;
	static Statement statement;
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try
		{
			connect = DriverManager.getConnection("jdbc:oracle:thin:@oracle.scs.ryerson.ca:1521:orcl", "msarahi", "06235416");
			statement = connect.createStatement();
			JFrame window = new JFrame("SQL");
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setContentPane(new Main());
			window.setResizable(false);
			window.setSize(new Dimension(500, 500));
			window.pack();
			window.setVisible(true);
			window.setFocusable(true);
			window.requestFocus();
			window.setLocationRelativeTo(null);
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
}
