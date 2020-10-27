package com.biz.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.ems.mapper.EmsDao;
import com.biz.ems.mapper.ImageDao;
import com.biz.ems.model.EmsVO;
import com.biz.ems.model.ImageVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("emsServiceV1")
public class EmsServiceImplV1 implements EmsService{
	
	@Autowired
	protected EmsDao emsDao;
	
	@Autowired
	protected ImageDao imageDao;
	
	@Autowired
	@Qualifier("fileServiceV1")
	private FileService fileService;
	
	@Override
	public List<EmsVO> selectAll() {
		
		return emsDao.selectAll();
	}

	@Override
	public void insert(EmsVO emsVO, MultipartFile file) {
		
		String fileName = fileService.fileUp(file);
		emsVO.setS_file1(fileName);
		
		emsDao.insert(emsVO);
		
	}

	@Override
	public List<String> insert(EmsVO emsVO, MultipartHttpServletRequest files) {
		
		List<MultipartFile> fileList = files.getFiles("files");
		for(MultipartFile f : fileList) {
			log.debug("업로드된 파일 {}", f.getOriginalFilename());
		}
		
		List<ImageVO> fileNames = fileService.filesUp(files);
		
		emsDao.insert(emsVO);
		long id = emsVO.getId();
		log.debug("EMS ID {}", id);
		
		for(ImageVO vo : fileNames) {
			imageDao.insert(vo, id);
		}
		return null;
	}
		
	

	@Override
	public EmsVO findById(long long_id) {
		EmsVO emsVO = emsDao.findById(long_id);
		List<ImageVO> images = imageDao.findBySeq(long_id);
		
		emsVO.setImages(images);
		
		return emsVO;
	}

	@Override
	public int delete(long long_id) {
		
		EmsVO emsVO = emsDao.findById(long_id);
		
		String s_file1 = emsVO.getS_file1();
		String s_file2 = emsVO.getS_file2();
		
		if(s_file1 != null ) {
			fileService.fileDelete1(s_file1);
		}		
		return emsDao.delete(long_id);
	}

	@Override
	public void insert(EmsVO emsVO) {
		// TODO Auto-generated method stub
		
	}

}
