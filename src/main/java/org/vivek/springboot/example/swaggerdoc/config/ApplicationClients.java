package org.vivek.springboot.example.swaggerdoc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties("application")
public class ApplicationClients {
	 private  List<ApplicationClient> clients = new ArrayList<>();

	public List<ApplicationClient> getClients() {
		return clients;
	}
	public void setClients(List<ApplicationClient> clients){
		this.clients = clients;
	}
}
