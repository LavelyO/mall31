package cafe.jjdev.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.jjdev.mall.service.ProductCommonService;
import cafe.jjdev.mall.vo.Category;
import cafe.jjdev.mall.vo.ProductCommon;

@Controller
public class ProductController {
	@Autowired private ProductCommonService productCommonService;
	@GetMapping("/product/list")
	public String list(Model model, @RequestParam(value="categoryNo") int categoryNo
			, @RequestParam(value="currentPage", defaultValue = "1") int currentPage
			, @RequestParam(value="searchWord", defaultValue="") String searchWord) {
		model.addAttribute("categoryNo", categoryNo);
		List<ProductCommon> list = productCommonService.getProductCommonListByCategoryNo(categoryNo, currentPage, searchWord);
		model.addAttribute("list", list);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("searchWord", searchWord);
		return "/product/list";
	}
	
	
}
