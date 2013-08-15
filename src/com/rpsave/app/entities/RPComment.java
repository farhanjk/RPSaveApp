package com.rpsave.app.entities;

import java.util.HashMap;

/**
 */
public class RPComment extends RPObject {
    HashMap<String,Object> pairs = new HashMap<String, Object>(1);

    public void addPair(String key, Object parsableObject)
    {
        pairs.put(key, parsableObject);
    }

    public HashMap<String, Object> getPairs() {
        return pairs;
    }

}
