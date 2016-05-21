//package test;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class testComposition extends JApplet implements ActionListener {
	Container c;
	JLabel stdCodeLabel, stdNameLabel, stdSurnameLabel;
	JTextField stdCodeText, stdNameText, stdSurnameText, stdText;
	JButton addStdBtn ,searchBtn;
	JLabel subCodeLabel, subNameLabel, subCreditLabel;
	JTextField subCodeText, subNameText, subCreditText;
	JButton addSubBtn;
	JTextArea subTextArea;
	JScrollPane subScroll;
	JButton saveBtn, cancleBtn,editBtn,delBtn;
	Register reg;
	String [][] data = new String[5][3];
	String subject,name,credit;
	int count = 0;
	int temp =99;

	public void init() {
		setSize(700, 400);
		initGui();
		reg = new Register(new Student(), 5);
	}

	public void initGui() {
		c = getContentPane();
		c.setLayout(new FlowLayout());

		stdCodeLabel = new JLabel("Enter Student Code:");
		c.add(stdCodeLabel);
		stdCodeText = new JTextField(6);
		c.add(stdCodeText);
		stdNameLabel = new JLabel("Name:");
		c.add(stdNameLabel);
		stdNameText = new JTextField(10);
		c.add(stdNameText);
		stdSurnameLabel = new JLabel("Surname:");
		c.add(stdSurnameLabel);
		stdSurnameText = new JTextField(10);
		c.add(stdSurnameText);
		addStdBtn = new JButton("Add Student");
		addStdBtn.addActionListener(this);
		c.add(addStdBtn);

		stdText = new JTextField(60);
		stdText.setEditable(false);
		c.add(stdText);

		subCodeLabel = new JLabel("Enter Subject Code:");
		c.add(subCodeLabel);
		subCodeText = new JTextField(6);
		c.add(subCodeText);

		subNameLabel = new JLabel("Name:");
		c.add(subNameLabel);
		subNameText = new JTextField(17);
		c.add(subNameText);

		subCreditLabel = new JLabel("Credit:");
		c.add(subCreditLabel);
		subCreditText = new JTextField(5);
		c.add(subCreditText);
		addSubBtn = new JButton("Add Subject");
		addSubBtn.setEnabled(false);
		addSubBtn.addActionListener(this);
		c.add(addSubBtn);
		searchBtn = new JButton("Search Subject");
		searchBtn.setEnabled(false);
		searchBtn.addActionListener(this);
		c.add(searchBtn);

		subTextArea = new JTextArea(5, 60);
		subTextArea.setEditable(false);
		subScroll = new JScrollPane(subTextArea);
		c.add(subScroll);

		saveBtn = new JButton(" Save ");
		saveBtn.setEnabled(false);
		saveBtn.addActionListener(this);
		c.add(saveBtn);

		editBtn = new JButton(" Edit ");
		editBtn.setEnabled(false);
		editBtn.addActionListener(this);
		c.add(editBtn);

		cancleBtn = new JButton(" Cancle ");
		cancleBtn.setEnabled(false);
		cancleBtn.addActionListener(this);
		c.add(cancleBtn);

		delBtn = new JButton(" Delete ");
		delBtn.addActionListener(this);
		c.add(delBtn);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == addStdBtn) {
			Student std = new Student(stdCodeText.getText(), stdNameText.getText(), stdSurnameText.getText());
			stdText.setText(std.toString());
			reg.setStudent(std);
			addStdBtn.setEnabled(false);
			addSubBtn.setEnabled(true);
			saveBtn.setEnabled(true);
			cancleBtn.setEnabled(true);
			stdCodeText.setText("");
			stdNameText.setText("");
			stdSurnameText.setText("");
		} else if (event.getSource() == addSubBtn) {
			data[count][0] =  subCodeText.getText();
			data[count][1] =  subNameText.getText();
			data[count][2] =  subCreditText.getText();
			Subject sub = new Subject(data[count][0], data[count][1],Integer.parseInt(data[count][2]));
			subTextArea.append(sub.toString() + "\n");
			reg.setSubject(sub, count);
			count++;

			if(count!=0)
				searchBtn.setEnabled(true);
			if (count == 5) {
				addSubBtn.setEnabled(false);
			}
			subCodeText.setText("");
			subNameText.setText("");
			subCreditText.setText("");
		} else if (event.getSource() == saveBtn) {
			String output = "";
			output = "Student :" + reg.getStudent();
			output += "\nSubject:\n";
			for (int n = 0; n < count; n++)
				output += reg.getSubject(n) + "\n";
			JOptionPane.showMessageDialog(null, output, "Registration Data", JOptionPane.INFORMATION_MESSAGE);
			resetAll();
		} else if (event.getSource() == cancleBtn) {
			resetAll();
		} else if(event.getSource() == searchBtn){
			String input = JOptionPane.showInputDialog(null,"Enter Subject code :");
			for(int i=0;i<count;i++){
				if((Integer.parseInt(data[i][0]))== (Integer.parseInt(input))){
					JOptionPane.showMessageDialog(null,"Subject code : "+data[i][0]+"\nname : "+data[i][1]+"\ncredit : "+data[i][2]);
					subCodeText.setText(data[i][0]);
					subNameText.setText(data[i][1]);
					subCreditText.setText(data[i][2]);

					temp=i;
					subject = subCodeText.getText();
					name = subNameText.getText();
					credit = subCreditText.getText();
					editBtn.setEnabled(true);
				}
			}
			
		} else if(event.getSource() == editBtn){
			if(temp!=99){
				subTextArea.setText("");
				data[temp][0] = subCodeText.getText();
				data[temp][1] = subNameText.getText();
				data[temp][2] = subCreditText.getText();
				String sub="";
				for(int i=0;i<count;i++){
					sub+= data[i][0]+" "+data[i][1]+" "+data[i][2]+"\n";
				}
				subTextArea.append(sub);
				JOptionPane.showMessageDialog(null,"Edit Success.");
				editBtn.setEnabled(false);
			}

		} else if(event.getSource() == delBtn){

			String s = subCodeText.getText();
			String n = subNameText.getText();
			if(!s.equals("") || !n.equals("")){
				for(int i=0;i<count;i++){
					if(s.equals(data[i][0])){
						data[i][0] = "";
						data[i][1] = "";
						data[i][2] = "";	
					}	
				}
				String sub="";
				for(int i=0;i<count;i++){
					if(!(data[i][0].equals("") && data[i][1].equals("") && data[i][2].equals("")))
						sub+= data[i][0]+" "+data[i][1]+" "+data[i][2]+"\n";
				}
				subTextArea.setText("");
				subTextArea.append(sub);
				count--;
				JOptionPane.showMessageDialog(null,"Delete Success.");	
				
			}
			else 
				JOptionPane.showMessageDialog(null,"Please insert Subject code.");
			
		}
	}

	public void resetAll() {
		stdCodeText.setText("");
		stdNameText.setText("");
		stdSurnameText.setText("");
		stdText.setText("");
		addStdBtn.setEnabled(true);
		subCodeText.setText("");
		subNameText.setText("");
		subCreditText.setText("");
		addSubBtn.setEnabled(false);
		subTextArea.setText("");
		saveBtn.setEnabled(false);
		cancleBtn.setEnabled(false);
		count = 0;
	}
}