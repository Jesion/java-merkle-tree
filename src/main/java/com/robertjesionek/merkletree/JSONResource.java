package com.robertjesionek.merkletree;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;

public class JSONResource {

    private String resource;

    public JSONResource(String resource) {
        this.resource = resource;
    }

    public JSONArray readObjectArray() throws IOException, JSONException  {
        final InputStream input = this.getClass().getResource("/" + resource).openStream();
        final StringBuffer content = new StringBuffer();
        final byte[] buffer = new byte[1024];
        int len;
        while ((len = input.read (buffer)) > 0)
        {
            byte[] s = new byte[len];
            System.arraycopy(buffer, 0, s, 0, len);
            content.append(new String(buffer, "UTF-8"));
        }
        return new JSONArray(content.toString());
    }
}
