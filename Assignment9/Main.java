import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main extends JPanel implements ActionListener {
	public Main() {
		JButton create = new JButton("Create Tables");
		JButton populate = new JButton("Populate Tables");
		JButton query = new JButton("Query Tables");
		JButton drop = new JButton("Drop Tables");
		create.addActionListener(this);
		populate.addActionListener(this);
		query.addActionListener(this);
		drop.addActionListener(this);
		this.add(create);
		this.add(populate);
		this.add(query);
		this.add(drop);
	}

	public void actionPerformed(ActionEvent e) {
		if (((JButton) e.getSource()).getText().equals("Create Tables")) {
			try {
				createTables();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Tables Created");
		} else if (((JButton) e.getSource()).getText()
				.equals("Populate Tables")) {
			try {
				populateTables();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Tables Populated");
		} else if (((JButton) e.getSource()).getText().equals("Query Tables")) {
			query();
		} else if (((JButton) e.getSource()).getText().equals("Drop Tables")) {
			try {
				dropTables();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Tables Dropped");
		}
	}

	public void createTables() throws SQLException {
		String[] creates = {
				"create table clinic (clinic_ID integer, street_adress varchar(255),city varchar(255),country varchar(255),postal_code varchar(255),PRIMARY KEY (clinic_ID))",
				"create table person(person_ID integer,clinic_ID integer,name varchar(255),date_of_birth varchar(255),phone_number integer,street_adress varchar(255),city varchar(255),country varchar(255),postal_code varchar(255),PRIMARY KEY (person_ID),FOREIGN KEY (clinic_ID) REFERENCES clinic(clinic_ID))",
				"create table patient (patient_ID integer,person_ID integer,insur_provider varchar(255),PRIMARY KEY (patient_ID),FOREIGN KEY (person_ID) REFERENCES person(person_ID))",
				"create table employee (employee_ID integer,person_ID integer,salary decimal(20,2),date_hired varchar(255),schedule varchar(255),PRIMARY KEY (employee_ID),FOREIGN KEY (person_ID) REFERENCES person(person_ID))",
				"create table dentist (dentist_ID integer,employee_ID integer,dental_certification varchar(255),PRIMARY KEY (dentist_ID),FOREIGN KEY (employee_ID) REFERENCES employee(employee_ID))",
				"create table receptionist (receptionist_ID integer,employee_ID integer,receptionist_certification varchar(255),PRIMARY KEY (receptionist_ID),FOREIGN KEY (employee_ID) REFERENCES employee(employee_ID))",
				"create table treatment(treatment_ID integer,patient_ID integer,dentist_ID integer,treatment varchar(255),date_of_treatment varchar(255),time_of_treatment varchar(255),PRIMARY KEY (treatment_ID),FOREIGN KEY (patient_ID) REFERENCES patient(patient_ID),FOREIGN KEY (dentist_ID) REFERENCES dentist(dentist_ID))",
				"create table supplier (supplier_ID integer,clinic_ID integer,company_name varchar(255), street_adress varchar(255),city varchar(255),country varchar(255),postal_code varchar(255),PRIMARY KEY (supplier_ID),FOREIGN KEY (clinic_ID) REFERENCES clinic(clinic_ID))",
				"create table product (productID varchar(255), supplier_ID integer,name varchar(255),quantity INTEGER,PRIMARY KEY (productID),FOREIGN KEY (supplier_ID) REFERENCES supplier(supplier_ID))" };
		for (String q : creates) {
			ResultSet rs = Frame.statement.executeQuery(q);
		}
	}

	public void dropTables() throws SQLException {
		String[] drops = { "DROP TABLE PRODUCT", "DROP TABLE SUPPLIER",
				"DROP TABLE TREATMENT", "DROP TABLE RECEPTIONIST",
				"DROP TABLE DENTIST", "DROP TABLE EMPLOYEE",
				"DROP TABLE PATIENT", "DROP TABLE PERSON", "DROP TABLE CLINIC" };
		for (String q : drops) {
			ResultSet rs = Frame.statement.executeQuery(q);
		}

	}

	public void populateTables() throws SQLException {

		String[] populates = {
				"INSERT INTO clinic values(1, '705 Holiday Blvd', 'Toronto', 'Canada', 'M3G4B7')",
				"INSERT INTO person values(1, 1, 'Manzor Sarahi', '1996-06-23', '4163458544', '200 Gateway Blvd', 'Toronto', 'Canada', 'M3C1B5')",
				"INSERT INTO person values(2, 1, 'Shawn Fernandes', '1996-06-09', '9053544343', '210 Gateway Blvd', 'Toronto', 'Canada', 'M3C1B5')",
				"INSERT INTO person values(3, 1, 'Marcel-Pierre Douglas Samuels', '1996-08-15', '6471234567', '190 Gateway Blvd', 'Toronto', 'Canada', 'M3C1B5')",
				"INSERT INTO person values(4, 1, 'John Esmith', '1960-11-12', '416987658', '17 Yonge Street', 'Toronto', 'Canada', 'E2C6B5')",
				"INSERT INTO person values(5, 1, 'Johnathania Esmith', '1965-02-21', '4165345323', '17 Yonge Street', 'Toronto', 'Canada', 'E2C6B5')",
				"INSERT INTO patient values(1, 1, 'Greenshield')",
				"INSERT INTO patient values(2, 2, 'Goodwill')",
				"INSERT INTO patient values(3, 3, 'Unitehere')",
				"INSERT INTO employee values(1, 4, 95000.95, '1990-07-15', 'MTWTF')",
				"INSERT INTO employee values(2, 5, 80150.55, '1990-07-15', 'MTWTF')",
				"INSERT INTO dentist values(1, 1, 'Certificate of Dentistology')",
				"INSERT INTO receptionist values(1, 2, 'Certificate of Receptionology')",
				"INSERT INTO treatment values(1, 1, 1, 'Filling', '2016-08-15', '15:00')",
				"INSERT INTO treatment values(2, 2, 1, 'Cleaning', '2016-08-25', '16:00')",
				"INSERT INTO treatment values(3, 3, 1, 'Removal', '2016-09-15', '13:00')",
				"INSERT INTO treatment values(4, 1, 1, 'Removal', '2016-10-26', '14:00')",
				"INSERT INTO treatment values(5, 2, 1, 'Crowning', '2016-10-27', '13:00')",
				"INSERT INTO treatment values(6, 3, 1, 'Cleaning', '2016-10-28', '12:00')",
				"INSERT INTO supplier values(1, 1, 'Walmart', '60 Gerrard Street', 'Toronto', 'Canada', 'M3F6B8')",
				"INSERT INTO product values(1, 1, 'Tooth Brush', 300)",
				"INSERT INTO product values(2, 1, 'Dental Floss', 300)",
				"INSERT INTO product values(3, 1, 'Gauss', 100)",
				"INSERT INTO product values(4, 1, 'Cyanide', 25)" };
		for (String q : populates) {
			ResultSet rs = Frame.statement.executeQuery(q);
		}
	}

	public void query() {
		JFrame window = new JFrame("SQL");
		window.setContentPane(new Query());
		window.setSize(new Dimension(400, 500));
		window.setResizable(false);
		// window.pack();
		window.setVisible(true);
		window.setFocusable(true);
		window.requestFocus();
		window.setLocationRelativeTo(null);
	}
}
