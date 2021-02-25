package com.cg.threadingdemos;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorDemo {
	public static void main(String[] args) {
		
			//FunctionalInterfaces
		
		//SAM
		
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				try {
				for (int i=0;i<5;i++)
				{
				   Thread.sleep(2000);
					System.out.println(i+2);
				}}
				catch(InterruptedException e) {e.getMessage();}
				
				
				
			}};
		
		
			
			Runnable r2 = ()->{
					try {
					for (int i=0;i<5;i++)
					{
					   Thread.sleep(2000);
						System.out.println(i+2);
					}}
					catch(InterruptedException e) {e.getMessage();}
					
					
					
				};
			
				
		Thread t1 =  new Thread(r2,"R2");
		t1.start();
		
			
		Runnable greetingTask = ()->{
			try {
				
				
				
			Thread.sleep(1000);
			System.out.println("hello there ");}
			catch(InterruptedException  e) {e.printStackTrace();}
		};

		
		Executor executor = Executors.newSingleThreadExecutor();
		
		executor.execute(greetingTask);
		
		
		Executor executor2 = Executors.newFixedThreadPool(3);
		
		executor2.execute(r2);
		
		Callable<Integer> callabl1 = ()->{return 45;};
		
		Callable<String> call2 = ()->{
			
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter name");
			String name =  scanner.nextLine();
			return "hello there ,how are you"+name;
		};
		
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		Future<String> username = service.submit(call2);
		
		try {
			System.out.println(username.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
