package ispProg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class IsFrame extends JFrame {

	private JPanel contentPane;

	// private JFrame frame;
	private JTextField textField_ID;
	private JTextField textField_Name;
	private JTable table;
	private JTextField textField_Credits;

	private JButton btn_Create;
	private JButton btn_Update;
	private JButton btn_Delete;

	private JComboBox<String> comboBox_Classes;
	private JComboBox<String> comboBox_Objects;
	private JComboBox<String> comboBox_Exams;

	private JLabel lbl_ID;
	private JLabel lbl_Credit;
	private JLabel lbl_Name;
	private JLabel lbl_Date;
	private JLabel lbl_Location;
	private JLabel lbl_Time;
	
	private JTextField textField_Date;
	private JTextField textField_Location;
	private JTextField textField_Time;
	
	public IsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 359, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField_ID = new JTextField();
		textField_ID.setBounds(91, 54, 86, 19);
		contentPane.add(textField_ID);
		textField_ID.setColumns(10);

		textField_Name = new JTextField();
		textField_Name.setBounds(91, 83, 86, 19);
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);

		textField_Credits = new JTextField();
		textField_Credits.setBounds(91, 115, 86, 19);
		contentPane.add(textField_Credits);
		textField_Credits.setColumns(10);

		table = new JTable();
		table.setBounds(228, 190, 66, 49);
		contentPane.add(table);

		btn_Create = new JButton("Create");
		btn_Create.setBounds(209, 49, 85, 21);
		contentPane.add(btn_Create);

		btn_Update = new JButton("Update");
		btn_Update.setBounds(209, 82, 85, 21);
		contentPane.add(btn_Update);

		btn_Delete = new JButton("Delete");
		btn_Delete.setBounds(209, 114, 85, 21);
		contentPane.add(btn_Delete);

		comboBox_Classes = new JComboBox();
		comboBox_Classes.setBounds(5, 10, 84, 21);
		contentPane.add(comboBox_Classes);
		comboBox_Classes.addItem("Students");
		comboBox_Classes.addItem("Courses");
		comboBox_Classes.addItem("Exams");
		
		comboBox_Objects = new JComboBox();
		comboBox_Objects.setBounds(112, 10, 86, 21);
		contentPane.add(comboBox_Objects);

		lbl_Name = new JLabel("Name:");
		lbl_Name.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Name.setBounds(5, 86, 77, 13);
		contentPane.add(lbl_Name);

		lbl_ID = new JLabel("Student ID:");
		lbl_ID.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_ID.setBounds(5, 54, 77, 19);
		contentPane.add(lbl_ID);

		lbl_Credit = new JLabel("Credit:");
		lbl_Credit.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Credit.setBounds(5, 118, 77, 13);
		contentPane.add(lbl_Credit);

		textField_Date = new JTextField();
		textField_Date.setColumns(10);
		textField_Date.setBounds(91, 99, 86, 19);
		contentPane.add(textField_Date);
		
		lbl_Date = new JLabel("Date:");
		lbl_Date.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Date.setBounds(5, 99, 77, 19);
		contentPane.add(lbl_Date);
		
		textField_Location = new JTextField();
		textField_Location.setColumns(10);
		textField_Location.setBounds(91, 131, 86, 19);
		contentPane.add(textField_Location);
		
		lbl_Location = new JLabel("Location:");
		lbl_Location.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Location.setBounds(5, 131, 77, 19);
		contentPane.add(lbl_Location);
		
		textField_Time = new JTextField();
		textField_Time.setColumns(10);
		textField_Time.setBounds(91, 162, 86, 19);
		contentPane.add(textField_Time);
		
		lbl_Time = new JLabel("Time:");
		lbl_Time.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_Time.setBounds(5, 162, 77, 19);
		contentPane.add(lbl_Time);
		
		comboBox_Exams = new JComboBox();
		comboBox_Exams.setBounds(218, 10, 76, 21);
		contentPane.add(comboBox_Exams);
		// INVISABLE
				textField_Credits.setVisible(false);
				lbl_Credit.setVisible(false);
				textField_Date.setVisible(false);
				lbl_Date.setVisible(false);
				textField_Location.setVisible(false);
				lbl_Location.setVisible(false);
				textField_Time.setVisible(false);
				lbl_Time.setVisible(false);
				comboBox_Exams.setVisible(false);
		// FRAME
		this.setVisible(true);

	}

	public JButton getBtn_Create() {
		return btn_Create;
	}


	public JButton getBtn_Update() {
		return btn_Update;
	}

	public JButton getBtn_Delete() {
		return btn_Delete;
	}
	
	public JTextField getTextField_Credits() {
		return textField_Credits;
	}
	
	public int getTextField_CreditsInt() {
		return Integer.parseInt(textField_Credits.getText());
	}

	public JLabel getLbl_Credit() {
		return lbl_Credit;
	}
	public JLabel getLbl_ID() {
		return lbl_ID;
	}
	public JTextField getTextField_ID() {
		return textField_ID;
	}

	public void setTextField_ID(String id) {
		textField_ID.setText(id);
	}

	public void setTextField_Name(String name) {
		textField_Name.setText(name);
	}
	
	public void setTextField_Credits(String credits) {
		textField_Credits.setText(credits);
	}

	public JTextField getTextField_Name() {
		return textField_Name;
	}

	public JLabel getLbl_Name() {
		return lbl_Name;
	}

	public JLabel getLbl_Date() {
		return lbl_Date;
	}

	public JLabel getLbl_Location() {
		return lbl_Location;
	}

	public JLabel getLbl_Time() {
		return lbl_Time;
	}

	public JTextField getTextField_Date() {
		return textField_Date;
	}
	public void setTextField_Date(String date) {
		textField_Date.setText(date);
	}

	public JTextField getTextField_Location() {
		return textField_Location;
	}

	public void setTextField_Location(String location) {
		textField_Location.setText(location);
	}
	
	public JTextField getTextField_Time() {
		return textField_Time;
	}
	
	public void setTextField_Time(String time)  {
		textField_Time.setText(time);
	}
	
	
	public JComboBox getComboBox_Classes() {
		return comboBox_Classes;
	}

	public JComboBox getComboBox_Objects() {
		return comboBox_Objects;
	}
	public JComboBox getComboBox_Exams() {
		return comboBox_Exams;
	}

}
