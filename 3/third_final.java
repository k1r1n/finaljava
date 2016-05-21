
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class third_final {
	
	static int sec;
	static int stu;
	static int menu;
	public static void display()
	{
		JFrame window = new JFrame("Input");
		do{
		String Tsec =JOptionPane.showInputDialog("Enter number of Section :");
			sec = Integer.parseInt(Tsec);
		}while(sec == 0);
		do{
		String Tstu = JOptionPane.showInputDialog("Enter number of Student :");
				stu = Integer.parseInt(Tstu);
		}while(stu == 0);
		
		int data[][] = new int [sec][stu];
		for(int r=0;r<sec;r++)
		{
			for(int c=0;c<stu;c++)
			{
				String score="";
				int numscore=0;
				do{
				score=JOptionPane.showInputDialog("Enter Score of Section no."+(r+1)+" Student no."+(c+1)+" :");
				numscore=Integer.parseInt(score);
				
				}while(numscore > 100);
					data[r][c] = numscore;
			}
		}
		Menu(data,sec,stu);
	}
	public static void Menu(int[][] data,int sec,int stu)
	{
		do{
			String mess = JOptionPane.showInputDialog(null, "Menu\n"+"1.Show Min\n"+"2.Show Max\n"+"Enter menu(Exit press 0\n");
			menu= Integer.parseInt(mess);
			if(menu==1)
			{
				Min(data,sec,stu);
			}else if(menu==2)
			{
				Max(data,sec,stu);
			}else if(menu==0)
			{
				JOptionPane.showMessageDialog(null, "Bye..!!",null, JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				JOptionPane.showMessageDialog(null, "Don't have this menu..!!",null, JOptionPane.ERROR_MESSAGE);
			}
			
			}while(menu != 0);
	}
	public static void Min(int[][] data,int sec,int stu)
	{
		
		 int min=100;
		 String showData="";
		
			 for(int r = 0;r<sec;r++)
				{
					for(int c=0;c<stu;c++)
					{
						showData+=data[r][c]+"   ";
						if((c+1)%4==0)
						{
							showData+="\n";
						}
					}
			
			}
		 for(int r=0;r<sec;r++)
		 {
			 
			 for(int c=0;c<stu;c++)
			 {
				 if(min>data[r][c])
				 {
					 min = data[r][c];
				 }
			 }
		 }
		 showData += "\n\nMin score is "+min;
			JOptionPane.showMessageDialog(null,showData,"Show Min",JOptionPane.INFORMATION_MESSAGE);
			
	}
	public static void Max(int[][] data,int sec,int stu)
	{
		String showData="";
		for(int r = 0;r<sec;r++)
		{
			for(int c=0;c<stu;c++)
			{
				showData+=data[r][c]+"   ";
				if((c+1)%4==0)
				{
					showData+="\n";
				}
			}
		}
		int max=0;
		for(int r = 0;r<sec;r++)
		{
			for(int c=0;c<stu;c++)
			{
				if(data[r][c]>max)
				{
					max=data[r][c];
				}
			}
		}
		showData += "\n\nMax score is "+max;
		JOptionPane.showMessageDialog(null,showData,"Show Max",JOptionPane.INFORMATION_MESSAGE);
	
	}
	
	
	public static void main(String[] args) {
		display();
	}
	

}
