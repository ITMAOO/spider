package com.itmaoo.spider.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.itmaoo.spider.adapter.PoAdapter;
import com.itmaoo.spider.dao.DataProviderDao;
import com.itmaoo.spider.dao.TableDefineDao;
import com.itmaoo.spider.dao.po.DataProviderPo;
import com.itmaoo.spider.fetcher.JsonApiClient;
import com.itmaoo.spider.util.JsonUtils;
import com.itmaoo.spider.util.SpiderStrings;
import com.itmaoo.spider.view.DataProviderView;
import com.itmaoo.spider.view.TableDefineView;
import com.itmaoo.spider.view.table.TableColumnView;

@RestController
@RequestMapping("/define")
public class DefineController {
	@Autowired
	private DataProviderDao dataProviderDao;
	
	@PostMapping("/saveProvider")
	public void saveProvider(@RequestBody DataProviderView dataProviderView) {
		//检查链接有效
		String response = JsonApiClient.get(dataProviderView.getUrl()+dataProviderView.getParams(), UUID.randomUUID().toString());
		String json = SpiderStrings.fetchRegexMidle(dataProviderView.getFetchRegexMidle(), response);
		
		
		
		//保存链接
		dataProviderDao.save(PoAdapter.getDataProvider(dataProviderView));
		
	}
	
	@PostMapping("/saveTable")
	public void saveTable(TableDefineView tableDefineView) {
		//保存表格
		
		
	}
	@PostMapping("/saveTableCheck")
	public Map<String,String> saveTableCheck(@RequestBody TableDefineView tableDefineView) {
		//保存表格
		Map<String,String> map = new HashMap<String, String>();
		for(TableColumnView row:tableDefineView.getRowDefine()) {
			DataProviderPo dataProviderPo = dataProviderDao.findById(row.getProviderId());
			String response = JsonApiClient.get(dataProviderPo.getUrl()+dataProviderPo.getParams(), UUID.randomUUID().toString());
			String json = SpiderStrings.fetchRegexMidle(dataProviderPo.getFetchRegexMidle(), response);
			String test = "{total:\"588\",data:[{symbol:\"sh600359\",inner_code:\"600359\",symbol_name:\"新农开发\",avg_targetprice:\"26.400\",avg_incpercent:\"325.12\",sumdate:\"2019-04-11\"},{symbol:\"sz002310\",inner_code:\"002310\",symbol_name:\"东方园林\",avg_targetprice:\"25.400\",avg_incpercent:\"211.28\",sumdate:\"2019-04-11\"},{symbol:\"sz002458\",inner_code:\"002458\",symbol_name:\"益生股份\",avg_targetprice:\"58.000\",avg_incpercent:\"157.78\",sumdate:\"2019-04-11\"},{symbol:\"sz300409\",inner_code:\"300409\",symbol_name:\"道氏技术\",avg_targetprice:\"40.000\",avg_incpercent:\"135.71\",sumdate:\"2019-04-11\"},{symbol:\"sh603111\",inner_code:\"603111\",symbol_name:\"康尼机电\",avg_targetprice:\"12.400\",avg_incpercent:\"134.85\",sumdate:\"2019-04-11\"},{symbol:\"sz300348\",inner_code:\"300348\",symbol_name:\"长亮科技\",avg_targetprice:\"35.000\",avg_incpercent:\"107.10\",sumdate:\"2019-04-11\"},{symbol:\"sz000976\",inner_code:\"000976\",symbol_name:\"华铁股份\",avg_targetprice:\"10.290\",avg_incpercent:\"96.75\",sumdate:\"2019-04-11\"},{symbol:\"sh603363\",inner_code:\"603363\",symbol_name:\"傲农生物\",avg_targetprice:\"34.130\",avg_incpercent:\"94.14\",sumdate:\"2019-04-11\"},{symbol:\"sz000537\",inner_code:\"000537\",symbol_name:\"广宇发展\",avg_targetprice:\"16.700\",avg_incpercent:\"83.72\",sumdate:\"2019-04-11\"},{symbol:\"sz002117\",inner_code:\"002117\",symbol_name:\"东港股份\",avg_targetprice:\"36.010\",avg_incpercent:\"72.30\",sumdate:\"2019-04-11\"},{symbol:\"sz002876\",inner_code:\"002876\",symbol_name:\"三利谱\",avg_targetprice:\"75.000\",avg_incpercent:\"72.02\",sumdate:\"2019-04-11\"},{symbol:\"sh601137\",inner_code:\"601137\",symbol_name:\"博威合金\",avg_targetprice:\"15.800\",avg_incpercent:\"66.84\",sumdate:\"2019-04-11\"},{symbol:\"sz300476\",inner_code:\"300476\",symbol_name:\"胜宏科技\",avg_targetprice:\"22.830\",avg_incpercent:\"65.20\",sumdate:\"2019-04-11\"},{symbol:\"sz300423\",inner_code:\"300423\",symbol_name:\"鲁亿通\",avg_targetprice:\"46.290\",avg_incpercent:\"63.28\",sumdate:\"2019-04-11\"},{symbol:\"sh600068\",inner_code:\"600068\",symbol_name:\"葛洲坝\",avg_targetprice:\"12.500\",avg_incpercent:\"61.29\",sumdate:\"2019-04-11\"},{symbol:\"sz002285\",inner_code:\"002285\",symbol_name:\"世联行\",avg_targetprice:\"9.860\",avg_incpercent:\"56.26\",sumdate:\"2019-04-11\"},{symbol:\"sh600667\",inner_code:\"600667\",symbol_name:\"太极实业\",avg_targetprice:\"11.700\",avg_incpercent:\"56.21\",sumdate:\"2019-04-11\"}]}";
			String value = JsonUtils.getSubString(test, "total");
			System.out.println(value);
		}
		
		return map;
		
	}
	public static void main(String[] args) {
		String test = "{total:\"588\",data:[{symbol:\"sh600359\",inner_code:\"600359\",symbol_name:\"新农开发\",avg_targetprice:\"26.400\",avg_incpercent:\"325.12\",sumdate:\"2019-04-11\"},{symbol:\"sz002310\",inner_code:\"002310\",symbol_name:\"东方园林\",avg_targetprice:\"25.400\",avg_incpercent:\"211.28\",sumdate:\"2019-04-11\"},{symbol:\"sz002458\",inner_code:\"002458\",symbol_name:\"益生股份\",avg_targetprice:\"58.000\",avg_incpercent:\"157.78\",sumdate:\"2019-04-11\"},{symbol:\"sz300409\",inner_code:\"300409\",symbol_name:\"道氏技术\",avg_targetprice:\"40.000\",avg_incpercent:\"135.71\",sumdate:\"2019-04-11\"},{symbol:\"sh603111\",inner_code:\"603111\",symbol_name:\"康尼机电\",avg_targetprice:\"12.400\",avg_incpercent:\"134.85\",sumdate:\"2019-04-11\"},{symbol:\"sz300348\",inner_code:\"300348\",symbol_name:\"长亮科技\",avg_targetprice:\"35.000\",avg_incpercent:\"107.10\",sumdate:\"2019-04-11\"},{symbol:\"sz000976\",inner_code:\"000976\",symbol_name:\"华铁股份\",avg_targetprice:\"10.290\",avg_incpercent:\"96.75\",sumdate:\"2019-04-11\"},{symbol:\"sh603363\",inner_code:\"603363\",symbol_name:\"傲农生物\",avg_targetprice:\"34.130\",avg_incpercent:\"94.14\",sumdate:\"2019-04-11\"},{symbol:\"sz000537\",inner_code:\"000537\",symbol_name:\"广宇发展\",avg_targetprice:\"16.700\",avg_incpercent:\"83.72\",sumdate:\"2019-04-11\"},{symbol:\"sz002117\",inner_code:\"002117\",symbol_name:\"东港股份\",avg_targetprice:\"36.010\",avg_incpercent:\"72.30\",sumdate:\"2019-04-11\"},{symbol:\"sz002876\",inner_code:\"002876\",symbol_name:\"三利谱\",avg_targetprice:\"75.000\",avg_incpercent:\"72.02\",sumdate:\"2019-04-11\"},{symbol:\"sh601137\",inner_code:\"601137\",symbol_name:\"博威合金\",avg_targetprice:\"15.800\",avg_incpercent:\"66.84\",sumdate:\"2019-04-11\"},{symbol:\"sz300476\",inner_code:\"300476\",symbol_name:\"胜宏科技\",avg_targetprice:\"22.830\",avg_incpercent:\"65.20\",sumdate:\"2019-04-11\"},{symbol:\"sz300423\",inner_code:\"300423\",symbol_name:\"鲁亿通\",avg_targetprice:\"46.290\",avg_incpercent:\"63.28\",sumdate:\"2019-04-11\"},{symbol:\"sh600068\",inner_code:\"600068\",symbol_name:\"葛洲坝\",avg_targetprice:\"12.500\",avg_incpercent:\"61.29\",sumdate:\"2019-04-11\"},{symbol:\"sz002285\",inner_code:\"002285\",symbol_name:\"世联行\",avg_targetprice:\"9.860\",avg_incpercent:\"56.26\",sumdate:\"2019-04-11\"},{symbol:\"sh600667\",inner_code:\"600667\",symbol_name:\"太极实业\",avg_targetprice:\"11.700\",avg_incpercent:\"56.21\",sumdate:\"2019-04-11\"}]}";
		String test2 = "{\"total\":\"588\"}";

		String value = JsonUtils.getSubString(test2, "/total");
		System.out.println(value);
	}
}
