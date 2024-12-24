package com.hockey.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

public class ReferenceData {

    static Logger logger = Logger.getLogger(ReferenceData.class);
    static Map<Integer, String> gameType = new HashMap<>();
                            
    public ReferenceData() {
                         
        gameType.put(1, "Preseason");
        gameType.put(2, "Regular");
        gameType.put(3, "Playoffs");
        gameType.put(4, "AllStar Men");
        gameType.put(12, "AllStar Women");
        gameType.put(19, "First Nations");
                 
        logger.debug("setReferenceData has been reached");
        // Java 8
        gameType.forEach((k, v) -> {
            logger.debug("Key: " + k + ", Value: " + v);
                }
            );
        }
                        
                public String getGameType(Integer inputGameType) {
                              
                    logger.debug("reference data gameType has been reached " + inputGameType);
                    logger.debug("result is " + gameType.get(inputGameType));
            
                    return gameType.get(inputGameType);
                }
                public static List<String> getAllGameTypes() {
                              
                    logger.debug("reference data getAllGameTypes has been reached ");
                
                    List<String> allGameTypes=new ArrayList<String>();  
                    gameType.forEach((k, v) -> {
                        logger.debug("\"Value: \" + v");
                        allGameTypes.add(v);
                            }
                        );
                  
                    logger.debug("allGameTypes -- " + allGameTypes);
                    
                    return allGameTypes;
                }
}

