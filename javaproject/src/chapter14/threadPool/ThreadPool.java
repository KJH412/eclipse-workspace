package chapter14.threadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//스레드풀(ThreadPool)
public class ThreadPool {
	public static void main(String[] args) {
		//1.newCachedThreadPool() 정적메소드로 호출, 이것이 리턴하는 것은 ExecutorService의 구현객체임. ExecutorService인터페이스로 대입을 받아야한다.
		//ExecutorService executorService 이것 자체가 스레드 풀이라고 생각하면 된다.
//1		ExecutorService executorService = Executor.newCachedThreadPool(); //기본60초
		
		//2.newFixedThreadPool()로 스레드풀 생성 -> 초기수0개, 작업개수많아지면 5개까지 스레드 생성시켜 작업처리한다.
//2		ExecutorService executorservice = Executor.newFixedThreadPool(5);
		
		//3.직접 정학하게 스레드풀 만들기(생성)
		ExecutorService threadPool = new ThreadPoolExecutor(
				3,   	//코어 스레드 개수 : 초기에는 0개인데 스레드생성되고나서 사용-> 놀고있는스레드가 많이발생-> 3개만 남겨놓고 제거하겠단 뜻.
				100, 	//최대 스레드 개수
				120L, 				//놀고 있는 시간 (단위를 SECONDS로 줘서 120초->120초동안 놀고있으면 종료시키겠다.)
				TimeUnit.SECONDS, 	//놀고 있는 시간 단위
				new SynchronousQueue<Runnable>()); //작업 큐	SynchronousQueue:동기화된큐
									//<Runnable>여기들어오는건 결국 작업객체의 종류임. Runnable객체를 저장하는 큐를 쓰겠단 뜻.
	}
	
}
