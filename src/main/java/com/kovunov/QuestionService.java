package com.kovunov;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class QuestionService {
    private Map<Integer, String> resultsMap;

    @PostConstruct
    private void populateMap() {
        resultsMap = new HashMap<>();
        resultsMap.put(1, "T3R0YXdh");
        resultsMap.put(2, "Q2FwZSBEZXpobmV2");
        resultsMap.put(3, "TWF1bmEgS2Vh");
        resultsMap.put(4, "U2FyZ2Fzc28gc2Vh");
        resultsMap.put(5, "U3VkYW4=");
        resultsMap.put(6, "RWN1YWRvciBhbmQgQ2hpbGU=");
    }

    public Map<Integer, String> getResultsMap() {
        return resultsMap;
    }
}
