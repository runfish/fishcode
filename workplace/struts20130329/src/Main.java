import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;


public class Main {

	public static void main(String[] args) {
	     HttpClient client = new HttpClient();  
	     GetMethod get=new GetMethod("http://www.qq.com/");
	     try {
			int i=client.executeMethod(get);
			System.out.println(i);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
}
