package com.biz.ems.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.ems.model.EmsVO;

public interface EmsService {
	
	public List<EmsVO> selectAll();
	
	public void insert(EmsVO emsVO);
	public void insert(EmsVO emsVO, MultipartFile file);
	
	public List<String> insert(EmsVO emsVO, MultipartHttpServletRequest files);
	
	public EmsVO findById(long long_id);
	
	public int delete(long long_id);

}
