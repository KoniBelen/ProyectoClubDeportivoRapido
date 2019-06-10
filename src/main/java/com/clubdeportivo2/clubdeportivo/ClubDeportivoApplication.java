package com.clubdeportivo2.clubdeportivo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class ClubDeportivoApplication {

	@RequestMapping("/")
    public String welcome() {
        return "home";
    }
	public static void main(String[] args) {
		SpringApplication.run(ClubDeportivoApplication.class, args);
	}

}
