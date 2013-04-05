package net.dfrz.io.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerCusDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resource2 r = new Resource2();
		Producer producer = new Producer(r);
		CusCustom cus = new CusCustom(r);
		Thread t1 = new Thread(producer);
		Thread t3 = new Thread(producer);
		Thread t2 = new Thread(cus);
		Thread t4 = new Thread(cus);
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}

class Resource2 {
	private String name;
	private int count = 1;
	private boolean flag = false;

	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	Condition condition1 = lock.newCondition();

	public void set(String name) {
		lock.lock();
		try {
			while (flag) {
				try {
					condition.await();

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.name = name;
			count++;
			System.out.println(Thread.currentThread().getName()
					+ "....����������..." + this.name + "��" + this.count + "��");
			flag = true;
			condition1.signal();
		} finally {
			lock.unlock();
		}

	}

	public void out() {
		lock.lock();
		try {
			while (!flag) {
				try {
					condition1.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()
					+ "....����������..." + this.name + "....��" + this.count + "��");

			flag = false;
			condition.signal();;
		} finally {
			lock.unlock();
		}

	}

}

class Producer implements Runnable {

	private Resource2 r;

	public Producer(Resource2 r) {
		this.r = r;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			r.set("��Ѽ");

		}

	}

}

class CusCustom implements Runnable {

	private Resource2 r;

	public CusCustom(Resource2 r) {
		this.r = r;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			r.out();

		}

	}

}