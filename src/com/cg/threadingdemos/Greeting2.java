package com.cg.threadingdemos;

public class Greeting2 implements Runnable {

	@Override
	public void run() {
		String []names = {"anita","pritika","hetal"};
		
		for(String name:names) {
			try
			{
			Thread.sleep(2000);
			}
			catch(InterruptedException  ie) {
				System.out.println("Thread sleep interrupted");
			}
			System.out.println("hello"+name +Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		
		Runnable r1 = new Greeting2();
	
		Thread t1 =  new Thread(r1,"T1");
		
		Thread t2 = new Thread(new Greeting2(),"T2");
		
		Thread t3 = new Thread(new Greeting2(),"T3");
		
		t1.start();
		
		try
		{
			t1.join(5000);
			
			
		}catch(InterruptedException ie) {
			System.out.println("t1 is still executing");
		}
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		}
		catch(InterruptedException iee)
		{
			iee.getMessage();
		}
		System.out.println("All threads are dead , exiting main thread");
		
		
		
		
		
		
	}
	//extends Thread    		v/s implementing Runnable
	//worker threads 			define tasks
	//itself a Thread      		Thread obj wraps around Runnable
	//cannot extends 			can extend
	//only once		        	tasks can be performed worker threads
	//limited support			concurrent framework
	//run()						run()
	//lifecycle interrupt()		not possible to override life cycle methods of a thread
	
	
	
	
	

}
