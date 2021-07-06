package com.home;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Bowling {
 HashMap<String, Integer> players;
 Bowling() {
     players = new HashMap<String, Integer>();
 }
 public void addPlayer(String name, int p) {
     players.put(name, p);
 }

 public void getWinner() {
     int maxValueInMap = (Collections.max(players.values()));
     for (Map.Entry<String, Integer> entry : players.entrySet()) {
        if (entry.getValue() == maxValueInMap) {
            System.out.println(entry.getKey());
        }
     }
//     Iterator<String> it = players.keySet().iterator();
//     String max;
//     int test = 0;
//     while (it.hasNext()) {
//         String value = it.next();
//     }

 }

}
