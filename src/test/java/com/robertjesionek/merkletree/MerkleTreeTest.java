package com.robertjesionek.merkletree;

import org.bouncycastle.util.encoders.Hex;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jesion on 2017-04-24.
 */
public class MerkleTreeTest {

    @Test
    public void buildTest() {

        String randomString = Hex.toHexString(DataGenerator.generate());

        Assert.assertTrue(true);

    }


}
