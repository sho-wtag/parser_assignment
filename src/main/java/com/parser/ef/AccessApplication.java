package com.parser.ef;

import com.parser.ef.service.ProcessorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AccessApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(AccessApplication.class, args);
		ProcessorService service = applicationContext.getBean(ProcessorService.class);
		service.processFile();
		service.queryDb();
	}

}
