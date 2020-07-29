package com.biz.hello.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.hello.model.StudentVO;

@Service
public class StudentServiceImpl implements StudentService {

	@Override
	public List<StudentVO> selectAll() {
		return null;
	}

	@Override
	public StudentVO findByStnum(String st_num) {
		
		StudentVO stVO = new StudentVO();
		
		stVO.setSt_num(st_num);
		stVO.setSt_name("기건우");
		stVO.setSt_tel("010-4939-0080");
		stVO.setSt_addr("광주 광역시");
		stVO.setSt_grade(35);
		
		return stVO;
	}

	@Override
	public int insert(StudentVO studentVO) {
		return 0;
	}

	@Override
	public int update(StudentVO studentVO) {
		return 0;
	}

	@Override
	public int delete(String st_num) {
		return 0;
	}
}