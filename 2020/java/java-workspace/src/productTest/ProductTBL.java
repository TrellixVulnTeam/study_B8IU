package productTest;

import java.util.Vector;

public class ProductTBL {
	Vector<ProductVO> productList = new Vector<ProductVO>();
	
	boolean insert(String name, int price) {
		return insert(name, price, 1);
	}
	
	
	boolean insert(String name, int price, int count) {
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getName() == name) {
				return false;
			}
		}
		
		ProductVO productVO = ProductVO.insert(name, price, count);
		
		return true;
	}
}