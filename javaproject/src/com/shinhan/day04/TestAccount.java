package day04;

/*  연습문제 TestAccount참고하여 Account클래스 만들기.
078-3762-293계좌가 개설되었습니다.
078-3762-293계좌의 잔고는1000000입니다.
078-3762-293계좌에2000000원이 입금되었습니다.
078-3762-293계좌의 잔고는2000000입니다.
078-3762-293계좌에500000원이 출금되었습니다.
078-3762-293계좌의 잔고는2500000입니다.
*/

public class TestAccount {

	public static void main(String[] args) {
		Account acc= new Account("078-3762-293", 1000000);
		acc.deposit(2000000);
		acc.withdraw(500000);
		
		System.out.println(acc);
	}

}
