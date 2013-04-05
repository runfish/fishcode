/**
 * 
 */
package net.gdm.dao;
import java.util.List;

import net.gdm.demo.Admine;
import net.gdm.service.AdmineQueryHelper;
import net.gdm.util.Page;
/**
 * @author Administrator
 *
 */
public interface AdmineDao {
     List<Admine> ListAdmine();
     void addAdmine(Admine admine);
     void updateAdmine(Admine admine);
     Admine getOne(int admineid);
     void deleteAdmine(int admineid);
     Admine getOne(String email);
     void modifyPwd(Admine adm);
     Page loadPagedAdmine(AdmineQueryHelper helper, Page page);
}
