package com.itmaoo.spider.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itmaoo.spider.dao.mapper.ColumnDefineMapper;
import com.itmaoo.spider.dao.po.ColumnDefinePo;
@Component
public class ColumnDefineDao {
	@Autowired
	private ColumnDefineMapper columnDefineMapper;
	
	public void save(ColumnDefinePo columnDefinePo) {
		columnDefineMapper.save(columnDefinePo);
		
	}

}
