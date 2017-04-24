package com.robertjesionek.merkletree;

import java.util.Random;

/**
 * Created by Jesion on 2017-04-24.
 */
public class DataGenerator {

    public static byte[] generate() {
        byte[] bytes = new byte[100000];
        new Random().nextBytes(bytes);
        return bytes;
    }
}
