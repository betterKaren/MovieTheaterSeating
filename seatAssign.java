import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class seatAssign {
	public static void main(String[] args) {
		// read requests from input file path
		seatAssign obj = new seatAssign();
		String requestFile = args[0];
		String request = obj.readRequest(requestFile);
		System.out.println(request);
		
	}

	public String readRequest (String filePath) {
		String request = "";
		try{
			File file = new File(filePath);
			InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
			BufferedReader br = new BufferedReader(reader);
			request = br.readLine();
		} catch (Exception e) {
			System.out.println("File doesn't exist!! Please check your input:)");
			e.printStackTrace();
		}
		return request;
	}

	public void assign(int number) {

	}

}