package com.itmaoo.spider.view.table;

import com.itmaoo.spider.enums.FetchType;

import lombok.Data;

@Data
public class TableColumnView {
	private Long providerId;
	private String columnName;
	private String path;
	private FetchType fetchType;
	private Integer index;
	private String fetchRegex;
	
	
}
