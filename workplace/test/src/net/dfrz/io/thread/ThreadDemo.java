package net.dfrz.io.thread;

class demo implements Runnable {

	private String name;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		show();
	}

	public demo(String name) {
		this.name = name;
	}

	public void show() {
		for (int i = 0; i < 10; i++) {
			for (int j = -999; j < 999999; j++) {
			}
			System.out
					.println(this.name + i + Thread.currentThread().getName());
		}
	}

}

public class ThreadDemo {

	public static void main(String[] args) {

		Thread d1 = new Thread(new demo("xiaoyu"));
		Thread d2 = new Thread(new demo("ะกำใ"));

		d2.start();
		d1.start();
		// d1.run();
		// d2.run();
		// System.out.println(4/0);
		for (int x = 0; x < 300; x++) {
			System.out.println("over" + Thread.currentThread().getName());

		}
	}

}
