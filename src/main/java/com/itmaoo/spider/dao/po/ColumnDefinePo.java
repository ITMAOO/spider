package com.itmaoo.spider.dao.po;

import com.itmaoo.spider.enums.FetchType;

import lombok.Data;
@Data
public class ColumnDefinePo {
	private Long providerId;
	private String columnName;
	private String path;
	private FetchType fetchType;
	private Integer index;
	private String fetchRegex;
	private String code;
}
