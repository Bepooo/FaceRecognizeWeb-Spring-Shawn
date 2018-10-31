package au.edu.sydney.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import au.edu.sydney.domain.Admin;
import au.edu.sydney.dao.AdminDao;
 
@Transactional
@Service(value="adminService")
public class AdminService {
	
	@Autowired
	public AdminDao AdminDao;
	
	
	public void addAdmin(Admin admin) {
		AdminDao.saveAdmin(admin);
    }
	public void deleteShoppingassistById(int  id) {
		AdminDao.deleteAdminById(id);
    }
	
	public List getAdmins() {
		// TODO Auto-generated method stub
		return AdminDao.getAdmins();
	}
	
	public Admin getAdminByQuery(String[] limits) {
		// TODO Auto-generated method stub
		return AdminDao.getAdminByQuery(limits);
	}

}
