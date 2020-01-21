package com.sopra.LocAway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.sopra.LocAway.config.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class LocAwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocAwayApplication.class, args);
	}

}
