package com.concurrency;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorsCallableDemo {

	public static void main(String[] args) {
		// Demo Callable task

		Callable<String> callableTask = () -> {
			TimeUnit.MILLISECONDS.sleep(1000);
			return "Current time :: " + LocalDateTime.now();
		};

		// Executor service instance
		ExecutorService executor = Executors.newFixedThreadPool(1);
		
		//ExecutorService executor = Executors.newCachedThreadPool();

		List<Callable<String>> tasksList = Arrays.asList(callableTask, callableTask, callableTask);

		
				
		
		
		try {
			List<Future<String>> results = executor.invokeAll(tasksList);

			for (Future<String> result : results) {
				System.out.println(result.get());
			}
		} catch (InterruptedException | ExecutionException e1) {
			e1.printStackTrace();
		}

		// 2. execute individual tasks using submit() method
		Future<String> result = executor.submit(callableTask);

		while (result.isDone() == false) {
			try {
				System.out.println("The method return value : " + result.get());
				break;
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}

			// Sleep for 1 second
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Shut down the executor service
		executor.shutdownNow();

	}

}
