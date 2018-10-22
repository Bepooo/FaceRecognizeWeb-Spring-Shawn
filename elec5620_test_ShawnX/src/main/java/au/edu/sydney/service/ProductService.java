package au.edu.sydney.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import au.edu.sydney.dao.ProductDao;
import au.edu.sydney.domain.Product;
 
@Transactional
@Service(value="productService")
public class ProductService {
	
	@Autowired
	public ProductDao productDao;
	
	public void deleteProductById(int  id) {
		productDao.deleteProductById(id);
    }
	
	
/*	public List getProdcutByCompany(String co){
        return productDao.getProductByCompany(co);
    }*/

	
	public List getProducts() {
        return productDao.getProducts();
    }
	


	public List getProductsByQuery(String[] limits) {
		// TODO Auto-generated method stub
		return productDao.getProductByQuery(limits);
	}
}
