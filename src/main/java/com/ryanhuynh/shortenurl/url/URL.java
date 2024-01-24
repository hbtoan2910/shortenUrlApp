package com.ryanhuynh.shortenurl.url;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class URL {
	@Id
	@GeneratedValue(
			strategy = GenerationType.IDENTITY)
	private Long id;
	private String longUrl;
	private String shortUrl;
	private LocalDateTime createdAt;
	
	public URL(String longUrl, String shortUrl, LocalDateTime createdAt) {
		this.longUrl = longUrl;
		this.shortUrl = shortUrl;
		this.createdAt = createdAt;
	}
}
