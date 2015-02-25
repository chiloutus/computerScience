import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class GenerateArray {
	public static void main(String[] args){
		String unsorted = "";
		int[] array = new int[1000];
		for(int i=1;i<1000;i++)
		{
			int random = (int)(Math.random()*1000);
			for(int j=1;j<1000;j++)
			{
				if(random == array[j])
				{
					random = (int)(Math.random()*1000);
					j=0;
				}
			}
			array[i]=random;
		}
		
		for(int i=1;i<1000;i++)
		{
			unsorted += array[i] + "\n";
		}
		try {
			PrintWriter out = new PrintWriter("../../ranData.txt");
			out.println(unsorted);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
