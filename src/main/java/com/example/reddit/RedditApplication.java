package com.example.reddit;

import com.example.reddit.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.*;


@SpringBootApplication
//@ComponentScan("com.example.reddit.controller")
@EnableAsync
@Import(SwaggerConfiguration.class)
public class RedditApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedditApplication.class, args);
	}

}
