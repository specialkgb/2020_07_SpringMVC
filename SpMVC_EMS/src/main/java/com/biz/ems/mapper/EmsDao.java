package com.biz.ems.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.ems.model.EmsVO;
import com.biz.ems.sql.EmsSQL;

public interface EmsDao {
	
	@Select("select * from tbl_ems order by id desc")
	public List<EmsVO> selectAll();
	
	@Select("select * from tbl_ems where id = #{id}")
	public EmsVO findById(long id);
	
	@InsertProvider(type=EmsSQL.class, method="ems_insert")
	@SelectKey(keyProperty = "id", statement = " select seq_ems.nextval from dual ", resultType = Long.class, before = true )	
	public int insert(EmsVO emsVO);
	
	@UpdateProvider(type = EmsSQL.class, method="ems_update")
	public int update(EmsSQL emsVO);
	
	@Delete("DELETE FROM tbl_ems WHERE id = #{id}")
	public int delete(long id);

}
