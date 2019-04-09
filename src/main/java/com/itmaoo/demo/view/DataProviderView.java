package com.itmaoo.demo.view;

import com.itmaoo.demo.enums.HttpRequestType;

import lombok.Data;

@Data
public class DataProviderView {
	private String url;
	private HttpRequestType requestType;
	private String params;
	private Boolean checked;
	
}
