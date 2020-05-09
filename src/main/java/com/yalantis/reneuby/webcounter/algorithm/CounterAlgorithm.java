package com.yalantis.reneuby.webcounter.algorithm;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CounterAlgorithm {
    Map<String, String> sessionIdUrlMap = new ConcurrentHashMap<>();

    public long getCount(String url) {
        long count = sessionIdUrlMap.entrySet().stream()
                .filter(k -> {
                    return (sessionIdUrlMap.get(k.getKey()) != null && sessionIdUrlMap.get(k.getKey()).equals(url));
                })
                .count();
        return count;
    }

    public void doFilter(String id, String uri) {
        if (!sessionIdUrlMap.containsKey(id)) {
            sessionIdUrlMap.put(id, uri);
        } else {
            sessionIdUrlMap.remove(id);
            sessionIdUrlMap.put(id, uri);
        }
    }
}
