package com.itmaoo.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itmaoo.demo.search.TableSearch;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	@PostMapping("/table")
	public void table(TableSearch tableSearch) {
		//检查链接有效
		//tableSearch.
		//保存链接
		
	}
}
