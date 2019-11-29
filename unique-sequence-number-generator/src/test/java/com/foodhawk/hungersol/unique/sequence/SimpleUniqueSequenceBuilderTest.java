package com.foodhawk.hungersol.unique.sequence;

import com.indhawk.unique.sequence.SimpleUniqueSequenceBuilder;

public class SimpleUniqueSequenceBuilderTest {

	private static SimpleUniqueSequenceBuilder sequenceBuilder = new SimpleUniqueSequenceBuilder(100, 1000000001L);
	
	public static void generateUniqueId() {
		long id = sequenceBuilder.getNextId();
		System.out.println(id);
	}
	

	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					generateUniqueId();
				}
			}
		});
		
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 9000; i++) {
					generateUniqueId();
				}
				
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			Thread.currentThread().join(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Size =" + sequenceBuilder.size() );
	}
}
