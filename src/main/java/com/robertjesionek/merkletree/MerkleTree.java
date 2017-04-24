package com.robertjesionek.merkletree;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * Created by Jesion on 2017-04-24.
 */
public class MerkleTree {

    private boolean _hashLeafs = true;

    private ArrayList<byte[]> _leafs = new ArrayList<byte[]>();

    private ArrayList<Integer> _levels = new ArrayList<Integer>();

    public MerkleTree(boolean hashLeafs) {
        this._hashLeafs = hashLeafs;
    }

    public void reset() {
        this._leafs.clear();
    }

    public void addLeaf(byte[] data) {
        if (this._hashLeafs == true) {
            data = this.sha256(data);
        }
        this._leafs.add(data);
    }

    public void addLeafs(ArrayList<byte[]> leafs) {
        for (int i = 0; i < leafs.size(); i++) {
           this.addLeaf(leafs.get(i));
        }
    }

    public byte[] sha256(byte[] data) {
        byte[] out = new byte[0];
        try {
            out = MessageDigest.getInstance("SHA256").digest(data);
        } catch (NoSuchAlgorithmException e) {

        }
        return out;
    }

    public void build() {
        if (this._leafs.size() > 0) {

        }
    }
}
