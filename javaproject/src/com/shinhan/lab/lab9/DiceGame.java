package com.shinhan.lab.lab9;

class Dice {
	int size;

	Dice(int size) {
		this.size = size;
	}

	int play() {
		int number = (int) (Math.random() * size) + 1;
		return number;
	}
}

public class DiceGame {

	public static void main(String[] args) {
		DiceGame game = new DiceGame();

		int result1 = game.countSameEye(10);
		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result1);

		int result2 = game.countSameEye(-10);
		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result2);

	}

	// 구현 
	int countSameEye(int n) {
		//주사위 던지는 횟수n값에 음수가 들어오면 예외 발생시키기
		try {
			if(n<0) throw new IllegalArgumentException("주사위 던지는 횟수가 음수가 될 수 없다.");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return 0;
		}
		//면 8개 주사위 생성
		Dice dice1 = new Dice(8);
		Dice dice2 = new Dice(8);
		int count = 0;
		
		for(int i=1; i<=n; i++) { //던지는 횟수n만큼 반복
			int eye1 = dice1.play(); 
			int eye2 = dice2.play();
			if(eye1 == eye2) count++; //같은 눈 나오는 횟수 계산
			System.out.println(eye1+"//"+eye2);
		}
		return count;
	}

}
