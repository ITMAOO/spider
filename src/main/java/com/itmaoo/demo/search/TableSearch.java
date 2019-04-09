package com.itmaoo.demo.search;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import lombok.Data;

@Data
public class TableSearch extends Pageable{
	private String tableCode;
	private String tableName;
}
