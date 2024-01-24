package com.ryanhuynh.shortenurl.url;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class URLController {
	
	private final URLService urlService;
	
	@PostMapping("/shortenurl")
	public String shortenUrl(@RequestParam("url") String longUrl) {
		return urlService.generateShortUrl(longUrl);
	}
}
