package a_programmers.level0;

import java.util.Arrays;

public class 짝수는싫어요 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(10)));
	}
	
	//n 이하의 홀수가 오름차순으로 담긴 배열
	//10이하의 홀수[13579] 길이5 
    public static int[] solution(int n) {
       
    	int[] answer = new int[n];
    	
        //배열 생성 초기화 
        if(n%2 == 0){ //짝수
            answer = new int[n/2];
        }else{ //홀수
            answer = new int[n/2+1];
        }
        
        int oddcount = 0; //홀수값 넣을 인덱스
        
        //배열에 담긴 값이 n(10)이하 홀수
        for(int i=1; i<=n; i++) {
        	if(i%2 != 0 ) {
              	answer[oddcount] = i;
              	oddcount++;
        	}
        }
//        for(int e:answer) {
//        	System.out.println(e);
//        }
        return answer;
    }
	
}
