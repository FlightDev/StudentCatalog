package School;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List; 

public class Testing {
	public static void main(String[] args) throws IOException {
		if (Files.list(Paths.get("C://Users/s-man/desktop/NASA Media Release Forms")).count() == 0) {
			System.out.println("You don't seem to have any classes. Let's get your started!");
		}
		while (true) {
			System.out.println();
			String password = "GoodPassword";
			String encrypted = encryptPassword(password, 0);
			System.out.println(password);
			System.out.println(encrypted);
			System.out.println(checkPassword(password, encrypted));
			Student student1 = new Student();
			student1.setFirstName("Neal");
			student1.setMiddleName("Amrit");
			student1.setLastName("Ma");
			student1.setStudentID(1008714);
			student1.printStudentDetails();
			student1.addClass("Jazz Ensemble", 100);
			student1.addClass("Wind Ensemble", 100);
			student1.addClass("AP Chemistry", 94.6);
			student1.addClass("AP Language and Composition", 91.8);
			student1.addClass("AP US History", 92.2);
			student1.addClass("AP Physics 2", 94.9);
			student1.addClass("AP Calculus AB", 92.78);
			student1.addClass("AP Computer Science", 101.1);
			student1.listClasses();
			System.out.println(student1.getGPA());
			break;
		}
	}
	
	public static String encryptPassword(String password, int passwordStrength) {
		String returnString = "";
		if (passwordStrength != 1000) {
			int[] encoder = new int[password.length()];
			for (int i = 0; i < password.length(); i++) {
				encoder[i] = ((int)(password.charAt(i))) - 32;
			}
			for (int i = 0; i < encoder.length; i++) {
				encoder[i] = encoder [encoder.length - i - 1] * encoder[i];
			}
			for (int i = 0; i < encoder.length; i++) {
				encoder[i] = encoder[i] % 95;
				returnString += (char)(encoder[i] + 32);
			}
			encryptPassword(returnString, passwordStrength + 1);
		}
		return returnString;
	}
	
	public static boolean checkPassword(String password, String encryptedPassword) {
		if (encryptPassword(password, 0).equals(encryptedPassword)) {
			return true;
		}
		return false;
	}

	public static List<Student> readFile(String fileName) throws IOException {
		return null;
	}
	
	public static void writeFile(List<Student> Students, String fileName) throws FileNotFoundException {
		PrintWriter printWriter = new PrintWriter("C://Users/s-man/desktop/" + fileName + ".txt");
	    printWriter.println("START FILE");
	    printWriter.println(fileName);
	    printWriter.println("Students:");
	    for (int i = 0; i < Students.size(); i++) {
		    printWriter.println("STUDENT START");
		    printWriter.println(Students.get(i).getFirstName());
		    printWriter.println(Students.get(i).getMiddleName());
		    printWriter.println(Students.get(i).getLastName());
		    for (int j = 0; j < Students.get(i).grade.size(); j++) {
			    printWriter.println(Students.get(i).grade.get(i).getClassName());
			    printWriter.println(Students.get(i).grade.get(i).getPercentage());
		    }
		    printWriter.println("STUDENT END");
	    }
	    printWriter.printf("END FILE");
	    printWriter.close();
	}
}
