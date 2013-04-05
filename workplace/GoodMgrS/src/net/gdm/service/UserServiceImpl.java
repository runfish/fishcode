/**
 * 
 */
package net.gdm.service;

import net.gdm.dao.UserDao;
import net.gdm.dao.UserDaoImpl;
import net.gdm.demo.User;
import net.gdm.exception.ApplicateionException;
import net.gdm.exception.DateAccessException;
import net.gdm.util.Page;

import org.omg.CORBA.portable.ApplicationException;

/**
 * @author Administrator
 * 
 */
public class UserServiceImpl implements UserService {
	UserDao userdao = new UserDaoImpl();

	@Override
	public void deFreezeUser(String userEmail) {
		// TODO Auto-generated method stub
		userdao.deFreezeUser(userEmail);
	}

	@Override
	public void freezeUser(String userEmail) {
		// TODO Auto-generated method stub
		userdao.freezeUser(userEmail);
	}

	@Override
	public User getUser(String userEmail) {
		User user = null;

		try {
			user = userdao.getOne(userEmail);
		} catch (DateAccessException e) {
			throw new ApplicateionException(e.getMessage());
		}

		return user;
	}

	@Override
	public Page loadPagedUser(UserQueryHelper helper, Page page) {
		// TODO Auto-generated method stub
		return userdao.loadPagedUser(helper, page);
	}

	@Override
	public void modifyInfo(User user) {
		// TODO Auto-generated method stub
		userdao.updateUser(user);
	}

	@Override
	public void modifyPwd(User user) {
		// TODO Auto-generated method stub
		userdao.modifyPwd(user);
	}

	@Override
	public void regUser(User user) {
		// TODO Auto-generated method stub
		userdao.addUser(user);
	}

	@Override
	public User checkUser(User user) {
		User u;
		u=getUser(user.getUser_email());
		if(!(u.getUser_pwd().equals(user.getUser_pwd())))
				throw new ApplicateionException("用户名密码错误，请检查!");	
		
        return u;
		
	}

}
