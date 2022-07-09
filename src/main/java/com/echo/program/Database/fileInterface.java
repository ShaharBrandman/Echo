package com.echo.program.Database;

import java.rmi.Remote;
import java.rmi.RemoteException;

import java.io.File;

public interface fileInterface extends Remote {
    public String getPath() throws RemoteException;
    public File getFile() throws RemoteException;
}