import java.util.Random;
public class TText {
	private String text;
	private int numF,numA;
	
	public TText()
	{
		
	}
	public void setT(String T)
	{
		text=T;
	}
	public void setFA()
	{
		Random rnd= new Random();
		numF = rnd.nextInt(50)+1; // เรนดอมค่า f ตั้งแต่ 1-50
		numA = 50-numF; 	// ให้ตัวแปร มีค่า 50 - ค่า f จะได้ค่าที่เหลือจากการเรนดอมค่า f
	}
	public String getT()
	{
		return (text);
	}
	public int getF()
	{
		return (numF);
	}
	public int getA()
	{
		return (numA);
	}
	
}

