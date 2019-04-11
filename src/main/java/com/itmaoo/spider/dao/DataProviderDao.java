package com.itmaoo.spider.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itmaoo.spider.dao.mapper.DataProviderMapper;
import com.itmaoo.spider.dao.po.DataProviderPo;

@Service
public class DataProviderDao {
	@Autowired
	private DataProviderMapper dataProviderMapper;
	public void save(DataProviderPo po) {
		dataProviderMapper.save(po);
	}
	
	public DataProviderPo findById(Long providerId) {
		return dataProviderMapper.findById(providerId);
	}
}
