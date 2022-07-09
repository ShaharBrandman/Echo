package com.echo.program;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.echo.program.Crypto.AdminKey;
import com.echo.program.Crypto.ViewerKey;
import com.echo.program.Database.FileObject;

import java.io.File;
import java.io.IOException;
import java.lang.Runnable;

public class Network implements Runnable {
    private String nodeID;

    private String networkDirectory;

    private int networkPORT;

    private ViewerKey viewerKey;
    private AdminKey adminKey;

    private Registry registry;

    public Network(String nodeID, String networkDirectory, int PORT, ViewerKey viewerKey, AdminKey adminKey) {
        this.nodeID = nodeID;
        this.networkPORT = PORT;
        this.networkDirectory = networkDirectory;
        this.viewerKey = viewerKey;
        this.adminKey = adminKey;

        //create the network directory
        new File(this.networkDirectory).mkdirs();
    }

    @Override
    public void run() {
        try {
            this.registry = LocateRegistry.createRegistry(this.networkPORT);

            registerExplorer();
            registerNodeDirectoryFiles();
            registerInvitation();
            /*new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(500);
                        update();  
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });*/
            System.out.println("Server is running");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Creating a registry for other users to get data from
     * which creates & runs the network entirley
     */
    private void update() {
        try {
            registerExplorer();
            registerNodeDirectoryFiles();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Register a single json file with the directory structure of a node
     * contains the viewer key, admin key and all of the database functionalities
     * such as the verification system for the correct database copy
     */
    private void registerExplorer() throws RemoteException, AlreadyBoundException, IOException{
        File explorer = new File(this.networkDirectory+ "/Explorer.json");
        
        if (!explorer.exists()) {
            explorer.createNewFile();
        }

        registry.bind("/" + this.viewerKey.toString() + "/" + this.nodeID + "/Explorer.json", new FileObject(explorer.getPath()));
    }


    /*
     * Register all the files in the node directory for another user to fetch
     * encrypt data with the viewerKey
     */
    private void registerNodeDirectoryFiles() throws RemoteException, AlreadyBoundException{

    }

    /*
     * Register a place for other nodes to retrieve an invitation for the shared database of the network
     */
    private void registerInvitation() throws RemoteException, AlreadyBoundException{

    }

    //register a single file to the network
    private void registerFile(String PATH) throws RemoteException, AlreadyBoundException{
        registry.bind("/" + this.viewerKey.toString() + "/" + this.nodeID, new FileObject(PATH));
    }
}