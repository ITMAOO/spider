package com.itmaoo.spider.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.itmaoo.spider.dao.po.DataProviderPo;
@Mapper
public interface DataProviderMapper {

	@Insert("insert into spider_data_provider (code,name,request_type,params,status,url,fetch_regex_midle) "
			+ "values (#{code},#{name},#{requestType},#{params},#{status},#{url},#{fetchRegexMidle})")
	public void save(DataProviderPo po);
	
	@Select("select * from spider_data_provider where id = #{id}")
	public DataProviderPo findById(@Param("id") Long id);

}
