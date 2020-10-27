package com.biz.ems.sql;

import org.apache.ibatis.jdbc.SQL;

public class ImageSQL {
	
	public String insert( ) {
		
		SQL sql  = new SQL();
		sql.INSERT_INTO("tbl_eimages");
		sql.INTO_COLUMNS("i_seq").INTO_VALUES("SEQ_EIMAGES.NEXTVAL");
		sql.INTO_COLUMNS("i_eseq").INTO_VALUES("#{id}");
		sql.INTO_COLUMNS("i_org_name").INTO_VALUES("#{vo.i_org_name}");
		sql.INTO_COLUMNS("i_file_name").INTO_VALUES("#{vo.i_file_name}");
		
		return sql.toString();
	}

}
