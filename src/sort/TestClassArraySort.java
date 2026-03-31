package sort;

import java.util.Arrays;

class Student implements Comparable {
	private int sno;

	public Student(int sno) {
		super();
		this.sno = sno;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + "]";
	}

	@Override
	public int compareTo(Object o) {
		Student s = (Student) o;
		return this.sno - s.sno; // 오름차순
		// return s.sno - this.sno; // 내림차순
	}
	
}

public class TestClassArraySort {

	public static void main(String[] args) {
		
		Student [] studArr = new Student[] {
			new Student(15),new Student(7),new Student(3),
			new Student(1),new Student(5),new Student(9),
			new Student(15),new Student(13),new Student(27),
			new Student(59),new Student(38),new Student(12)
		};
		
		dispArr(studArr);
		System.out.println();
		Arrays.sort(studArr);
		dispArr(studArr);
		
	}

	private static void dispArr(Student[] studArr) {
		for (Student student : studArr) {
			System.out.print(student + " ");
		}
	}

}
