/**
 * 
 */
package net.dfrz.hibernate.test;

/**
 * @author Administrator
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] countId ={1,23,4,56,7,89,22,3456,3,4,5,6,2,41,21,5};
		for(int i =0;i<countId.length; i++){
			for(int j=i+1; j<countId.length;j++){
				if(countId[i]<countId[j]){
					int temp = countId[i];
					countId[i] = countId[j];
					countId[j] = temp;
				}
			}
		}
		System.out.println(countId[0]);

	}

}
