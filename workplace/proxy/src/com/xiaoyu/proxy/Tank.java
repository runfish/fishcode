package com.xiaoyu.proxy;
import java.util.Random;



public class Tank implements Moveable{

	@Override
	public void move() {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		System.out.println("tank.....move...");
		try {
			Thread.sleep(new Random().nextInt(10000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start);
	}

}
