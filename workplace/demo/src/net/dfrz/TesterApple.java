/**
 * 
 */
package net.dfrz;

/**
 * @author Administrator
 *
 */
public class TesterApple {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t =new  Thread(new Mywork());
		t.setName("tt-1");
		t.start();
		
		int sum = 0;
		for(int i=300;i<400;i++){
			sum +=i;
			if(i%10==0)
				try {
					Thread.sleep(5000);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println(Thread.currentThread().getName()+"i"+i+"sum="+sum);
		}
		

	}

}
