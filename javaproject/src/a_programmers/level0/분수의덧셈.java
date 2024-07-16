package a_programmers.level0;

import java.util.Arrays;

public class 분수의덧셈 {

	public static void main(String[] args) {
		System.out.println(solution(1,2,3,4)); //1/2 , 3/4 
	}
	//첫 번째 분수의 분자와 분모를 뜻하는 numer1, denom1, 
	//두 번째 분수의 분자와 분모를 뜻하는 numer2, denom2가 매개변수로 주어집니다. 
	//두 분수를 '더한 값'을 기약 분수로 나타냈을 때 분자와 분모를 순서대로 담은 배열을 return
	//입출력 예 #1
	//1 / 2 + 3 / 4 = 5 / 4입니다. 따라서 [5, 4]를 return 합니다.
    public static int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {};
        //2*3 , 4*1 
        int numer = (denom1*numer2) + (denom2*numer1); //분자의 합
        int denom  = denom1*denom2 ; //분모 
        int same = 0; //(최대공약수)나눠서 나머지가 0이 되는 값 
        
        int small = (numer<denom) ? numer : denom;
        
        
        for(int i=0; i<small; i++) {
        	if(numer % i == 0 && denom % i == 0) {
        		same = i;
        	}
        }
        //answer = {numer/same , denom/same};
        
        return answer;
    }

}
