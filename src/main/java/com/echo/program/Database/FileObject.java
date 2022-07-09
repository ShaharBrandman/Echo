package com.echo.program.Database;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.echo.program.Database.fileInterface;

import java.io.File;

public class FileObject extends UnicastRemoteObject implements fileInterface {
    private String PATH = null;

    protected FileObject() throws RemoteException {
        super();
    }

    public FileObject(String PATH) throws RemoteException{
        this.PATH = PATH;
    }

    public String getPath() {
        return this.PATH;
    }

    public File getFile() {
        return new File(PATH);
    }
}
