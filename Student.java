package School;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
	String firstName;
	String middleName;
	String lastName;
	int studentID;
	List<Class> grade = new ArrayList<Class>();
	
	public void addClass (String className, double newPercentage) {
		Class newClass = new Class();
		newClass.setClassName(className);
		newClass.setPercentage(newPercentage);
		grade.add(newClass);
	}
	
	public void changeGrade (String className, double newPercentage) {
		for (int i = 0; i < grade.size(); i++) {
			if (grade.get(i).getClassName().toUpperCase().equals(className.toUpperCase())) {
				grade.get(i).setPercentage(newPercentage);
			}
		}
		System.out.println(className + " is not a class. Please try again.");
	}
	
	public void removeClass (String className) {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < grade.size(); i++) {
			if (grade.get(i).getClassName().toUpperCase().equals(className.toUpperCase())) {
				System.out.println("Are you sure you want to remove " + grade.get(i).getClassName() + "? (Y/N)");
				String answer = scanner.nextLine();
				if (answer.toUpperCase().equals("Y")) {
					System.out.println(grade.get(i).getClassName() + " was removed from " + firstName + "'s record.");
					grade.remove(i);
				}
				else {
					break;
				}
			}
		}
	}
	
	public double calculateGPA () {
		double cumulativeGPA = 0;
		for (int i = 0; i < grade.size(); i++) {
			cumulativeGPA += (grade.get(i)).getNumericalGrade();
		}
		return cumulativeGPA / grade.size();
	}
	
	public void listClasses () {
		System.out.println("Class Name\t\t\tLetter Grade\t\t\tNumerical Grade");
		System.out.println("----------\t\t\t------------\t\t\t---------------");
		for (int i = 0; i < grade.size(); i++) {
			
			System.out.print(grade.get(i).getClassName());
			int k = grade.get(i).getClassName().length() / 8;
			for (int j = 0; j < 4 - k; j++) {
				System.out.print("\t");
			}
			System.out.print(grade.get(i).getLetterGrade() + "\t\t\t\t");
			
			System.out.println(grade.get(i).getNumericalGrade());
			
		}
	}

	public String getFirstName () {
		return firstName;
	}
	
	public String getMiddleName () {
		return middleName;
	}
	
	public String getLastName () {
		return lastName;
	}
	
	public void setFirstName (String newFirstName) {
		firstName = newFirstName;
	}
	
	public void setMiddleName (String newMiddleName) {
		middleName = newMiddleName;
	}
	
	public void setLastName (String newLastName) {
		lastName = newLastName;
	}

	public void setStudentID (int ID) {
		studentID = ID;
	}

	public void printStudentDetails () {
		if (calculateGPA() > 0) {
		System.out.println("Name: " + firstName + " " + middleName.charAt(0) + ". " + lastName + "\tStudent ID: " + studentID + "\tGPA: " + calculateGPA());
		}
		else {
		System.out.println("Name: " + firstName + " " + middleName.charAt(0) + ". " + lastName + "\tStudent ID: " + studentID);
		}
	}

	public String getGPA() {
		return ("GPA: " + calculateGPA());
	}


}
