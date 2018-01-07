package School;

public class Class {
	String className;
	String letterGrade;
	double percentage;
	double numericalGrade;

	public double getPercentage () {
		return numericalGrade;
	}
	
	public double getNumericalGrade () {
		return numericalGrade;
	}
	
	public String getLetterGrade () {
		return letterGrade;
	}
	
	public String getClassName () {
		return className;
	}
	
	public void setPercentage(double newPercentage) {
		percentage = newPercentage;
		if (percentage >= 90) {
			letterGrade = "A";
			numericalGrade = 4.0;
		}
		else if (percentage >= 80) {
			letterGrade = "B";
			numericalGrade = 3.0;
		}
		else if (percentage >= 70) {
			letterGrade = "C";
			numericalGrade = 2.0;
		}
		else if (percentage >= 60) {
			letterGrade = "D";
			numericalGrade = 1.0;
		}
		else {
			letterGrade = "F";
			numericalGrade = 0.0;
		}
	}
	
	public void setClassName(String newClassName) {
		className = newClassName;
	}
	
}

