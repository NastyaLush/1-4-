package com.company;

import java.util.Objects;

public class Mountain extends ActiveObject {
    private final String name="Горы";
    private int destruction=1;
    protected int speedDestruction=3;


   public String Destroid(AtmosphericPhenomena a){
       if (this.destruction-a.getPower()<=1) speedDestruction=speedDestruction/2;
        if(speedDestruction<=1) return this.name+ " медленно разрушаться";
        else return this.name+" разрушаться обычно";
   }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mountain)) return false;
        Mountain mountain = (Mountain) o;
        return destruction == mountain.destruction && speedDestruction == mountain.speedDestruction && Objects.equals(getName(), mountain.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), destruction, speedDestruction);
    }

    @Override
    public String toString() {
        return "Mountains{" +
                "name='" + name + '\'' +
                ", destruction=" + destruction +
                ", speedDestruction=" + speedDestruction +
                '}';
    }
}
