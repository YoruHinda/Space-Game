package com.github.yoruhinda.spacegame.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class Server extends Thread {
    private ServerSocket serverSocket;
    private int port;
    private String ipAddress;

    public Server(String ipAddress, int port){
        this.ipAddress = ipAddress;
        this.port = port;
    }

    @Override
    public void run(){
        try {
            InetAddress address = InetAddress.getByName(ipAddress);
            serverSocket = new ServerSocket(port,50, address);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
