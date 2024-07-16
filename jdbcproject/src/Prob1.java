import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Prob1 {
	public static void main(String[] args) {
		String[] array={"황남기85점","조성호89점","한인성88점","독고정진77점"};
//		printMaxScore(array);
		printMaxScore2(array);
	}	
	private static void printMaxScore2(String[] array){
		//정규표현식 사용
		String regExp = "([ㄱ-ㅎ가-힣]+)([0-9]+)점"; //group으로 나누기위해 ()로 나눔.
		String maxName ="";
		int maxScore = -1;
		for(String data:array) {
			//System.out.println(data);
			//boolean result = Pattern.matches(regExp, data);
			//System.out.println(result); //정규표현식맞는지확인
			 Pattern pattern = Pattern.compile(regExp);
			 Matcher matcher = pattern.matcher(data);
			 if(matcher.find()) {
				 String name = matcher.group(1); //첫번째():[ㄱ-ㅎ가-힣]
				 String score = matcher.group(2);
				 //System.out.println(name +"=="+score);
				 int iscore = Integer.parseInt(score); //숫자로변환
				 if(maxScore<iscore) {
					 maxScore = iscore;
					 maxName = name;
				 }
			 }	
		}
		System.out.println(maxName + maxScore);
	}
	private static void printMaxScore(String[] array){ 
		// 구현하세요. toCharArray사용(한문자씩잘라서)
		String maxName="";
		int maxScore = -1;//없는점수
		for(String data:array) {
			char[] arr = data.toCharArray();
//			System.out.println(Arrays.toString(arr));
			String name="", score="";
			for(char ch:arr) {
				if(!Character.isDigit(ch)) //숫자가 아닌것(이름)을 name에 담음. 
					name += ch;
//				System.out.println(ch + "===" + Character.isDigit(ch)); //digit(숫자) true
				else 
					score += ch;
			}
			if(maxScore < Integer.parseInt(score)) {
				maxScore = Integer.parseInt(score);
				maxName = name.substring(0, name.length()-1); //"점"뺴기
			}
//			System.out.println(name +" === "+score);
		}
		System.out.println(maxName + maxScore);
	}
}
