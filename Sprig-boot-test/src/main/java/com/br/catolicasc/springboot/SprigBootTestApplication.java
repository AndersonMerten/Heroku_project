package com.br.catolicasc.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SprigBootTestApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SprigBootTestApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SprigBootTestApplication.class, args);
    }

}



/*@SpringBootApplication
public class SprigBootTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprigBootTestApplication.class, args);
	}
}*/
