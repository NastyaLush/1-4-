package com.company;

public class Camp extends PassiveObject{
 final private String name ="лагерь";
 private String location;

    public String getLocation() {
        return location;
    }
    // иначе выкинь ошибку
    public void setLocation(String location) {
        if(this.location==null){
            this.location = location;
        }

    }

    @Override
    public String getName() {
        return name;
    }
}
