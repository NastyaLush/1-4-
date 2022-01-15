package com.company;

import java.util.Objects;

public class Constractions extends ActiveObject {
    private final String name="Конструкции";
    private String condition="нет";

    public String stickTo(ActiveObject subject, ActiveObject object) {
        if(object.objects==false) {object.objects= true;
            subject.setCondition("прилипились");
            return subject.getName()+" прилипились к "+object.getName();}
        else return "мест нет чтобы "+subject.getName()+ " прилипились "+object.getName();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Constractions)) return false;
        Constractions that = (Constractions) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getCondition(), that.getCondition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCondition());
    }

    @Override
    public String toString() {
        return "Constractions{" +
                "name='" + name + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }
}



