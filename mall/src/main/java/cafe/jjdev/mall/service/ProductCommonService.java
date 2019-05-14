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
	public List<ProductCommon> getProductCommonListByCategoryNo(int categoryNo, int currentPage, String searchWord) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("categoryNo", categoryNo);
		final int ROW_PER_PAGE = 15;
		int startRow = (currentPage-1)*ROW_PER_PAGE;
		map.put("startRow", startRow);
		map.put("rowPerPage", ROW_PER_PAGE);
		map.put("searchWord", "%"+searchWord+"%");
		return productCommonMapper.selectProductCommonList(map);
	}
}
