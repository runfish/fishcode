/**
 * 
 */
package net.gdm.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Administrator
 *
 */
public class SysUtils {
	
	public static String getSrvPath(HttpServletRequest request)
	{
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		return basePath;
	}

}
