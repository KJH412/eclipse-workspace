package com.shinhan.day06.lab;

abstract class Machine {
	public void powerOn() {}
	public void powerOff() {}
	public abstract void work();

}

public class Computer extends Machine{
	//추상메서드 work()구현
	@Override
	public void work(){
		
	}
}
