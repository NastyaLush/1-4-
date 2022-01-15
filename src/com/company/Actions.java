package com.company;

public interface Actions {
    public String move(ActiveObject o, PassiveObject whereFrom, PassiveObject destination,String transport );
    public String toDo(Activities a, PassiveObject o, String thoughts);
    public String takeOffClothes(Clothes thing, ActiveObject a);
    public String putOnClothes(Clothes thing, ActiveObject activeObject);
    public String freeze();
    public String suffocate();
    public String whatAboutWeThink(ActiveObject a, String s);
    public String flying();
    public String recuperation(We.Relax relax);
}
