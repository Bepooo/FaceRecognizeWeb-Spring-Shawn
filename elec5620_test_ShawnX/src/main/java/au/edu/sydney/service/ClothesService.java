package au.edu.sydney.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import au.edu.sydney.dao.ClothesDao;
import au.edu.sydney.domain.Clothes;
 
@Transactional
@Service(value="clothesService")
public class ClothesService {
	
	@Autowired
	public ClothesDao clothesDao;
	
	public void deleteClothesById(int  id) {
		clothesDao.deleteClothesById(id);
    }
	
	
/*	public List getProdcutByCompany(String co){
        return productDao.getProductByCompany(co);
    }*/

	
	public List getClothes() {
        return clothesDao.getClothes();
    }
	


	public List getClothesByQuery(String[] limits) {
		// TODO Auto-generated method stub
		return clothesDao.getClothesByQuery(limits);
	}
}
