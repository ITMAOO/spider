package com.itmaoo.spider.view;

import com.itmaoo.spider.enums.HttpRequestType;

import lombok.Data;

@Data
public class DataProviderView {
	private String url;
	private HttpRequestType requestType;
	private String params;
	private Boolean checked;
	private String code;
	private String name;
	private String fetchRegexMidle;
	
}
