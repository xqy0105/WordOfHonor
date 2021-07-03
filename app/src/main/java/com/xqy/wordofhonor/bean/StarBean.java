package com.xqy.wordofhonor.bean;

import java.io.Serializable;
import java.util.List;

public class StarBean implements Serializable {

    private List<StarinfoBean> starinfo;

    public List<StarinfoBean> getStarinfo() {
        return starinfo;
    }

    public void setStarinfo(List<StarinfoBean> starinfo) {
        this.starinfo = starinfo;
    }

    public static class StarinfoBean implements Serializable{
        private String logoname;
        private String name;
        private String actor;
        private String shenfen;
        private String info;
        private String zhiye;
        private String birthday;
        private String play;
        private String actorinfo;

        public String getLogoname() {
            return logoname;
        }

        public void setLogoname(String logoname) {
            this.logoname = logoname;
        }

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

        public String getShenfen() {
            return shenfen;
        }

        public void setShenfen(String shenfen) {
            this.shenfen = shenfen;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getZhiye() {
            return zhiye;
        }

        public void setZhiye(String info) {
            this.zhiye = zhiye;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String info) {
            this.birthday = birthday;
        }

        public String getPlay() {
            return play;
        }

        public void setPlay(String info) {
            this.play = play;
        }

        public String getActorinfo() {
            return actorinfo;
        }

        public void setActorinfo(String info) {
            this.actorinfo = actorinfo;
        }

    }
}
