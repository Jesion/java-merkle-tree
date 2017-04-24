package com.robertjesionek.merkletree;

import org.bouncycastle.util.encoders.Hex;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Jesion on 2017-04-24.
 */
public class MerkleTreeTest {

    @Test
    public void buildTest() throws IOException, JSONException {
        ArrayList<byte[]> leafs = new ArrayList<byte[]>();
        JSONArray data = new TestResource("data.json").readObjectArray();
        for (int i = 0; i < data.length (); i++) {
            String leaf = (String) data.get(i);
            byte[] leafBytes = Hex.decode(leaf);
            leafs.add(leafBytes);
            System.out.println("Decoded leaf at index " + i + " bytes: " + leafBytes.length);
        }
        MerkleTree tree = new MerkleTree(true);
        tree.addLeafs(leafs);





        Assert.assertTrue(true);
    }
}
