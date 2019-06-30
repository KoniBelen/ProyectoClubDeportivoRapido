package com.clubdeportivo2.clubdeportivo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class ClubDeportivoApplication {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@RequestMapping("/")
    public String welcome() {
        return "home";
    }

	public static void main(String[] args) {
		SpringApplication.run(ClubDeportivoApplication.class, args);
	}

/*	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		
		String password = "12345";
		
		for(int i=0; i<2; i++) {
			String bcryptPassword = passwordEncoder.encode(password);
			System.out.println(bcryptPassword);
		}
	}*/
}
