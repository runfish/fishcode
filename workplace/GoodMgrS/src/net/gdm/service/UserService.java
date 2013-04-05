/**
 * 
 */
package net.gdm.service;
import net.gdm.demo.User;
import net.gdm.util.Page;

/**
 * users 表中的user_email字段应该加 unique约束
 * 
 *
 */
public interface UserService {

	void regUser(User user);
	void modifyInfo(User user);
	void modifyPwd(User user);
	void freezeUser(String userEmail);
	void deFreezeUser(String userEmail);
	User getUser(String userEmail);
	
	User checkUser(User user);
	
	Page loadPagedUser(UserQueryHelper helper,Page page);
	
}
