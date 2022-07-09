package com.echo.program;

import java.rmi.RemoteException;

//import com.echo.program.Network;
//import com.echo.program.Node;
import com.echo.program.Crypto.AdminKey;
import com.echo.program.Crypto.ViewerKey;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.io.FileNotFoundException;

public class EchoCLI {
    public static void main(String[] args) throws RemoteException, NotBoundException, FileNotFoundException, IOException{
        String networkID = args[0]; //PENIS
        int PORT = Integer.valueOf(args[1]); //69
        String otherNode = args[2]; //TEST
        ViewerKey viewer = new ViewerKey(networkID.getBytes(), "123");
        AdminKey admin = new AdminKey("aaaa".getBytes(), "123");

        String networkDir = System.getProperty("user.dir") + "/data/" + networkID + "/";

        new Thread(new Network(otherNode, networkDir + otherNode, PORT, viewer, admin)).start();

        Node node = new Node("CUNT", PORT, networkDir + "CUNT", viewer, admin);
        node.requestExplorerFile(otherNode);
    }
}
