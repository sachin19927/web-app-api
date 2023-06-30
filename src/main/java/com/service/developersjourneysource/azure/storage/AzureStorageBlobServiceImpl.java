package com.service.developersjourneysource.azure.storage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.azure.core.http.rest.PagedIterable;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.models.BlobItem;

@Service
public class AzureStorageBlobServiceImpl implements AzureStorageBlobService {

	   @Autowired
	   BlobServiceClient blobServiceClient;

	   @Autowired
	   BlobContainerClient blobContainerClient;
	
	@Override
	public String upload(MultipartFile multipartFile) throws IOException {
		BlobClient blob = blobContainerClient
	            .getBlobClient(multipartFile.getOriginalFilename());
	      blob.upload(multipartFile.getInputStream(),
	            multipartFile.getSize(), true);
	        
	      return multipartFile.getOriginalFilename();
	}

	@Override
	public byte[] getFile(String fileName) {
		BlobClient blob = blobContainerClient.getBlobClient(fileName);
	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    blob.download(outputStream);
	    final byte[] bytes = outputStream.toByteArray();
	    return bytes;
	}

	@Override
	public List<String> listBlobs() {
		PagedIterable<BlobItem> items = blobContainerClient.listBlobs();
		List<String> names = new ArrayList<String>();
	      for (BlobItem item : items) {
	         names.add(item.getName());
	      }
	      return names;
	}

	@Override
	public Boolean deleteBlob(String blobName) {
		BlobClient blob = blobContainerClient.getBlobClient(blobName);
	    blob.delete();
	    return true;
	}

}
