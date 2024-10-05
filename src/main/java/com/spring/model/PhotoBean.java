package com.spring.model;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PhotoBean {
	
	private int id;
	private MultipartFile photo;
	private byte[] photoByte;
	
	public String getPhotoBase64() throws IOException{
		if(this.photoByte != null && this.photoByte.length > 0) {
			return Base64.getEncoder().encodeToString(this.photoByte);
		}
		
		return null;
	}

}
