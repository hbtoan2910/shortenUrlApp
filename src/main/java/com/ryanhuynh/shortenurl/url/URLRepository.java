package com.ryanhuynh.shortenurl.url;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URLRepository extends JpaRepository<URL, Long>{
	Optional<URL>findByLongUrl(String longUrl);
}
