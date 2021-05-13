package com.example.demo;

import org.yeauty.pojo.Session;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * socket池化处理，提高并发能力
 */
public class SocketPool {

    ConcurrentHashMap<String, List<Session>> serversMap = new ConcurrentHashMap<>(5);

    public void add(){
        // TODO:

    }

    public void remove(){

    }
}
