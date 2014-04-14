package com.frogorf.web.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.frogorf.files.domain.Image;
import com.frogorf.files.service.ImageService;

/** Handles requests for the application home page. */
@Controller
public class ImageController {

	private static final Logger logger = LoggerFactory.getLogger(ImageController.class);

	@Autowired
	private ImageService imageService;

	@RequestMapping(value = "/secure/imageupload.html", method = RequestMethod.POST)
	@ResponseBody
	public String imageUpload(@RequestParam("imageFile") MultipartFile file) throws IOException {
		if (!file.isEmpty()) {
			Image image = imageService.createImage(file.getOriginalFilename(), file.getContentType(), file.getBytes());
			if (image != null)
				return image.getId().toString();
		}
		return "null";
	}
}
