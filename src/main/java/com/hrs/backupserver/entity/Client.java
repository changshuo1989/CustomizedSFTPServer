package com.hrs.backupserver.entity;

public class Client {
	private Integer id;
	private String host;
	private int port;
	private String username;
	private String password;
	private String knownHostsFile;
	private String identityFile;
	
	public Client() {
		// TODO Auto-generated constructor stub
	}
	
	public Client(String host, int port, String username, String password, String knownHostsFile, String identityFile) {
		super();
		this.host = host;
		this.port = port;
		this.username = username;
		this.password = password;
		this.knownHostsFile = knownHostsFile;
		this.identityFile = identityFile;
	}
	
	public Client(String host, String username, String password, String knownHostsFile, String identityFile) {
		super();
		this.host = host;
		this.port = 22;
		this.username = username;
		this.password = password;
		this.knownHostsFile = knownHostsFile;
		this.identityFile = identityFile;
	}
	public Client(int id, String host, int port, String username, String password, String knownHostsFile, String identityFile) {
		super();
		this.id = id;
		this.host = host;
		this.port = port;
		this.username = username;
		this.password = password;
		this.knownHostsFile = knownHostsFile;
		this.identityFile = identityFile;
	}
	
	public Client(int id, String host, String username, String password, String knownHostsFile, String identityFile) {
		super();
		this.id = id;
		this.host = host;
		this.port = 22;
		this.username = username;
		this.password = password;
		this.knownHostsFile = knownHostsFile;
		this.identityFile = identityFile;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
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

	public String getKnownHostsFile() {
		return knownHostsFile;
	}

	public void setKnownHostsFile(String knownHostsFile) {
		this.knownHostsFile = knownHostsFile;
	}

	public String getIdentityFile() {
		return identityFile;
	}

	public void setIdentityFile(String identityFile) {
		this.identityFile = identityFile;
	}
}
