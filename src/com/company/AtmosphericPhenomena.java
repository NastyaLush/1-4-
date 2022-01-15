package com.company;

import com.company.Exception.IsPositive;

import java.util.Objects;
import java.util.Scanner;

public class AtmosphericPhenomena extends PassiveObject {
    private final String name="Атмосферные условия";
    private int power=1;
    private int destruction=0;

    AtmosphericPhenomena(){}
    public String AtmosphericPhenomenaPlusPower(int power){
        try {
        power(this.getPower());
        this.power=power;
        return "Сила увеличена";}
        catch (IsPositive e){
            return e.getMessage();
        }
    }



    public String containDestruction(){
        if((power-destruction)>=0) return getName()+ " сдерживать разрушения";
        else return getName()+" не достаточно силы сдержать разрушения";
    }
    public String containDestruction(int destruction) {
        this.destruction=destruction;
       return containDestruction();
    }
    public int getPower() {
        return power;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AtmosphericPhenomena)) return false;
        AtmosphericPhenomena that = (AtmosphericPhenomena) o;
        return getPower() == that.getPower() && destruction == that.destruction && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPower(), destruction);
    }

    @Override
    public String toString() {
        return "AtmosphericPhenomena{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", destruction=" + destruction +
                '}';
    }
}
