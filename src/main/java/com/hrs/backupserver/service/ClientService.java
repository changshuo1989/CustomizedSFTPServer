package com.hrs.backupserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hrs.backupserver.entity.Client;

public class ClientService {
	@Autowired
	List<Client> clients;
	
	
	public List<Client> getClients(){
		return clients;
	}
	
	public boolean insertClient(Client client){
		boolean res=true;
		try{
			if(client.getId()!=null){
				throw new Exception("new client shouldn't have an ID");
			}
			int size=clients.size();
			client.setId(size+1);
			clients.add(client);
		}
		catch(Exception e){
			//e.printStackTrace();
			res=false;
		}
		return res;
	}
	
	public boolean updateClient(Client client){
		boolean res=true;
		boolean found=false;
		try{
			if(client.getId()==null){
				throw new Exception("client should have an ID");
			}
			
			for(int i=0; i<clients.size(); i++){
				if(client.getId()==clients.get(i).getId()){
					clients.get(i).setHost(client.getHost());
					clients.get(i).setIdentityFile(client.getIdentityFile());
					clients.get(i).setKnownHostsFile(client.getKnownHostsFile());
					clients.get(i).setPassword(client.getPassword());
					clients.get(i).setPort(client.getPort());
					clients.get(i).setUsername(client.getUsername());
					found=true;
					break;
				}
			}
			if(!found){
				res=false;
			}
		}
		catch(Exception e){
			res=false;
		}
		return res;
	}
	

}
