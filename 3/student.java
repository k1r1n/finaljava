import javax.swing.JOptionPane;
class student{
	public static void main(String[] args) {
		String numberSection,numberStudent,selectMenu,inputScore;
		int[][] data;
		do{
			numberSection = JOptionPane.showInputDialog(null, "Enter number of Section : ");
			numberStudent = JOptionPane.showInputDialog(null, "Enter number of Student : ");
			data = new int[Integer.parseInt(numberSection)][Integer.parseInt(numberStudent)];
		}while(data.length==0 || data[0].length ==0);

		for(int i=0;i<Integer.parseInt(numberSection);i++){
			for(int j=0;j<Integer.parseInt(numberStudent);j++){
				do{
					inputScore = JOptionPane.showInputDialog(null,"Input score of section " + (i+1) + " student "+(j+1)+" : ");	
				}while(!(Integer.parseInt(inputScore)<=100 && Integer.parseInt(inputScore)>=0));
				data[i][j] = Integer.parseInt(inputScore);
			}
		}
		
		do{
			selectMenu = JOptionPane.showInputDialog(null, "Menu\n1.Show Min\n2.Show Max\n(Exit press 0)",JOptionPane.QUESTION_MESSAGE);
			switch(selectMenu){
				case "1":
					getMin(data);
					break;
				case "2":
					getMax(data);
					break;
				case "0":
					JOptionPane.showMessageDialog(null,"Bye!!!");
					System.exit(0);
				default:
					JOptionPane.showMessageDialog(null,"Don't have this menu!!!");
			}
		}while(selectMenu!="0");
	}

	public static void getMin(int[][] data){
		int min =100;
		String display = "";
		for(int i=0;i<data.length;i++){
			display += "Section "+(i+1)+" : ";
			for(int j=0;j<data[0].length;j++){
				display += data[i][j]+" ";
				if(data[i][j] < min){ 
			       	min = data[i][j]; 
			    } 
			}
			display += "\n";
		}
		display += "\nMin score is "+min;
		JOptionPane.showMessageDialog(null,display,"Show Min",JOptionPane.INFORMATION_MESSAGE);
	}

	public static void getMax(int[][] data){
		int max =0;
		String display = "";
		for(int i=0;i<data.length;i++){
			display += "Section "+(i+1)+" : ";
			for(int j=0;j<data[0].length;j++){
				display += data[i][j]+" ";
				if(data[i][j] > max){ 
			       	max = data[i][j]; 
			    } 
			}
			display += "\n";
		}
		display += "\nMax score is "+max;
		JOptionPane.showMessageDialog(null,display,"Show Min",JOptionPane.INFORMATION_MESSAGE);
	}
}