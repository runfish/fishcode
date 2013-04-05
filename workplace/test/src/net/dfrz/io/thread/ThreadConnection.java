package net.dfrz.io.thread;

public class ThreadConnection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 创建资源
		Resource r = new Resource();
		// 创建线程任务
		Input input = new Input(r);
		Output output = new Output(r);

		Thread t1 = new Thread(input);
		Thread t2 = new Thread(output);

		t1.start();
		t2.start();

	}

}

class Resource {

	private String name;

	private String sex;

	private boolean flag = false;

	public synchronized void set(String name, String sex) {

		if (flag)
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		this.name = name;
		this.sex = sex;
		flag = true;
		this.notify();

	}

	public synchronized void out() {
		if (!flag)
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		System.out.println(this.name + "\t" + this.sex);
		flag = false;
		this.notify();

	}

}

class Input implements Runnable {

	private Resource r;

	public Input(Resource r) {
		this.r = r;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int x = 0;
		while (true) {

			if (x == 0) {
				r.set("xiaoyu", "man");
				x = 1;
			} else {
				r.set("lh", "gril");
				x = 0;
			}

		}

	}
}

class Output implements Runnable {
	private Resource r;

	public Output(Resource r) {
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
