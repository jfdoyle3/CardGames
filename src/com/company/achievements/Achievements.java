package com.company.achievements;

import java.util.HashMap;

public class Achievements {

    private HashMap<String,Boolean> achievementList;

    public Achievements() {
        this.achievementList=new HashMap<>();
    }

    public void buildList(){
        achievementList.put("Win A Round",false);
    }

    public HashMap<String, Boolean> getAchievementList() {
        return achievementList;
    }

}
