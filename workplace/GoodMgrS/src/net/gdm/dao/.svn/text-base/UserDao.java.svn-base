/**
 * 
 */
package net.gdm.dao;

import java.util.List;

import net.gdm.demo.SmallCategory;
import net.gdm.demo.User;
import net.gdm.service.UserQueryHelper;
import net.gdm.util.Page;

/**
 * @author Administrator
 *
 */
public interface UserDao {
	List<User> ListUser();
    void addUser(User user);
    void updateUser(User user);
    User getOne(int id);
    void deleteUser(int id);
    User getOne(String useremail);
    Page loadPagedUser(UserQueryHelper helper, Page page);
    void modifyPwd(User user);
    void freezeUser(String userEmail);
    void deFreezeUser(String userEmail);
}
