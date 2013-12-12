package data;

public class Student implements Comparable<Student> {

	private int number;
	private String name;

	public Student(int number, String name) {

		this.number = number;
		this.name = name;
	}

	public int getNumber() {

		return this.number;
	}

	public String getName() {

		return this.name;
	}

	@Override
	public int compareTo(Student student) {

		if (this.number < student.getNumber()) {
			return -1;
		}
		else if (this.number > student.number) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public String toString() {

		return "Student: " + this.number + " - " + this.name;
	}
}