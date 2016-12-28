package com.hrs.backupserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hrs.backupserver.service.ClientService;

@Configuration
public class ServiceConfig {
	
	@Bean(name="clientService")
	public ClientService clientService(){
		return new ClientService();
	}
}
