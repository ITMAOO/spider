package com.itmaoo.spider.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.itmaoo.spider.dao.po.ColumnDefinePo;
@Mapper
public interface ColumnDefineMapper {
	
	@Insert("insert into spider_column_define(provider_id,fetch_type,path,code,name,index,fetch_regex)"
			+ " values (#{providerId},#{fetch_type},#{path},#{code},#{columnName},#{index},#{fetchRegex})")
	void save(ColumnDefinePo columnDefinePo);

}
