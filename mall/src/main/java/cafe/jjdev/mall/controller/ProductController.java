package cafe.jjdev.mall.controller;

import java.util.List;
import java.util.Map;

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
		System.out.println(categoryNo +"<<<<categoryNo list ProductController.java");
		model.addAttribute("categoryNo", categoryNo);
		Map<String, Object> map = productCommonService.getProductCommonListByCategoryNo(categoryNo, currentPage, searchWord);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("lastPage", map.get("productCount"));
		model.addAttribute("totalPage", map.get("totalPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		return "/product/list";
	}
	@GetMapping("/product/detail")
	public String productDetail(Model model, @RequestParam(value="productCommonNo") int productCommonNo) {
		ProductCommon productCommon = productCommonService.getProductDetail(productCommonNo);
		System.out.println(productCommon + "<-----productCommon productDetail ProductController.java");
		model.addAttribute("productCommon", productCommon);
		return "/product/detail";
	}
	
	
}
