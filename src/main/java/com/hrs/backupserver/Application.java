package com.hrs.backupserver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hrs.backupserver.entity.Client;

@SpringBootApplication
public class Application implements CommandLineRunner{
	

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}

	public void run(String... arg0) throws Exception {

		
	}

}
