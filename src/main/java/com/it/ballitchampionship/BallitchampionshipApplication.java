package com.it.ballitchampionship;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@AllArgsConstructor
@SpringBootApplication
public class BallitchampionshipApplication {

	public static void main(String[] args) {SpringApplication.run(BallitchampionshipApplication.class, args);}

}
