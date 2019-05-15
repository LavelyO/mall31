package cafe.jjdev.mall.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cafe.jjdev.mall.mapper.ProductCommonMapper;
import cafe.jjdev.mall.vo.ProductCommon;

@Service
@Transactional
public class ProductCommonService {
	@Autowired private ProductCommonMapper productCommonMapper;
	public Map<String, Object> getProductCommonListByCategoryNo(int categoryNo, int currentPage, String searchWord) {
		System.out.println(categoryNo +"<<<<categoryNo getProductCommonListByCategoryNo ProductCommonService.java");
		Map<String, Object> map = new HashMap<String, Object>();
		final int ROW_PER_PAGE = 15;//한 페이지에 15개씩 보여준다.
		int startRow = (currentPage-1)*ROW_PER_PAGE;//첫번째 행을 구하는 방법 : (현재 페이지-1)*15
		
		map.put("categoryNo", categoryNo);
		map.put("startRow", startRow);
		map.put("rowPerPage", ROW_PER_PAGE);
		map.put("searchWord", "%"+searchWord+"%");
		List<ProductCommon> list = productCommonMapper.selectProductCommonList(map);
		//int productCount = productCommonMapper.selectProductCommonListCount(categoryNo);
		int productCount = productCommonMapper.selectProductCommonCount(map);//전체 게시물의 수
		System.out.println(productCount + "----------------productCount getProductCommonListByCategoryNo ProductCommonService.java");
		int totalPage = productCount/ROW_PER_PAGE;		
		System.out.println(totalPage + "---------totalPage getProductCommonListByCategoryNo ProductCommonService.java");
		//int lastPage = totalPage/ROW_PER_PAGE;
		int lastPage=0;
		if(productCount%ROW_PER_PAGE == 0){
			lastPage = productCount/ROW_PER_PAGE;
			}
			else {
			lastPage = (productCount/ROW_PER_PAGE)+1;
			}
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", list);
		returnMap.put("productCount", productCount);
		returnMap.put("totalPage", totalPage);
		returnMap.put("lastPage", lastPage);
		return returnMap;
	}
	public ProductCommon getProductDetail(int productCommonNo) {
		return productCommonMapper.getProductDetail(productCommonNo);
	}
}
