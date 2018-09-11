package com.tasalparslan.screenshotservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasalparslan.screenshotservice.service.FileReaderService;

@RestController
public class ScreenshotController {

	@Autowired
	FileReaderService fileReaderService;

	@GetMapping(path = "screenshot")
	public ResponseEntity<List<String>> getScreenshots() {
		
		List<String> urlList = fileReaderService.getScreenshotByUrl();

		return ResponseEntity.ok(urlList);
	}
}
