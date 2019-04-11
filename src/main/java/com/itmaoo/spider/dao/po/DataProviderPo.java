package com.itmaoo.spider.dao.po;

import com.itmaoo.spider.enums.HttpRequestType;

import lombok.Data;

@Data
public class DataProviderPo {
	private Long id;
	private String code;
	private String name;
	private String url;
	private HttpRequestType requestType;
	private String params;
	private String status;
	private String updateTime;
	private String createTime;
	private String fetchRegexMidle;
}
