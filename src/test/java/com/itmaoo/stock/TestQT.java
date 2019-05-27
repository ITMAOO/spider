package com.itmaoo.stock;

import com.itmaoo.spider.service.impl.QTStockService;

public class TestQT {
	public static void main(String[] args) {
		QTStockService service = new QTStockService();
		System.out.println(service.AllMarketAStock().size());
	}
}
