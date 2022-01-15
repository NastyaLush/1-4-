package com.company;

public abstract class ActiveObject extends PassiveObject {

    private String condition ="нет состояния";
    protected boolean objects = false;
// condition можно сделать вложенным нестатическим классом
    public class condition{
        public String changeCondition(String s){
        condition=s;
        return "состояние изменено";
        }
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }
    public String getCondition() {
        return condition;
    }
}


