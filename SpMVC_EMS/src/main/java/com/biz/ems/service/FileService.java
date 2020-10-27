package com.biz.ems.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.ems.model.ImageVO;

public interface FileService {
	
	public String fileUp(MultipartFile file);
	public List<ImageVO> filesUp(MultipartHttpServletRequest files);
	
	public boolean fileDelete1(String s_file1);
	public boolean fileDelete2(String s_file2);

	

}
