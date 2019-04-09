package com.itmaoo.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itmaoo.demo.view.DataProviderView;

@Controller
@RequestMapping("/define")
public class DefineController {
	
	@PostMapping("/saveProvider")
	public void saveProvider(DataProviderView dataProviderView) {
		//检查链接有效
		
		//保存链接
		
	}
	
	@PostMapping("/saveTable")
	public void saveTable(DataProviderView dataProviderView) {
		//保存表格
		
		
	}
}
