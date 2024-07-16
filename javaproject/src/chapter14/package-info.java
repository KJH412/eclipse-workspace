package chapter14;

/* 스레드 최대 21억개 만들 수 있음...
 * 스레드는 보통 서버(서버개발)를만들거나 안드로이드에서 많이 사용한다. 웹(어플리케이션)개발에는 거의 안사용함.
 * 스레드(Thread)는 이름이 있다.
 * 
 * 1.싱글스레드 : main()메소드의 첫코드부터 순차적으로 실행하고, 마지막 코드를 실행하거나 return문을 만나면 실행 종료.
 * 2.멀티스레드 : 
 * 예를들어, 렉 걸린다.(스레드가 종료하지못하는상태란 뜻.) -> 프로세스가 종료못함 -> 보통 전원끄기재부팅(강제종료)
 * 하나의 프로세스에 스레드가 여러개여서 그 스레드가 모두 꺼져야 프로세스가 종료되고, 실행중인 스레드가 하나라도 있으면 프로세스 종료 안함.
 * 포인트! 마지막 하나의 스레드까지 종료가 되어야 프로세스가 종료된다.
 * 
 * ☆☆☆
 * 3.스레드풀(ThreadPool, ExcutorService)  (앞으로 '풀'이라는 용어는 여러객체를 관리한다고 생각해라.)
 * 만약 스레드가 100개가 있다? 근데 스레드10개가 생성되는 시점에 첫번쨰 스레드 작업이 끝날 수도 있잖아? 이렇게 100개가만들어지면 => 스레드낭비!!
 * 이러면 그냥 10개만 만들어서 첫번째께 끝나면 11번쨰로가서 실행하고 두번쨰껀 12번째로 재사용하하면서 100개를 처리할 수도 있다.
 * 100개가 작업큐에 들어오면 스레드10개(최대개수)가 다 처리를 하게된다.
 * 
 * 3-1.작업큐(Queue) : 먼저들어온걸 먼저처리한다. 각 스레드는 큐에서 작업을 가져와 처리함.
 * 
 * 스레드풀을 처음에 만들 때 스레드 몇개를 사용하겠다고 지정을 함. -> 스레드풀한테 작업을 준다. ->먼저요청들어온 작업을 앞에, 그다음 뒤에 저장해뒀다가
 * -> 하나씩 스레드에 배정을 해서 처리를 시키고 우리가지정한 스레드개수보다 많은 작업이 들어올 경우에는 먼저 작업처리가 끝난 스레드한테 다음작업을 배정한다.
 * 
 * 1.어플리케이션이 작업 요청 -> 2.작업큐 ->3.(최대개수 정해둔)다른스레드->4.결과 전달
 * 
 * 작업량에 비해 스레드가 너무 적게 만들어졌다면 작업처리가 늦어진다. (예를들어, 은행직원이 2명이면 줄서서 기다려야하니까)
 * 그럼 스레드를 계속만들어 근데? 다시 줄일 수도 있음.
 * 
 * 초기수: 스레드가 몇개있느냐
 * 코어수: oooooooooo스레드10개만들었음-> 작업량줄어들면 놀고있는 스레드 제거하는데 최소한 몇개만 남겨놓고 제거하겠다.(코어수 빼고 제거)
 * 
 * 놀고있다고 무조건 종료하는게 아니라서 종료조건이 필요함.
 * 
 * 3-2.스레드풀 생성 -> ThreadPool.java참고
 * 
 * 3-3.스레드풀 종료
 * 1)shutdown() : 리턴타입void , 모든작업이 처리완료될때까지 기다려주고 종료한다.(처리완료안돼면 종료안함.) => 안전하게 종료. (권장)
 * 2)shutdownNow() : 리턴타입List<Runnable> , 작업과 관계없이 강제로 지금당장종료(작업큐에 있는 작업들 List에 담아서 리턴함,List에 미처리된 작업객체들이 있음) 
 * => 작업큐에 있는 내용은 작업처리하기 전이었기 때문에 리턴값으로 나오는것임.
 *
 * 
 * 
 * 
 * 
 * 
 * 
 *
 */
