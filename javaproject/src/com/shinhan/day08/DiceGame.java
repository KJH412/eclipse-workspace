package com.shinhan.day08;
/*
 * int countSameEye(int n) 면이 8개인 주사위 2개를 생성한다. 주사위 2개를 동시에 n번 던졌을 때, 같은 눈이 나오는
 * 횟수를 계산한다. 주사위를 던지는 횟수(n)의 값에 음수가 들어오면 IllegalArgumentException 을 발생시킴
 */
public class DiceGame {
	public static void main(String args[]) {
		DiceGame game = new DiceGame();

		int result1 = game.countSameEye(10);
		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은  눈이 나온 횟수 : " + result1);

		int result2 = game.countSameEye(-10);

		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 이 나온 횟수 : " + result2);

	}

	int countSameEye(int n) {
		// 구현
		try {
			if(n<0) throw new IllegalArgumentException("던지는 횟수는 음수가 될 수 없음"); //IllegalArgumentExceptionrk 하위 exception이라 컴파일러가 체크하지 않음. 
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
		Dice d1 = new Dice(8);
		Dice d2 = new Dice(8);
		int count = 0;
		for(int i=1; i<=n; i++) {
			int su1 = d1.play();
			int su2 = d2.play();
			if(su1==su2) count++;
			System.out.println(su1 + "--" + su2);
		}
		return count;
	}
}


 