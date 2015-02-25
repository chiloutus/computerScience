import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Vector;


	public class GenerateVector {
		public static Vector mVector()
		{
			String everything = "";
			try {
				
				BufferedReader br = new BufferedReader(new FileReader("../../ranData.txt"));
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();
		
				while (line != null) {
					sb.append(line);
					sb.append(System.lineSeparator());
					line = br.readLine();
				}
				everything = sb.toString();
			}
			catch (IOException e){
			e.printStackTrace();
			}
			final String[] rawIn = everything.split("\n");
			final int[] in = new int[rawIn.length];

			for(int i =0; i < in.length;i++)
			{
				in[i] = Integer.parseInt(rawIn[i]);
			}
			Vector<Integer> myVector = new Vector<>();
			
			for(int i = 0; i < in.length;i++)
			{
				myVector.add(in[i]);
			}
			/*for(int i = 0; i< myVector.size();i++)
			{
				System.out.println(myVector.elementAt(i));
			}*/
			
			return myVector;
		}
}
