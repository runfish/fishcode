/**
 * 
 */
package net.dfrz;

/**
 * @author Administrator
 *
 */
public class Mywork implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i=100;i<200;i++){
			sum +=i;
			System.out.println(Thread.currentThread().getName()+"i="+i+"sum="+sum);
		}
			
		
	}

}
