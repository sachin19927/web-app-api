package com.service.developersjourneysource.aws.storage.s3;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface AWSFileStorageService {

	String saveFile(MultipartFile file);
	
	byte[] downloadFile(String fileName);
	
	String deleteFile(String fileName);
	
	List<String> listAllFiles();
	
}
