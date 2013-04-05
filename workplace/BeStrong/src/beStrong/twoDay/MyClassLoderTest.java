/**
 * 
 */
package beStrong.twoDay;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * @author Administrator
 *
 */
public class MyClassLoderTest extends ClassLoader {

	
	public static void main(String[] args)throws Exception {
		String srcPath = args[0];
		String descDir = args[1];
		FileInputStream fis = new FileInputStream(srcPath);
		String descFileName = srcPath.substring(srcPath.lastIndexOf('\\')+1);
		String descPath = descDir+'\\'+descFileName;
		FileOutputStream fos = new FileOutputStream(descPath);
		cypher(fis, fos);
		fis.close();
		fos.close();
		
		
	}
	
	private  String classDir;
	
	public static void cypher(InputStream ips,OutputStream ops)throws Exception{
		int  b = -1;
		while((b=ips.read())!=-1){
			ops.write(b ^ 0xff);
		}
		
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		String fileName = classDir +"\\" +name+".class";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(fileName);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			cypher(fis, bos);
			fis.close();
			byte[] bytes = bos.toByteArray();
			return defineClass(bytes, 0, bytes.length);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.findClass(name);
	}
	

	public MyClassLoderTest(){
		
	}
	
	public MyClassLoderTest(String classDir){
		this.classDir = classDir;
	}
	
	
}