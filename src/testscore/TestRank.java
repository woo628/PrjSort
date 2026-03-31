package testscore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student {
	// Field
	private int num;
	private int score;
	private int rank;
	// Constructor
	public Student(int num, int score) {
		this.num = num;
		this.score = score;
	}
	// getter & setter
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	// toString
	@Override
	public String toString() {
		return "Student [num=" + num + ", score=" + score + ", rank=" + rank + "]";
	}	
} // class end

public class TestRank {

	public static void main(String[] args) {
			
		List<Student> sList = new ArrayList<>();
		sList.add(new Student(1, 100));
		sList.add(new Student(3, 71));
		sList.add(new Student(5, 63));
		sList.add(new Student(4, 88));
		sList.add(new Student(9, 95));
		sList.add(new Student(2, 0));
		sList.add(new Student(11, 45));
		sList.add(new Student(8, 88));
		sList.add(new Student(6, 100));
		dispList(sList);
		
		// 석차구하기
		// 1. 점수를 기준으로 내림차순
		Collections.sort(sList,(a,b)->{return b.getScore() - a.getScore();});
		// 2. 석차부여
	/*	for (Student s1 : sList) {
			int rank = 1;
			for (Student s2 : sList) {
				if (s1.getScore() < s2.getScore()) {
					rank++;
				}
			}
			s1.setRank(rank);
		} */
		
		
		sList.get(0).setRank(1); // 첫번째 줄 1등
		int rnk = 0;
		for (int i = 1; i < sList.size(); i++) {
			if(sList.get(i).getScore() == sList.get(i-1).getScore())
				rnk = sList.get(i-1).getRank();
			else {
				rnk = i + 1;
			}
			sList.get(i).setRank(rnk); 
		}
		dispList(sList);
	}

	private static void dispList(List<Student> sList) {
		System.out.println("------------------------------------");
		for (Student student : sList) {
			System.out.println(student);
		}
		System.out.println("------------------------------------");
	}

}
