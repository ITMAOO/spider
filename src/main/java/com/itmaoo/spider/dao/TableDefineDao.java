package com.itmaoo.spider.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itmaoo.spider.dao.mapper.TableDefineMapper;
import com.itmaoo.spider.dao.po.TableDefinePo;
@Component
public class TableDefineDao {
	@Autowired
	private TableDefineMapper tableDefineMapper;
	
	public void saveTable(TableDefinePo tableDefinePo) {
		tableDefineMapper.save(tableDefinePo);
		
	}
}
