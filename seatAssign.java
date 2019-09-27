import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

// this is the class for assigning seats
public class seatAssign {
	private List<List<String>> seats = new ArrayList<>();

	public static void main(String[] args) {
		// read requests from input file path
		seatAssign obj = new seatAssign();
		String requestFile = args[0];
		String request = obj.readRequest(requestFile);
		System.out.println("Current request from reading file: " + request);
		// read levels of seats from file.txt and store into List<String[]>
		obj.readSeats();
		// assign seats according to number of requests
		obj.assign(request);
	}

	public String readRequest(String filePath) {
		String line = "";
		try{
			File file = new File(filePath);
			InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
			BufferedReader br = new BufferedReader(reader);
			line = br.readLine();
		} catch (Exception e) {
			System.out.println("File doesn't exist!! Please check your input:)");
			e.printStackTrace();
		}
		return line;
	}

	public List<List<String>> readSeats() {
		try{
			File file = new File("file.txt");
			InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
			BufferedReader br = new BufferedReader(reader);
			String line = "";
			while ((line = br.readLine()) != null) {
				List<String> tempList = new ArrayList<>();
				String[] str = line.split(" ");
				for(String s : str) {
					tempList.add(s);
				}
				seats.add(tempList);
    		}
		} catch (Exception e) {
			System.out.println("File doesn't exist!! Please check your input:)");
			e.printStackTrace();
		}

		// test seats
		// int size = seats.size();
		// System.out.println("Size of seats ArrayList is " + size);
		// for(String[] str : seats) {
		// 	for(String s : str){
		// 		System.out.print(s);
		// 	}
		// 	System.out.println();
		// }
		
		return seats;
	}

	public void assign(String request) {
		String[] str = request.split(" ");
		String requestID = str[0];
		int requestNum = Integer.parseInt(str[1]);
		String assign = assignHelper(requestNum, "");
		// System.out.println(assign);

		String output = requestID + " " + assign;
		write(output);
	}

	public String assignHelper(int requestNum, String assign) {
		// assign seats starting from the first level
		for(int i=0; i<seats.size(); i++) {
			List<String> currLevel = seats.get(i);
			int currSize = currLevel.size();
			// if seats of the current level were assigned move to the next level
			if(currLevel == null || currSize == 0){
				continue;
			}

			// if current level is (partially) enough for current request
			while(requestNum > 0 && currLevel.size() > 0) {
				if(requestNum > 1)
					assign += currLevel.get(0) + ", ";
				else
					assign += currLevel.get(0) + " ";
				currLevel.remove(0);
				requestNum--;
			}
			
			// if current level is enough
			if(requestNum == 0)
				return assign;
			// if current level is partially enough
			else {
				assignHelper(requestNum, assign);
			}
		}

		return assign;
	}

	// rewrite file.txt and write assignment.txt
	public void write(String output) {
		// firstly we need to update the file.txt
		Seat seat = new Seat();
		seat.writeFile(seats);

		// now we can write output files!
		String filePath = "Assignments/assignment.txt";
		try{
			BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
			out.write(output);
			out.close();
			System.out.println(filePath + " has been written!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}