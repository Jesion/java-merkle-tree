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

    private ArrayList<ArrayList<byte[]>> _levels = new ArrayList<ArrayList<byte[]>>();

    public MerkleTree(boolean hashLeafs) {
        this._hashLeafs = hashLeafs;
    }

    public void reset() {
        this._leafs.clear();
        this._levels.clear();
    }

    public byte[] getMerkleRoot() {
        if (this._levels.size() == 0) {
            return null;
        }
        return this._levels.get(0).get(0);
    }

    public void addLeaf(byte[] data) {
        if (this._hashLeafs == true) {
            data = this.hash(data);
        }
        this._leafs.add(data);
    }

    public void addLeafs(ArrayList<byte[]> leafs) {
        for (int i = 0; i < leafs.size(); i++) {
           this.addLeaf(leafs.get(i));
        }
    }

    public byte[] hash(byte[] data) {
        byte[] out = new byte[0];
        try {
            out = MessageDigest.getInstance("SHA256").digest(data);
        } catch (NoSuchAlgorithmException e) {

        }
        return out;
    }

    public void build() {
        if (this._leafs.size() > 0) {
            this._levels.add(0, this._leafs);
            while (this._levels.get(0).size() > 1) {
                this._levels.add(0, this.calculateLevel());
            }
        }
    }

    private ArrayList<byte[]> calculateLevel() {
        ArrayList<byte[]> nodes = new ArrayList<byte[]>();
        ArrayList<byte[]> level = this._levels.get(0);
        int count = level.size();
        for (int i = 0; i < count; i += 2) {
            if (i + 1 <= count - 1) {
                nodes.add(this.hash(this.join(level.get(i), level.get(i + 1))));
            } else {
                nodes.add(level.get(i));
            }
        }
        return nodes;
    }

    private byte[] join(byte[] leftBytes, byte[] rightBytes) {
        byte[] out = new byte[leftBytes.length + rightBytes.length];
        System.arraycopy(leftBytes, 0, out, 0, leftBytes.length);
        System.arraycopy(rightBytes, 0, out, leftBytes.length, rightBytes.length);
        return out;
    }
}
