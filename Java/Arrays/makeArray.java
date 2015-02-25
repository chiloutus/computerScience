import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class makeArray {
	public static int[] mArray()
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
		return in;
	}

}
