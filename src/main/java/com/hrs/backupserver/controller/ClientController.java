package com.hrs.backupserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hrs.backupserver.entity.Client;
import com.hrs.backupserver.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	ClientService clientService;
	

	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Client> getClients(){
		return clientService.getClients();
	}
	
	@RequestMapping(value="", method=RequestMethod.PUT)
	public boolean insertClient(@RequestBody(required=false) Client clientRep){
		return clientService.insertClient(clientRep);
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public boolean updateClient(@RequestBody(required=false) Client clientRep){
		return clientService.updateClient(clientRep);
	}
}
