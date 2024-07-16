//매개변수로 받은 문자열을 지정된 크기만큼 늘리되 
//빈 공간을 왼쪽부터 특정 문자(char)로 채워서 리턴하는 leftPad() 메쏘드를 구현
public class Prob2 {
	public static void main(String[] args) {
		System.out.println(leftPad("Samsung",10,'#'));
		System.out.println(leftPad("SDS",5,'*'));
		System.out.println(leftPad("Multicampus",5,'@'));
		
	}

	 

	public static String leftPad(String str, int size, char fillChar){
		//구현하시오.....return값 수정할것 
		String result = "";
		int fillCharNum = size - str.length();
		try {
			if(fillCharNum < 0) {
				throw new IllegalSizeException("문자열의 길이보다 size가 큽니다.");
			}
			result = Character.toString(fillChar).repeat(fillCharNum)+ str; //repeat또는for문
			//result = ("" + fillChar).repeat(fillCharNum)+ str; //("" + fillChar):string으로 바꿈
		}catch (IllegalSizeException e) {
			result = e.getMessage();
		}
		return result;
		
	}

	
}

//구현하시오.
class IllegalSizeException extends Exception {
	
	public IllegalSizeException(String message){
		super(message);
	}
	 
}



