package com.itmaoo.spider.controller;

import com.itmaoo.spider.domain.Stock;
import com.itmaoo.spider.provider.impl.StockProviderImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itmaoo.spider.search.TableSearch;

import javax.xml.ws.Response;

@Controller
@RequestMapping("/search")
public class SearchController {

	@GetMapping("/stocks")
	public void stocks( ) {
		//检查链接有效
		//tableSearch.
		//保存链接

	}
	@GetMapping("/stock/{code}")
	public ResponseEntity<Stock> stackCode(@PathVariable("code") String code) {

		Stock s = null;
		try {
			s = new StockProviderImpl().getStockInfo(code);
		}catch (Exception e){
			ResponseEntity.status(HttpStatus.FORBIDDEN);
		}

		return  ResponseEntity.ok(s);
	}
}
