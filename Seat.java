import java.util.*;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;

// this is the class to generate different grades of seats
public class Seat {
	public static void main(String[] args) {
		// read requests from input file path
		Seat seat = new Seat();
		List<List<String>> diffList = diffSeats();
		seat.writeFile(diffList);
	}

	public void writeFile(List<List<String>> list) {
		// create list contains different levels of seats
		// write file
		String filePath = "file.txt";
		try{
			BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
			for(List<String> temp : list) {
				for(String s : temp) {
					out.write(s + " ");
				}
				out.write("\n");
			}
			out.close();
			System.out.println(filePath + " has been written!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<List<String>> diffSeats() {
		List<List<String>> list = new ArrayList<>();
		List<String> levelOne = new ArrayList<>();
		for(int i=6; i<=15; i++) {
			levelOne.add("E"+i);
			levelOne.add("F"+i);
		}
		Collections.sort(levelOne);
		System.out.println(levelOne.size());

		List<String> levelTwo = new ArrayList<>();
		for(int i=5; i<=16; i++) {
			levelTwo.add("D"+i);
			levelTwo.add("G"+i);
			if(i == 5 || i == 16) {
				levelTwo.add("E"+i);
				levelTwo.add("F"+i);
			}
		}
		Collections.sort(levelTwo);
		System.out.println(levelTwo.size());

		List<String> levelThree = new ArrayList<>();
		for(int i=4; i<=17; i++) {
			levelThree.add("C"+i);
			levelThree.add("H"+i);
			if(i == 4 || i == 17) {
				levelThree.add("D"+i);
				levelThree.add("E"+i);
				levelThree.add("F"+i);
				levelThree.add("G"+i);
			}
		}
		Collections.sort(levelThree);
		System.out.println(levelThree.size());

		List<String> levelFour = new ArrayList<>();
		for(int i=3; i<=18; i++) {
			levelFour.add("B"+i);
			levelFour.add("I"+i);
			if(i == 3 || i == 18) {
				levelFour.add("C"+i);
				levelFour.add("D"+i);
				levelFour.add("E"+i);
				levelFour.add("F"+i);
				levelFour.add("G"+i);
				levelFour.add("H"+i);
			}
		}
		Collections.sort(levelFour);
		System.out.println(levelFour.size());

		List<String> levelFive = new ArrayList<>();
		for(int i=1; i<=20; i++) {
			levelFive.add("A"+i);
			levelFive.add("J"+i);
			if(i == 1 || i == 2 || i == 19 || i == 20) {
				levelFive.add("B"+i);
				levelFive.add("C"+i);
				levelFive.add("D"+i);
				levelFive.add("E"+i);
				levelFive.add("F"+i);
				levelFive.add("G"+i);
				levelFive.add("H"+i);
				levelFive.add("I"+i);
			}
		}
		Collections.sort(levelFive);
		System.out.println(levelFive.size());


		list.add(levelOne);
		list.add(levelTwo);
		list.add(levelThree);
		list.add(levelFour);
		list.add(levelFive);

		return list;
	}
}