package com.biz.ems.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.ems.model.ImageVO;

@Service("fileServiceV1")
public class FileServiceImplV1 implements FileService {
	
	protected final String rootFolder;
	
	public FileServiceImplV1() {
		rootFolder = "C:/bizwork/workspace/upload/ems";
	}

	@Override
	public String fileUp(MultipartFile file) {
		if(file == null) {
			return null;
		}
		
		File dir = new File(rootFolder);
		
		if(!dir.exists()) {

			dir.mkdirs();
		}

		String originalFileName = file.getOriginalFilename();
		
		String strUUID = UUID.randomUUID().toString();
		String saveFileName = strUUID + originalFileName;
		
		File saveFile = new File(rootFolder, saveFileName);
		
		try {
			file.transferTo(saveFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return saveFileName;
	}
	
	@Override
	public boolean fileDelete1(String s_file1) {
		
		boolean ret = false;
		
		File deleteFile = new File(rootFolder, s_file1);
		if(deleteFile.exists()) {
			
			// 파일을 삭제하면 true return
			ret = deleteFile.delete();
		}
		return ret;
	}

	@Override
	public List<ImageVO> filesUp(MultipartHttpServletRequest files) {
		List<MultipartFile> fileList = files.getFiles("files");
		List<ImageVO> fileNames =new ArrayList<ImageVO>();
		
		for(MultipartFile f : fileList) {
			if(!f.getOriginalFilename().isEmpty()) {
				String fileName = this.fileUp(f);
				ImageVO imageVO = ImageVO.builder()
						.i_org_name(f.getOriginalFilename())
						.i_file_name(fileName)
						.build();
			}
		}
		return fileNames;
	}



	

}
