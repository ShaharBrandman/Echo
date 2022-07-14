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
    private static Node[] nodes;
    private static Network[] networks
    private static String[] networkPaths

    public static void main(String[] args) throws RemoteException, NotBoundException, FileNotFoundException, IOException{
        /*String networkID = args[0]; //PENIS
        int PORT = Integer.valueOf(args[1]); //69
        String otherNode = args[2]; //TEST
        ViewerKey viewer = new ViewerKey(networkID.getBytes(), "123");
        AdminKey admin = new AdminKey("aaaa".getBytes(), "123");

        String networkPath = System.getProperty("user.dir") + "/data/" + networkID + "/";

        new Thread(new Network(otherNode, networkPath + otherNode, PORT, viewer, admin)).start();

        Node node = new Node("CUNT", PORT, networkDir + "CUNT", viewer, admin);
        node.requestExplorerFile(otherNode);*/
    }

    public static void addNewNode(String ID, String PORT) {
        
    }

    public static void editNode(String ID, Node node) {

    }

    public static void addNewNetwork(String ID, String PORT) {

    }

    public static void editNetwork(String ID, String PORT) {
        
    }

    public static void generateInvintation(String ID) {

    }


    public static void changeAdminKey(String ID, AdminKey adminKey) {

    }

    public static void changeViewerKey(String ID, ViewerKey viewerKey) {

    }

    public static void changeNetworkPath(String ID, String newPath) {
 
    }

    public static void changeNodePort(String ID, String newPORT) {

    }

    public static void changeNetworkPort(String ID, String newPORT) {

    }

    public static void initNode(String ID) {

    }

    public static void initNetwork(String ID) {

    }

    public static void getNodes() {

    }

    public static void getNetworks() {

    }

    public static void help() {

    }

    public static void scopeIntoNode(String ID) {

    }

    public static void scopeIntoNetwork(String ID) {

    }
} 
