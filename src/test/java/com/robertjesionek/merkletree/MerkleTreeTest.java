package com.robertjesionek.merkletree;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.security.Security;
import java.util.ArrayList;

/**
 * Created by Jesion on 2017-04-24.
 */
public class MerkleTreeTest {

    @BeforeClass
    public static void init ()
    {
        Security.addProvider(new BouncyCastleProvider());
    }

    @Test
    public void buildTest() throws IOException, JSONException, InterruptedException {

        MerkleTree tree = new MerkleTree(true);
        tree.addLeafs(this.getData());
        tree.build();

        byte[] merkleRoot = tree.getMerkleRoot();
        Assert.assertEquals("7ae9c08c4128fabcb6f8a50cc075f293166798ae38d3f2e12e4a085375cced0e", Hex.toHexString(merkleRoot));
    }

    private ArrayList<byte[]> getData() throws IOException, JSONException {
        ArrayList<byte[]> leafs = new ArrayList<byte[]>();
        JSONArray jsonData = new JSONResource("data.json").readObjectArray();
        for (int i = 0; i < jsonData.length (); i++) {
            String leaf = (String) jsonData.get(i);
            byte[] leafBytes = Hex.decode(leaf);
            leafs.add(leafBytes);
        }
        return leafs;
    }
}
