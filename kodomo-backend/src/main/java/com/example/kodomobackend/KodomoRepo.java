package com.example.kodomobackend;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class KodomoRepo {

    private static HashMap<Integer, Feed> feedHashMap = new HashMap<>();
    private static  Integer key = 0;


    public void createFeed(Feedreq request) {
        feedHashMap.put(key++, new Feed(request.getTitle(), request.getContent()));
    }

    public Feed getFeed(Integer key) {
        return feedHashMap.get(key);
    }
}
