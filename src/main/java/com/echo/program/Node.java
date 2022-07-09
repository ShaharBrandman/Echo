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
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Node {
    private String nodeID;
    private int nodePORT;
    private String nodeDirectory;

    private ViewerKey viewerKey;
    private AdminKey adminKey;

    private Registry registry;
    
    public Node(String ID, int PORT, String nodeDirectory, ViewerKey viewerKey, AdminKey adminKey) {
        this.nodeID = ID;
        this.nodePORT = PORT;
        this.nodeDirectory = nodeDirectory;
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

    //return the specified file of the targeted node
    public File requestFile(String path, String ID) throws RemoteException, NotBoundException {
        fileInterface reponse = (fileInterface) registry.lookup("/" + this.viewerKey.toString() + "/" + ID + "/" + path);

        return reponse.getFile();
    }

    //return the specified directory of the targeted node
    public File requestDirectory(String path, String ID) throws RemoteException, NotBoundException {
        fileInterface reponse = (fileInterface) registry.lookup("/" + this.viewerKey.toString() + "/" + ID + "/" + path);

        return reponse.getFile();
    }

    //request and download the explorer file of the target node
    public void requestExplorerFile(String ID) throws RemoteException, NotBoundException, FileNotFoundException, IOException{
        fileInterface reponse = (fileInterface) registry.lookup("/" + this.viewerKey.toString() + "/" + ID + "/Explorer.json");

        File nodeDir = new File(this.nodeDirectory);

        if (!nodeDir.exists()) {
            nodeDir.mkdirs();
        }

        InputStream in = new BufferedInputStream(new FileInputStream(reponse.getFile()));
        OutputStream out = new BufferedOutputStream(new FileOutputStream(new File(this.nodeDirectory + "/Explorer.json")));
 
        byte[] buffer = new byte[1024];
        int lengthRead;
        while ((lengthRead = in.read(buffer)) > 0) {
            out.write(buffer, 0, lengthRead);
            out.flush();
        }

        in.close();
        out.close();
    }

    //return the explorer file of the target node
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
