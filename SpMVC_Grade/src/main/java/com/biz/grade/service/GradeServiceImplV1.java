package com.biz.grade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.grade.mapper.GradeDao;
import com.biz.grade.model.GradeVO;

@Service("gradeServiceV1")
public class GradeServiceImplV1 implements GradeService {

	@Autowired
	private GradeDao gradeDao;
	
	@Override
	public List<GradeVO> selectAll() {
		List<GradeVO> gradeList = gradeDao.selectAll();
		
		return gradeList;
	}

	@Override
	public GradeVO findBySeq(Long seq) {
		
		GradeVO gradeVO = gradeDao.findBySeq(seq);
		
		return gradeVO;
	}

	@Override
	public int insert(GradeVO gradeVO) {
		int ret = gradeDao.insert(gradeVO);
		return ret;
	}

	@Override
	public int update(GradeVO gradeVO) {
		int ret = gradeDao.update(gradeVO);
		return ret;
	}

	@Override
	public int delete(Long seq) {
		int ret = gradeDao.delete(seq);
		return ret;
	}

	

}
