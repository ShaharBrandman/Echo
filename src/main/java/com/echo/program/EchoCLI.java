package com.echo.program;

import java.rmi.RemoteException;

//import com.echo.program.Network;
//import com.echo.program.Node;
import com.echo.program.Crypto.AdminKey;
import com.echo.program.Crypto.ViewerKey;

import java.rmi.NotBoundException;

public class EchoCLI {
    public static void main(String[] args) throws RemoteException, NotBoundException{
        String networkID = args[0]; //PENIS
        int PORT = Integer.valueOf(args[1]); //69
        String nodeID = args[2]; //TEST
        ViewerKey viewer = new ViewerKey(networkID.getBytes(), "123");
        AdminKey admin = new AdminKey("aaaa".getBytes(), "123");

        String nodeDir = System.getProperty("user.dir") + "/data/" + networkID + "/" + nodeID;

        new Thread(new Network(nodeID, nodeDir, PORT, viewer, admin)).start();
        Node node = new Node(nodeID, PORT, nodeDir, viewer, admin);
        System.out.println(node.getExplorerFile(nodeID).getAbsolutePath());
    }
}
