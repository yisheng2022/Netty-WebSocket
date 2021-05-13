package com.example.demo;

import org.springframework.stereotype.Component;
import org.yeauty.annotation.OnClose;
import org.yeauty.annotation.OnMessage;
import org.yeauty.annotation.OnOpen;
import org.yeauty.annotation.ServerEndpoint;
import org.yeauty.pojo.Session;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


@ServerEndpoint(port = "9999",value = "/chat")
//@Component
public class MyWebSocketServer {

//    private static ConcurrentHashMap<String, List<MyWebSocketServer>> serversMap = new ConcurrentHashMap<>(5);

    private static Set<MyWebSocketServer> socketServerSet = new HashSet<>();
    private volatile static int onLineCount = 0;
    Session session = null;

    @OnOpen
    public void onOpen(Session session){
        System.out.println("new connection.");
        onLineCount++;

        socketServerSet.add(this);
        this.session = session;
    }

    @OnClose
    public void onClose(Session session){
        System.out.println("one connection closed.");
        onLineCount--;
    }

    @OnMessage
    public void onMessage(Session session,String msg){
        System.out.println(msg);

        // 给所有其他人群发消息
        {
            for (MyWebSocketServer myWebSocketServer : socketServerSet) {
                if(myWebSocketServer!=this){
                    myWebSocketServer.send(msg);
                }
            }
        }
    }

    public void send(String msg){
        this.session.sendText(msg);
    }
}
