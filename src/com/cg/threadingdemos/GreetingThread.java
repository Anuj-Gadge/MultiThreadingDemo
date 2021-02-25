package com.cg.threadingdemos;

public class GreetingThread extends Thread{
	
	public void greeting() {
		System.out.println("hello to all");
		
	}

	public void run() {
		
		for(int i=0;i<5;i++)
		{
			greeting();
		}
		
	}
	
	public static void main(String[] args) {
		
		//start is going to invoke run method
		new GreetingThread().start();
		
		//to create a thread object ,we directly created the instance of the main class
		GreetingThread gt = new GreetingThread();
		gt.start();
		
		
		
	}
}
