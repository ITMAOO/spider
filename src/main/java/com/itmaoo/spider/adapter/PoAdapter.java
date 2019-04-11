package com.itmaoo.spider.adapter;

import com.itmaoo.spider.dao.po.DataProviderPo;
import com.itmaoo.spider.view.DataProviderView;

public class PoAdapter {
	public static DataProviderPo getDataProvider(DataProviderView view) {
		DataProviderPo dataProviderPo = new DataProviderPo();
		dataProviderPo.setCode(view.getCode());
		dataProviderPo.setName(view.getName());
		dataProviderPo.setParams(view.getParams());
		dataProviderPo.setRequestType(view.getRequestType());
		dataProviderPo.setUrl(view.getUrl());
		dataProviderPo.setFetchRegexMidle(view.getFetchRegexMidle());
		return dataProviderPo;
	}
}
