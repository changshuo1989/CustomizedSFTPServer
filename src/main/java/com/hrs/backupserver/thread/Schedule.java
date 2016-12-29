package com.hrs.backupserver.thread;

import com.hrs.backupserver.entity.Client;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class Schedule implements Runnable{
	
	Client client;
	
	final String destinationDirectory="";
	
	public Schedule(Client client){
		this.client=client;
	}

	public void run() {
		
		JSch jsch=null;
		Session session=null;
		Channel channel = null;
		ChannelSftp c = null;
		
		try{
			int id=client.getId();
			String host=client.getHost();
			int port=client.getPort();
			String username=client.getUsername();
			String password=client.getPassword();
			String knownHostsFile=client.getKnownHostsFile();
			String identityFile=client.getIdentityFile();
			String sourceDirectory=client.getSourceDirectory();
			int interval=client.getInterval();
			

			
			while(true){
				jsch=new JSch();
				session=jsch.getSession(username, host, port);
				session.setPassword(password);
				jsch.setKnownHosts(knownHostsFile);
				jsch.addIdentity(identityFile);
				session.connect();
				
				channel=session.openChannel("sftp");
				channel.connect();
				c= (ChannelSftp) channel;
				//String 
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(c!=null){c.disconnect();}
			if(session!=null){session.disconnect();}
		}
		
	}
	
}
