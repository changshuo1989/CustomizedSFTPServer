package com.hrs.backupserver.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hrs.backupserver.entity.Client;

@Configuration
public class EntityConfig {
	
	@Bean(name="clients")
	public List<Client> clients(){
		return new ArrayList<Client>();
	}
}
