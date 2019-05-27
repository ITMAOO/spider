package com.itmaoo.spider.search;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;


public class TableSearch extends Pageable{
	private String tableCode;
	private String tableName;

	public String getTableCode() {
		return tableCode;
	}

	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
