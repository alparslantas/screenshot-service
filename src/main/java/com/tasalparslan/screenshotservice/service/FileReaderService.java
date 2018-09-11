package com.tasalparslan.screenshotservice.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import io.webfolder.ui4j.api.browser.BrowserEngine;
import io.webfolder.ui4j.api.browser.BrowserFactory;
import io.webfolder.ui4j.api.browser.Page;

@Service
public class FileReaderService {

	public List<String> getScreenshotByUrl() {

		List<String> urlList = new ArrayList<>();
		BrowserEngine browser = BrowserFactory.getWebKit();

		InputStream is = FileReaderService.class.getResourceAsStream("/url-list.txt");
		InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
		BufferedReader reader = new BufferedReader(streamReader);
		try {
			for (String line; (line = reader.readLine()) != null;) {
				urlList.add(line);
				System.out.println(line);
				capture(browser, line);
				System.out.println("\n");
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			browser.shutdown();
		}
		return urlList;
	}

	private void capture(BrowserEngine webkit, String url) {
		String name = url.split("\\.")[1];
		Page page = webkit.navigate(url);
		page.show(true);
		try {
			Thread.sleep(500);
			page.captureScreen(new FileOutputStream(new File("screenshot-output/" + name + ".png")));
			Thread.sleep(500);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
