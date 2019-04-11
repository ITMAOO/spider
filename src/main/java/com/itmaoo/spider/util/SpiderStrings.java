package com.itmaoo.spider.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpiderStrings {
	
	public static String fetchRegexMidle(String regex,String tagart) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(tagart);
		while(matcher.find()){
			return matcher.group(1);
		}
		return null;
	}
	
	public static String getValueByPath(String json,String path) {
		
		return null;
	}
	
	public static void main(String[] args) {
		String str = "var hq_json_si_api8=({total:\"584\",data:[{symbol:\"sh600359\",inner_code:\"600359\",symbol_name:\"新农开发\",avg_targetprice:\"26.400\",avg_incpercent:\"311.86\",sumdate:\"2019-04-10\"},{symbol:\"sz002310\",inner_code:\"002310\",symbol_name:\"东方园林\",avg_targetprice:\"25.400\",avg_incpercent:\"204.19\",sumdate:\"2019-04-10\"},{symbol:\"sz002458\",inner_code:\"002458\",symbol_name:\"益生股份\",avg_targetprice:\"58.000\",avg_incpercent:\"159.86\",sumdate:\"2019-04-10\"},{symbol:\"sh603111\",inner_code:\"603111\",symbol_name:\"康尼机电\",avg_targetprice:\"12.400\",avg_incpercent:\"134.85\",sumdate:\"2019-04-10\"},{symbol:\"sz300409\",inner_code:\"300409\",symbol_name:\"道氏技术\",avg_targetprice:\"40.000\",avg_incpercent:\"112.09\",sumdate:\"2019-04-10\"},{symbol:\"sz300348\",inner_code:\"300348\",symbol_name:\"长亮科技\",avg_targetprice:\"35.000\",avg_incpercent:\"104.08\",sumdate:\"2019-04-10\"},{symbol:\"sh603363\",inner_code:\"603363\",symbol_name:\"傲农生物\",avg_targetprice:\"34.130\",avg_incpercent:\"100.18\",sumdate:\"2019-04-10\"},{symbol:\"sz000976\",inner_code:\"000976\",symbol_name:\"华铁股份\",avg_targetprice:\"10.290\",avg_incpercent:\"96.75\",sumdate:\"2019-04-10\"},{symbol:\"sz000537\",inner_code:\"000537\",symbol_name:\"广宇发展\",avg_targetprice:\"16.700\",avg_incpercent:\"83.72\",sumdate:\"2019-04-10\"},{symbol:\"sz002876\",inner_code:\"002876\",symbol_name:\"三利谱\",avg_targetprice:\"75.000\",avg_incpercent:\"72.02\",sumdate:\"2019-04-10\"},{symbol:\"sh601137\",inner_code:\"601137\",symbol_name:\"博威合金\",avg_targetprice:\"15.800\",avg_incpercent:\"66.84\",sumdate:\"2019-04-10\"},{symbol:\"sz300423\",inner_code:\"300423\",symbol_name:\"鲁亿通\",avg_targetprice:\"46.290\",avg_incpercent:\"63.28\",sumdate:\"2019-04-10\"},{symbol:\"sz300476\",inner_code:\"300476\",symbol_name:\"胜宏科技\",avg_targetprice:\"22.830\",avg_incpercent:\"63.19\",sumdate:\"2019-04-10\"},{symbol:\"sh600068\",inner_code:\"600068\",symbol_name:\"葛洲坝\",avg_targetprice:\"12.500\",avg_incpercent:\"61.29\",sumdate:\"2019-04-10\"},{symbol:\"sz300227\",inner_code:\"300227\",symbol_name:\"光韵达\",avg_targetprice:\"20.000\",avg_incpercent:\"54.80\",sumdate:\"2019-04-10\"},{symbol:\"sz002285\",inner_code:\"002285\",symbol_name:\"世联行\",avg_targetprice:\"9.860\",avg_incpercent:\"54.79\",sumdate:\"2019-04-10\"},{symbol:\"sh600667\",inner_code:\"600667\",symbol_name:\"太极实业\",avg_targetprice:\"11.700\",avg_incpercent:\"53.95\",sumdate:\"2019-04-10\"}]});";
		String regex = "var hq_json_si_api8=[(](.+)[)];";
		System.out.println(SpiderStrings.fetchRegexMidle(regex, str));
	}
	
		
}
