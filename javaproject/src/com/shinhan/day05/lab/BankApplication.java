package com.shinhan.day05.lab;

//챕터6 20번
import java.util.Scanner;

//함수, 메서드 : 문장들의 묶음, 로직구현,
public class BankApplication {
	//여기는 멤버
	//Scanner sc; //main이 static이여서 이 변수는 쓸 수 없음.
	static Scanner sc;//필드로 옮겼음. 
	
	public static void main(String[] args) {
		
		 sc = new Scanner(System.in);
		boolean isGo = false;
		Account[] arr = new Account[5];
		int index = 0; 
		while(!isGo) {
			menuPrint();			
			System.out.print("선택>");
			int job = sc.nextInt();
			switch(job) {
			//case :을 사용할때 꼭 break 줘야함. 쓰기 싫으면 case->{}
				case 1->{ //1.계좌생성 실행 결과
					menuPrint("계좌생성");			
					if(index == arr.length) {
						System.out.println("더이상 계좌생성불가하다.");
					}else {
						createAccount(arr, index++); //메서드 만듦. 사용하고 ++됨
					}
				}
				case 2 ->{ //2.계좌목록 실행 결과
					menuPrint("계좌목록");
					for(Account acc:arr) {
						if(acc == null) break;
						//System.out.printf("%10s %10s %10d\n", acc.accNo, acc.owner, acc.balance);
						//acc.accNo 정보를 직접 접근중임. 보통이렇게쓰진않음. Account 필드에 private써야하는데 그럼 getter/setter필요.
						System.out.printf("%10s %10s %10d\n", acc.getAccNo(), acc.getOwner(), acc.getBalance());//정보를받아오려면 get
					}
					break;
				}
				case 3 -> {
					menuPrint("예금");
					inputAccount(arr, index);
				}
				case 4 -> {
					menuPrint("출금");
					outputAccont(arr, index);
				}
				case 5 -> { isGo = false; }
			}
		}
		sc.close();
	}	
	private static void outputAccont(Account[] arr, int index) {
		System.out.print("계좌번호>");
		String accNo = sc.next();
		System.out.print("출금>");
		int amount = sc.nextInt();
		for(int i=0; i<index; i++) {
			if(accNo.equals(arr[i].getAccNo())) {
				int amount2 = arr[i].withdraw(amount);
				System.out.println(amount2 + "출금되었습니다.");
				break;
			}
		}
		
	}
	private static void inputAccount(Account[] arr, int index) { //입금
		System.out.print("계좌번호>");
		String accNo = sc.next();
		System.out.print("예금>");
		int amount = sc.nextInt();
		for(int i=0; i<index; i++) {
			if(accNo.equals(arr[i].getAccNo())) {
				arr[i].save(amount); break;
			}
		}
		
	}
	
	//void리턴없음. arr배열은 객체라 리턴이됨.
	private static void createAccount(Account[] arr, int index) { //계좌생성
		System.out.print("계좌번호: ");
		String accNo = sc.next();
		System.out.print("계좌주: ");
		String owner = sc.next();
		System.out.print("초기입금액: ");
		int balance = sc.nextInt();
		arr[index] = new Account(accNo, owner, balance); //index++부분은 바깥으로 빠졌음
		
	}
	private static void menuPrint(String title) { //하나 더 만듦
		System.out.println("--------");
		System.out.println(title);
		System.out.println("---------");
		
	}
	private static void menuPrint() {
		System.out.println("-----------------------------------------");
		System.out.print("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 |5.종료\n");
		System.out.println("-----------------------------------------");
	}
	
}
