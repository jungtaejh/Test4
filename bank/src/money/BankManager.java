package money;

import java.util.ArrayList;
import java.util.Scanner;

public class BankManager{
	
	public BankManager() throws Exception {
		
		BankDAO dao = new BankDAO();	//DAO 클래스
		BankDTO dto = new BankDTO();	//DTO클래스
		
		Scanner sc = new Scanner(System.in); //스캐너
		
		while(true) {	//전체반복
		
		System.out.println("은행 고객 관리 프로그램입니다");
		System.out.println("1.입력      2.아이디검색      3.전체검색      4.수정      5.삭제     6.종료");
		System.out.println("-------------------------------------------------------");
		System.out.print("메뉴를 선택해주세요>>");
		
		int number = sc.nextInt();
			
		if (number == 1) {				//입력
			System.out.print("아이디 >>");
			dto.setId(sc.next());
			System.out.print("이름>>");
			dto.setName(sc.next());
			System.out.print("나이>>");
			dto.setAge(sc.nextInt());
			System.out.print("전화번호>>");
			dto.setTel(sc.next());
			
			dao.insert(dto);			//dao의 insert메서드
			System.out.println("저장되었습니다");
		
			
		} else if (number == 2) {		//검색
			
			System.out.println("검색할 아이디를 입력해주세요");
			
			ArrayList<BankDTO> list = dao.select(sc.next()); //		//dao의 select메서드로 list에 저장
			for (int i = 0; i < list.size(); i++) {
				System.out.print("아이디 : " + list.get(i).getId() + "     ");		//출력
				System.out.print("이름 : " + list.get(i).getName() + "     ");
				System.out.print("나이 : " + list.get(i).getAge() + "     ");
				System.out.print("전화번호 : " + list.get(i).getTel() + "\n");
			}
			
		} else if (number == 3) {		//전체검색
			ArrayList<BankDTO> list = dao.selectAll(); //dao의 selectAll메서드로 list에 저장
			System.out.println("전체 목록입니다");
			for (int i = 0; i < list.size(); i++) {
				System.out.print("아이디 : " + list.get(i).getId() + "     ");		//출력
				System.out.print("이름 : " + list.get(i).getName() + "     ");
				System.out.print("나이 : " + list.get(i).getAge() + "     ");
				System.out.print("전화번호 : " + list.get(i).getTel() + "\n");
			}
			
		} else if (number == 4) {	//수정
			System.out.println("수정할 아이디와 전화번호를 입력해주세요");
			System.out.print("아이디>>");
			String upDateId = sc.next();	//찾을 Id값
			System.out.print("전화번호>>");
			String upDateTel = sc.next();	//수정할  Tel값
			
			dao.update(upDateTel, upDateId);	//입력받은 아이디, 전화번호로 수정
			System.out.println("저장되었습니다");
			
		} else if (number == 5) {		//삭제
			System.out.println("삭제할 아이디를 입력해주세요");
			System.out.println("아이디>>");
			
			dao.delete(sc.next());		//dao의 delect 메서드
			System.out.println("삭제되었습니다");
			
		} else if (number == 6) {		//종료
			System.out.println("종료되었습니다.");
			break;
		}
		}
			
	}

	public static void main(String []args) throws Exception {
		BankManager bank = new BankManager();
		
	}
	
}