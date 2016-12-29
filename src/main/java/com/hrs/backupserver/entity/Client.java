package com.hrs.backupserver.entity;

public class Client {
	private Integer id;
	private String host;
	private Integer port;
	private String username;
	private String password;
	private String srcpath;
	private String destpath;
	private Integer interval;
	
	public Client() {
		// TODO Auto-generated constructor stub
	}
	
	public Client(String host, int port, String username, String password, String srcpath, String destpath, int interval) {
		super();
		this.host = host;
		this.port = port;
		this.username = username;
		this.password = password;
		this.srcpath=srcpath;
		this.destpath=destpath;
		this.interval=interval;
	}
	
	public Client(String host, String username, String password, String srcpath, String destpath, int interval) {
		super();
		this.host = host;
		this.port = 22;
		this.username = username;
		this.password = password;
		this.srcpath=srcpath;
		this.destpath=destpath;
		this.interval=interval;
	}
	public Client(int id, String host, int port, String username, String password, String srcpath, String destpath, int interval) {
		super();
		this.id = id;
		this.host = host;
		this.port = port;
		this.username = username;
		this.password = password;
		this.srcpath=srcpath;
		this.destpath=destpath;
		this.interval=interval;
	}
	
	public Client(int id, String host, String username, String password, String srcpath, String destpath, int interval) {
		super();
		this.id = id;
		this.host = host;
		this.port = 22;
		this.username = username;
		this.password = password;
		this.srcpath=srcpath;
		this.destpath=destpath;
		this.interval=interval;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSrcpath() {
		return srcpath;
	}

	public void setSrcpath(String srcpath) {
		this.srcpath = srcpath;
	}

	public String getDestpath() {
		return destpath;
	}

	public void setDestpath(String destpath) {
		this.destpath = destpath;
	}

	public Integer getInterval() {
		return interval;
	}

	public void setInterval(Integer interval) {
		this.interval = interval;
	}
}
