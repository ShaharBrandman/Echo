package com.echo.program;

import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.NotBoundException;

import java.util.ArrayList;

import com.echo.program.Crypto.AdminKey;
import com.echo.program.Crypto.ViewerKey;
import com.echo.program.Database.fileInterface;

import java.io.File;

public class Node {
    private String nodeID;
    private int nodePORT;
    private String nodeDirectory;

    private ViewerKey viewerKey;
    private AdminKey adminKey;

    private Registry registry;
    
    public Node(String ID, int PORT, String networkDirectory, ViewerKey viewerKey, AdminKey adminKey) {
        this.nodeID = ID;
        this.nodePORT = PORT;
        this.nodeDirectory = networkDirectory;
        new File(this.nodeDirectory).mkdir();

        this.viewerKey = viewerKey;
        this.adminKey = adminKey;

        try {
            this.registry = LocateRegistry.getRegistry("127.0.0.1", this.nodePORT);
        }
        catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public String getID() {
        return this.nodeID;
    }

    public File requestFile(String path, String ID) throws RemoteException, NotBoundException {
        fileInterface reponse = (fileInterface) registry.lookup("/" + this.viewerKey.toString() + "/" + ID + "/" + path);

        return reponse.getFile();
    }

    public File requestDirectory(String path, String ID) throws RemoteException, NotBoundException {
        fileInterface reponse = (fileInterface) registry.lookup("/" + this.viewerKey.toString() + "/" + ID + "/" + path);

        return reponse.getFile();
    }

    public File getExplorerFile(String ID) throws RemoteException, NotBoundException {
        fileInterface reponse = (fileInterface) registry.lookup("/" + this.viewerKey.toString() + "/" + ID + "/Explorer.json");

        return reponse.getFile();
    }

    /*public JSONArray getExplorer(String ID) throws RemoteException, NotBoundException {
        fileInterface reponse = (fileInterface) registry.lookup("/" + this.viewerKey.toString() + "/" + ID + "/Explorer");

        return reponse.getFile();
    }*/

    public ArrayList<String> getInvitation(String URL) {
        return null;
    }
}
