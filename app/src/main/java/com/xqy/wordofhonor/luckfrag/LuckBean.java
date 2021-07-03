package com.xqy.wordofhonor.luckfrag;

import java.io.Serializable;
import java.util.List;

public class LuckBean implements Serializable {

    private List<ActorinfoBean> actorinfo;

    public List<ActorinfoBean> getActorinfo() {
        return actorinfo;
    }

    public void setActorinfo(List<ActorinfoBean> actorinfo) {
        this.actorinfo = actorinfo;
    }

    public static class ActorinfoBean implements Serializable{
        private String name;
        private String actor;
        private String zhiye;
        private String birthday;
        private String play;
        private String info;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getActor() {
            return actor;
        }

        public void setActor(String actor) {
            this.actor = actor;
        }

        public String getZhiye() {
            return zhiye;
        }

        public void setZhiye(String zhiye) {
            this.zhiye = zhiye;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getPlay() {
            return play;
        }

        public void setPlay(String play) {
            this.play = play;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }
}
