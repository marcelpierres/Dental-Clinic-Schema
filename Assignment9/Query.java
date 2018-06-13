import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Dimension;
public class Query extends JPanel implements ActionListener {
	JTextArea textArea;
	public Query() {
		JButton query [] = new JButton [5];
		query[0] = new JButton(
				"Display which patient has an appointment in the future.");
		query[1] = new JButton(
				"Display which patients have had cleanings.");
		query[2] = new JButton(
				"Display which employees make over $65000.00 a year.");
		query[3] = new JButton(
				"Show which dentist is scheduled for the future.");
		query[4] = new JButton("Displays all patients.");
		textArea = new JTextArea();
		for (JButton b : query){
			b.addActionListener(this);
			b.setPreferredSize(new Dimension(400,30));
			this.add(b);
		}
		this.add(textArea);
	}

	public void actionPerformed (ActionEvent e){
		if (((JButton) e.getSource()).getText().equals("Display which patient has an appointment in the future.")){
			try {
				ResultSet rs = Frame.statement.executeQuery("select person.name, treatment.treatment, treatment.date_of_treatment from person, patient, treatment where treatment.PATIENT_ID = patient.PATIENT_ID AND patient.PERSON_ID = person.PERSON_ID AND treatment.DATE_OF_TREATMENT > '2016-10-24'");
				String text = "";
				while (rs.next()) {
					text += rs.getString("name");
					text += "--";
					text += rs.getString("treatment");
					text += "--";
					text += rs.getString("date_of_treatment");
					text += "\n";
				}
				//System.out.println(text);
				textArea.setText(text);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else if (((JButton) e.getSource()).getText().equals("Display which patients have had cleanings.")){
			try {
				ResultSet rs = Frame.statement.executeQuery("select person.name, treatment.date_of_treatment from person, patient, treatment where treatment.PATIENT_ID = patient.PATIENT_ID AND patient.PERSON_ID = person.PERSON_ID AND treatment.treatment = 'Cleaning' AND treatment.DATE_OF_TREATMENT < '2016-10-24'");
				String text = "";
				while (rs.next()) {
					text += rs.getString("name");
					text += "--";
					text += rs.getString("date_of_treatment");
					text += "\n";
				}
				//System.out.println(text);
				textArea.setText(text);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else if (((JButton) e.getSource()).getText().equals("Display which employees make over $65000.00 a year.")){
			try {
				ResultSet rs = Frame.statement.executeQuery("SELECT person.name, employee.salary FROM person, employee WHERE salary > 65000 AND employee.person_id = person.person_id");
				String text = "";
				while (rs.next()) {
					text += rs.getString("name");
					text += "--";
					text += rs.getString("salary");
					text += "\n";
				}
				//System.out.println(text);
				textArea.setText(text);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else if (((JButton) e.getSource()).getText().equals("Show which dentist is scheduled for the future.")){
			try {
				ResultSet rs = Frame.statement.executeQuery("select person.name, treatment.treatment, treatment.date_of_treatment from person, employee, dentist, treatment where treatment.DATE_OF_TREATMENT > '2016-10-24' AND treatment.dentist_id = dentist.dentist_id AND dentist.employee_ID = employee.employee_ID AND employee.person_ID = person.person_id");
				String text = "";
				while (rs.next()) {
					text += rs.getString("name");
					text += "--";
					text += rs.getString("treatment");
					text += "--";
					text += rs.getString("date_of_treatment");
					text += "\n";
				}
				//System.out.println(text);
				textArea.setText(text);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}else if (((JButton) e.getSource()).getText().equals("Displays all patients.")){
			try {
				ResultSet rs = Frame.statement.executeQuery("select person.name from person, patient, clinic where person.clinic_id = clinic.clinic_id and patient.person_id = person.person_id");
				String text = "";
				while (rs.next()) {
					text += rs.getString("name");
					text += "\n";
				}
				//System.out.println(text);
				textArea.setText(text);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
