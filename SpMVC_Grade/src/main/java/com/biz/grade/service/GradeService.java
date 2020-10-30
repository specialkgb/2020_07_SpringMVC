package com.biz.grade.service;

import java.util.List;

import com.biz.grade.model.GradeVO;

public interface GradeService {
	

	public List<GradeVO> selectAll();
	public GradeVO findBySeq(Long seq);
	public int insert(GradeVO gradeVO);
	public int update(GradeVO gradeVO);
	public int delete(Long seq);

}