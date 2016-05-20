import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class testG extends JApplet implements ActionListener{
	Container c;
	JPanel pMenu;
	private JLabel linput;
	private JTextField finput;
	private JButton bSet,bBlue,bPink;
	
	TGraph tGraph;
	
	public void init(){
		c = getContentPane();
		c.setLayout(new FlowLayout());
		
		pMenu = new JPanel();
		pMenu.setPreferredSize(new Dimension(700,50));
		pMenu.setBorder(BorderFactory.createBevelBorder(0));
		
		linput = new JLabel("Input Text :");
		pMenu.add(linput);
		
		finput = new JTextField(10);
		pMenu.add(finput);
		
		bSet = new JButton(" SET ");
		bSet.addActionListener(this);
		pMenu.add(bSet);
		
		bBlue = new JButton(" BLUE ");
		bBlue.addActionListener(this);
		pMenu.add(bBlue);
		
		
		bPink = new JButton(" PINK ");
		bPink.addActionListener(this);
		pMenu.add(bPink);
		
		c.add(pMenu);
		tGraph = new TGraph();
		c.add(tGraph);
		
		setSize(750,300);
		
		
		
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		tGraph.showGraph();
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bSet){
			String T = finput.getText();
			tGraph.setDataT(T);
			
		}else if(e.getSource()==bBlue){
			tGraph.setColor(Color.BLUE);
		}else if(e.getSource()==bPink){
			tGraph.setColor(Color.PINK);
		}
		repaint();
	}
}