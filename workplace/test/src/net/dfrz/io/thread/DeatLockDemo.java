package net.dfrz.io.thread;

public class DeatLockDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeatLockTest a = new DeatLockTest(false);
		DeatLockTest b = new DeatLockTest(true);
		Thread t1= new Thread(a);
		Thread t2= new Thread(b);
		t1.start();
		t2.start();

	}

}

class DeatLockTest implements Runnable {

	private boolean flag;

	public DeatLockTest(boolean flag) {
		super();
		this.flag = flag;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		if (flag) {
			synchronized (MyLOck.lock1) {
				System.out.println("if    lock1  ....");
				synchronized (MyLOck.lock2) {
					System.out.println("if    lock2  ....");

				}
			}
		} else {
			synchronized (MyLOck.lock2) {
				System.out.println("else    lock2  ....");

				synchronized (MyLOck.lock1) {
					System.out.println("else    lock2  ....");

				}
			}
		}

	}
}

class MyLOck {
	public static final Object lock1 = new Object();
	public static final Object lock2 = new Object();

}
