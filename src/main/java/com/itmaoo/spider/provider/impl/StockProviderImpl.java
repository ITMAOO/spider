package com.itmaoo.spider.provider.impl;

import com.itmaoo.spider.chain.ServiceChain;
import com.itmaoo.spider.domain.Stock;
import com.itmaoo.spider.provider.StockProvider;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


public class StockProviderImpl implements StockProvider {



	public BigDecimal getStockNowPrice(String stockCode) {
		return new com.itmaoo.spider.chain.ServiceChain().getStockNowPrice(stockCode);
	}

	public BigDecimal getStockYesPrice(String stockCode) {
		return new com.itmaoo.spider.chain.ServiceChain().getStockYesPrice(stockCode);
	}

	public BigDecimal getStockOpenPrice(String stockCode) {
		return new ServiceChain().getStockOpenPrice(stockCode);
	}

	public Map<String, BigDecimal> getMapPrice(List<String> stockCodeList,
											   String field) {
		return new ServiceChain().getMapPrice(stockCodeList, field);
	}

	public Stock getStockInfo(String stockCode) {
		return new ServiceChain().getStockInfo(stockCode);
	}

	public List<Stock> getStockInfoList(List<String> stockCodeList) {
		return new ServiceChain().getStockInfoList(stockCodeList);
	}

	public List<Stock> AllMarketAStock() {
		return new ServiceChain().AllMarketAStock();
	}

}
