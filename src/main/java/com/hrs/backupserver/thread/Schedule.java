package com.hrs.backupserver.thread;

import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.hrs.backupserver.entity.Client;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class Schedule implements Runnable{
	
	public Client client;
	public int id;
	private volatile boolean stop;
	
	
	public Schedule(Client client, HashMap<Integer, Schedule> map){
		this.stop=false;
		this.client=client;
		
		for(Integer key : map.keySet()){
			if(key.equals(client.getId())){
				map.get(key).stop();
				map.remove(key);
				break;
			}
		}
		map.put(client.getId(), this);
	}

	public void run() {
	
		try{
			int cid=client.getId();
			String host=client.getHost();
			int port=client.getPort();
			String username=client.getUsername();
			String password=client.getPassword();
			String srcPath=client.getSrcpath();
			String destPath=client.getDestpath();
			int interval=client.getInterval();
			
			while(!stop){
				JSch jsch=null;
				Session session=null;
				Channel channel = null;
				ChannelSftp channelSftp = null;	
				try{
					this.id=cid;
					jsch=new JSch();
					session=jsch.getSession(username, host, port);
					session.setPassword(password);
					Properties config = new Properties();
					config.put("StrictHostKeyChecking", "no");
					session.setConfig(config);
					session.connect();
					
					channel=session.openChannel("sftp");
					channel.connect();
					channelSftp = (ChannelSftp) channel;
					channelSftp.get(srcPath, destPath);
					
					//sleep 
					Thread.sleep(TimeUnit.MINUTES.toMillis(interval));
				}
				catch(Exception e){
					e.printStackTrace();
				}
				finally{
					channelSftp.quit();  
		            channel.disconnect();  
		            session.disconnect();  
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void stop(){
		this.stop=true;
		//Thread.interrupted();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
