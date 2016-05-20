import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TGraph extends JPanel {
	private TText tText;
	private Color color;
	JPanel panel;
	JLabel textF,textA,outputF,outputA;
	
	public TGraph()
	{
		textF = new JLabel("F : ");
		textA = new JLabel("A : ");
		outputF = new JLabel();
		outputA = new JLabel();
		tText=new TText();//à¡Ô´ obj tText ·Õè¹Õé
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(700,200));
		panel.add(textF);
		panel.add(outputF);
		panel.add(textA);
		panel.add(outputA);
		add(panel);
	}
	public void setDataT(String T)
	{
		tText.setT(T);
		tText.setFA();
		
	}
	public void setColor(Color color)
	{
		this.color = color;
		outputF.setForeground(this.color); // เปลี่ยนค่าสีของ output f
		outputA.setForeground(this.color); // เปลี่ยนค่าสีของ output a
		
	}
	public int showGraph()
	{
		String f="",a="";
		for(int i=1;i<=tText.getF();i++){
			f+=tText.getT(); // ให้ตัวแปร f เก็บค่าตัวอกษรที่พิมพ์ตามจำนวนที่เรนดอมของค่า f
		}
		for(int i=1;i<=tText.getA();i++){
			a+=tText.getT(); // ให้ตัวแปร a เก็บค่าตัวอกษรที่พิมพ์ตามจำนวนที่เรนดอมของค่า a
		}
		
		outputF.setText(f+"("+Integer.toString(tText.getF())+")"); // แสดงผลของ f 
		outputA.setText(a+"("+Integer.toString(tText.getA())+")"); // แสดงผลของ a
		
		return 0;
	}
}
