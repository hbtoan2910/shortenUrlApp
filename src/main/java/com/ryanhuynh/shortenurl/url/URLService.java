package com.ryanhuynh.shortenurl.url;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class URLService {
	
	private static final Logger logger = LoggerFactory.getLogger(URLService.class);
	private final URLRepository urlRepository;	
	
	public String generateShortUrl(String longUrl) {
		String shortUrl = "";
		try {
			String encodedLongUrl = URLEncoder.encode(longUrl, "UTF-8");
			boolean urlExists = urlRepository.findByLongUrl(encodedLongUrl).isPresent();
			
			if (urlExists) {
				URL existedUrl = urlRepository.findByLongUrl(encodedLongUrl).get();
				shortUrl = existedUrl.getShortUrl();
				logger.info("URL already existed. This is shortURL which is already in database: " + shortUrl);
			} else {
				shortUrl = "https://booking.myinfomedic.com/" + generateRandomString(6); //only get 6 characters
				
				urlRepository.save(
						new URL(encodedLongUrl,
								shortUrl,
								LocalDateTime.now()));
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return shortUrl;
	}
	
	public String generateRandomString(int length) {
		
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		int characters_length = characters.length();
		StringBuilder randomString = new StringBuilder();

		for(int i=0; i <= length; i++) {
			Random randomGen = new Random();
			int randomIndex = randomGen.nextInt(characters_length);
			randomString.append(characters.charAt(randomIndex));
		}
		return randomString.toString();
	}
}
