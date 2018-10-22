package au.edu.sydney.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.edu.sydney.dao.ShoppingassistDao;
import au.edu.sydney.domain.Shoppingassist;
 
@Transactional
@Service(value="shoppingassistService")
public class ShoppingassistService {
	
	@Autowired
	public ShoppingassistDao ShoppingassistDao;
	
	
	public void addShoppingassist(Shoppingassist shoppingassist) {
		ShoppingassistDao.saveShoppingassist(shoppingassist);
    }
	public void deleteShoppingassistById(int  id) {
		ShoppingassistDao.deleteShoppingassistById(id);
    }
	

	public List getShoppingassist() {
		// TODO Auto-generated method stub
		 return ShoppingassistDao.getShoppingassist();
	}

	public List getShoppingassists() {
		// TODO Auto-generated method stub
		return ShoppingassistDao.getShoppingassists();
	}
}
