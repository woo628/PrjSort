package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Member {
	private int mno;

	public Member(int mno) {
		super();
		this.mno = mno;
	}
	
	public int getMno() {
		return mno;
	}

	@Override
	public String toString() {
		return "Member [mno=" + mno + "]";
	}
	
}

public class TestClassArrayListSort {

	public static void main(String[] args) {
		
		// ArrayList 는 생성자를 통해 초기값을 설정 : java 8 이하
	/*	ArrayList<Member> mlist = new ArrayList<>(
			Arrays.asList(
				new Member(13),new Member(15),new Member(15),
				new Member(5),new Member(1),new Member(7)
			)
		); */
		
		List<Member> mlist = new ArrayList<>(
				List.of(
					new Member(13),new Member(15),new Member(15),
					new Member(5),new Member(1),new Member(7))
			);
		
		displist(mlist);
		System.out.println();
		// 오름차순
		Comparator<Member> compAsc = new Comparator<Member>() {
			
			@Override
			public int compare(Member o1, Member o2) {	
				return o1.getMno() - o2.getMno() ;
			}
		};
		Collections.sort(mlist,compAsc);
		displist(mlist);
		System.out.println();
		
		// 내림차순
		// 1. 외부에 comparator 생성
		Comparator<Member> compDesc = new Comparator<Member>() {
			
			@Override
			public int compare(Member o1, Member o2) {	
				return o2.getMno() - o1.getMno() ;
			}
		};
		Collections.sort(mlist,compDesc);
		
		// 2. 내부에 comparator 생성
		Collections.sort(mlist, new Comparator<Member>() {

			@Override
			public int compare(Member o1, Member o2) {
				return o2.getMno() - o1.getMno();
			}
		});
		
		// 3. 람다식 사용
		Collections.sort(mlist,(a,b) -> {return b.getMno() - a.getMno();});
		
		displist(mlist);
	}

	private static void displist(List<Member> mlist) {
		for (Member member : mlist) {
			System.out.print(member.getMno() + " ");
		}
		System.out.println();
	}

}
