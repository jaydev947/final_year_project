package com.jay.server;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;

import javax.xml.ws.Endpoint;

import com.sun.jersey.api.container.httpserver.*;
import com.sun.net.httpserver.HttpServer;

public class Main {

/**
* @param args
*/
    
public static void main(String[] args) {
	String url = "http://localhost:8023/service";
	try {
		HttpServer server = HttpServerFactory.create(url);
		server.setExecutor(arg0);
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	System.out.println("Running...");
        

}
}