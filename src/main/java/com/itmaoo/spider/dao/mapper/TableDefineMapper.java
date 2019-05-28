package com.itmaoo.spider.dao.mapper;

import org.apache.ibatis.annotations.Insert;

import com.itmaoo.spider.dao.po.TableDefinePo;

public interface TableDefineMapper {
	
	@Insert("insert into spider_table_define (status,user_id,name,fetch_internal_max,fetch_internal_min,code)"
			+ " values (#{status},#{userId},#{name},#{fetchInternalMax},#{fetchInternalMin},#{code})")
	public int save(TableDefinePo tableDefinePo);
	
}
