package com.biz.ems.mapper;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.biz.ems.model.ImageVO;
import com.biz.ems.sql.ImageSQL;

public interface ImageDao {
	
	@Select("select * from tbl_images where i_bseq = #{i_eseq}")
	public List<ImageVO> findBySeq(long i_eseq);
	
	@InsertProvider(type = ImageSQL.class, method="insert")
	public int insert(@Param("vo") ImageVO imageVO, @Param("id") long id);
	
	public int insert_list(List<ImageVO> images, long id);

}
