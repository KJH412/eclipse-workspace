import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Prob5 {
	public static void main(String[] args) {
		int[] answer = { 1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2 };
		int[] counter = new int[4];

		// 구현하시오 - 숫자들의 개수를 세어 저장하는 코드를 작성한다.
		//방법1.for문 switch,case
		/*
		for(int num : answer) {
			switch 
		}
		//방법2.for문
		/*
		for(int num : answer) {
			counter[num-1]++;
		}
		*/
		//방법3.어렵
		/*
		List<Integer> list = Arrays.stream(answer)
				.boxed()
				.collect(Collectors.toList());
		
		for(int i=1; i<=4; i++) {
			counter[i-1] = Collections.frequency(list, i);
		}
		*/
		// 구현하시오 - 출력결과와 같이 나오도록 작성한다.
		

	}
}

/*
 * [조건]
answer배열에 저장된 숫자들의 개수를 세어 counter배열에 저장하는 코드이다.  
<<실행결과>>
1의 갯수는 3개 입니다.
2의 갯수는 2개 입니다.
3의 갯수는 2개 입니다.
4의 갯수는 4개 입니다.
*/
