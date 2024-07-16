
class Prob3 {
	public static void main(String args[]){
		PhoneCharge skt = new PhoneCharge("김현우", 100, 50, 1);
		PhoneCharge ktf = new PhoneCharge("신희만", 200, 100, 2);
		PhoneCharge lgt = new PhoneCharge("조유성", 150, 500, 10);
		skt.printCharge();
		ktf.printCharge();
		lgt.printCharge();
	}
}

class PhoneCharge{	//구현하시오.
	private String user;
	private int call;
	private int sms;
	private int data;
	private int total;
	
	public PhoneCharge(String user, int call, int sms, int data) {
		//같은 이름의 멤버변수 값으로 초기화하는 문장을 정의한다. 
		this.user = user;
		this.call = call;
		this.sms = sms;
		this.data = data;
	}
	
	public void printCharge() {
	//user 값과 calcCharge() 메소드의 결과를 출력.
		System.out.println(user +"사용자" + calcCharge());
		
	}
	

	public int calcCharge() {
		/*지역변수 callFee  : int : 통화요금 
		기본 10원/1분. 단,  call  200분 이상이면 callFee는 기본의 2배로 증가 
		지역변수 smsFee : int : 문자요금
		기본 20원/1건. 단, sms  300건 이상이면 smsFee는 기본의 4배로 증가
		지역변수 dataFee : int : 데이터통신요금
		기본 1000원/1GB. 단, data  7GB 이상이면 dataFee는 기본의 2배로 증가
		 */
		//call >= 200 ? call * 20 : call * 10
//		int callFee =  call>=20 ? call*20 : call*10 ;
//		int smsFee = sms>=300 ? sms*80 : sms*20  ;
//		int dataFee = data>=7  ? data*2000 : data*1000;
//		
//		total = callFee + smsFee + dataFee ;
//		return total;
		
		int callFee = 10*call;
		int smsFee = 20*sms;
		int dataFee = 1000*data;
		
		if(call>=200) {
			callFee *= 2;
		}
		if(sms>=300) {
			smsFee *= 4;
		}
		if(data>=7) {
			dataFee *= 2;
		}
//		
		return total = callFee + smsFee + dataFee;
	}
	
	
		

		
}
 