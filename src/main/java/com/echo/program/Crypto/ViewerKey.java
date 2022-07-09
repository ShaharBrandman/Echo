package com.echo.program.Crypto;

import java.util.Base64;

public class ViewerKey {
    private byte[] decryptedData;
    private Base64 encryptedData;
    private String secretKey;
    private boolean decrypted = false;

    private final int keySize = 192;
    
    public ViewerKey(byte[] decryptedData, String KEY) {
        this.decryptedData = decryptedData;
        this.secretKey = KEY;
        //this.encryptedData = write();
    }

    public ViewerKey(Base64 encryptedData, String KEY) {
        this.encryptedData = encryptedData;
        this.secretKey = KEY;
        //this.decryptedData = read();
    }

    public byte[] read() {
        return null;
    }

    public Base64 write() {
        return null;
    }

    public String toString() {
        return "VIEWERKEY";
        //return this.encryptedData.toString();
    }

    public boolean isDecrypted() {
        return this.decrypted;
    }

    public byte[] getDecryptedData() {
        return this.decryptedData;
    }

    public Base64 getEncryptedData() {
        return this.encryptedData;
    }

    public String getKey() {
        return this.secretKey;
    }

    public int getKeySize() {
        return this.keySize;
    }
}
