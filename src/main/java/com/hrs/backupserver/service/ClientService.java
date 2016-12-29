package com.hrs.backupserver.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;

import com.hrs.backupserver.entity.Client;
import com.hrs.backupserver.thread.Schedule;

public class ClientService {
	
	List<Client> clients;
	ExecutorService executor;
	
	HashMap<Integer, Schedule> scheduleMap;
	
	public ClientService(){
		executor=Executors.newCachedThreadPool();
		clients=new ArrayList<Client>();
		scheduleMap=new HashMap<Integer, Schedule>();
	}
	
	
	public synchronized List<Client> getClients(){
		return clients;
	}
	
	public synchronized boolean insertClient(Client client){
		boolean res=true;
		try{
			if(client.getId()!=null){
				throw new Exception("new client shouldn't have an ID");
			}
			int size=clients.size();
			client.setId(size+1);
			clients.add(client);
			
			Schedule s=new Schedule(client, scheduleMap);
			//System.out.println("map size: "+scheduleMap.size());
			executor.execute(s);

		}
		catch(Exception e){
			e.printStackTrace();
			res=false;
		}
		return res;
	}
	
	public synchronized boolean updateClient(Client client){
		boolean res=true;
		boolean found=false;
		try{
			if(client.getId()==null){
				throw new Exception("client should have an ID");
			}
			
			for(int i=0; i<clients.size(); i++){
				if(client.getId()==clients.get(i).getId()){
					clients.get(i).setHost(client.getHost());
					clients.get(i).setSrcpath(client.getSrcpath());
					clients.get(i).setDestpath(client.getDestpath());
					clients.get(i).setPassword(client.getPassword());
					clients.get(i).setPort(client.getPort());
					clients.get(i).setUsername(client.getUsername());
					
					Schedule s=new Schedule(clients.get(i), scheduleMap);
					executor.execute(s);					
					
					found=true;
					break;
				}
			}
			if(!found){
				res=false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			res=false;
		}
		return res;
	}
	
	
	public synchronized boolean deleteClient(String id){
		boolean res=true;
		try{
			//get client id and schedule id
			int clientId=Integer.parseInt(id);
			
			//remove from client list
			for(int i=0; i<clients.size(); i++){
				if(clients.get(i).getId() == clientId){
					clients.remove(i);
					break;
				}
			}
			//remove from schedule map
			for(Integer key : scheduleMap.keySet()){
				if(key.equals(clientId)){
					scheduleMap.get(key).stop();
					scheduleMap.remove(clientId);
					break;
				}	
			}
		}
		catch(Exception e){
			res=false;
			e.printStackTrace();
		}
		return res;
	}
	

}
