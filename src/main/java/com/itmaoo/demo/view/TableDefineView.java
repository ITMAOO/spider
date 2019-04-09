package com.itmaoo.demo.view;

import java.util.List;

import com.itmaoo.demo.view.table.TableColumnView;

import lombok.Data;

@Data
public class TableDefineView {
	private String tableName;
	private String tableCode;
	
	private List<TableColumnView> rowDefine;
	private String params;
	private Boolean checked;
	//抓取数据的最大间隔时间
	private Long fetchInternalMax;
	//抓取数据的最小间隔时间
	private Long fetchInternalMin;
	
}
