package com.itmaoo.spider.dao.po;

import java.util.List;

import com.itmaoo.spider.view.table.TableColumnView;

import lombok.Data;
@Data
public class TableDefinePo {
	private String tableName;
	private String tableCode;
	
	private List<TableColumnView> rowDefine;
	private String params;
	/**
	 * 已验证的链接未验证的链接
	 */
	private Boolean checked;
	//抓取数据的最大间隔时间
	private Long fetchInternalMax;
	//抓取数据的最小间隔时间
	private Long fetchInternalMin;
}
