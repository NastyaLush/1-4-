package com.company;

import com.company.Exception.DethException;
import com.company.Exception.UncheckedException;

import java.util.Objects;

public class We extends ActiveObject implements Actions {

    private final String name= "we";
    private static String conditionInTheMoment="нет состояния";
    private boolean wearClothes = false;
    private static float  lackOfAir=0;
    private static float lackOfFreeze=0;
    private float health=100;
// exception when change place
    public String move(ActiveObject o, PassiveObject whereFrom, PassiveObject destination,String transport ) {
        try{
        canChange(o.getCondition());
            death(lackOfAir);
            death(lackOfFreeze);
            o.setCondition ("приближается к "+destination.toString()+" из "+ whereFrom.toString());
            return o.getName() + " " + o.getCondition() + " на "+ transport;}
        catch (UncheckedException e){

            return e.getMessage()+"на данный момент мы в дорге, прекратите для начала перемещение";
        }
        catch (DethException p){
            return p.getMessage();
        }


    }
    // exception about change condition
    public String toDo(Activities a, PassiveObject o, String thoughts){
        try {death(lackOfAir);
            death(lackOfFreeze);
            canChange(conditionInTheMoment);
            conditionInTheMoment = a.toString();
            return o.getName() + " " + a + " " + thoughts;
        }
        catch (UncheckedException e){
            return e.getMessage() + " на данный момент"+ getConditionInTheMoment();
        }
        catch (DethException p){
            return p.getMessage();
        }
    }
    //here we must caugth exception + обработка вывода
    public String putOnClothes(Clothes thing, ActiveObject activeObject) {
        try {
            death(lackOfAir);
            death(lackOfFreeze);
            isFalse(wearClothes);
            this.wearClothes = false;
            return "одежда: "+ thing+ " снята с "+ activeObject.toString();
        }
        catch (UncheckedException e){
            return e.getMessage()+" одеждв снята, для начала наденьте ее";
        }
        catch (DethException p){
            return p.getMessage();
        }
    }
    public String takeOffClothes(Clothes thing, ActiveObject activeObject){
        try {death(lackOfAir);
            death(lackOfFreeze);
            isTrue(wearClothes);
            wearClothes= true;
            return "одежда: "+ thing+ " надета на "+ activeObject.toString();
        }
        catch (UncheckedException e){
            return e.getMessage()+"одежда на данный момент надета, снимите ее";
        }
        catch (DethException p){
            return p.getMessage();
        }

    }
    //реализовать смерть и теперь при попытке обратиться ловить ошибки и говорить, что пользователя нет
    public String suffocate() {

        try {
            death(lackOfAir);
            death(lackOfFreeze);
            lackOfAir += 0.1;
            return getName() + " испытывает недостаток воздуха, еще" + (1 - lackOfAir) * 10 + "проишествий и " + getName() + "умрет";
        }
        catch (DethException p){
            return p.getMessage();
        }
    }
    public String freeze(){
        try {
            death(lackOfAir);
            death(lackOfFreeze);
            lackOfFreeze += 0.1;
            return getName() + " испытывает холод, еще" + (1 - lackOfFreeze) * 10 + "проишествий и " + getName() + "умрет";
        }
        catch (DethException p){
            return p.getMessage();
        }
    }
    public String whatAboutWeThink(ActiveObject a, String s){
        return a.getName()+ " "+s;

    }

    //нужен метод согреться и надышаться и добавь синглтоны!


    public String flying(){
        try {
            death(lackOfAir);
            death(lackOfFreeze);
        this.suffocate();
        this.freeze();
        return getName()+ " "+ "полетели, частые полеты ухудшают здоровье";}
         catch (DethException p){
            return p.getMessage();
        }
    }

    enum Relax{
        SLEEP,
       LANDING,
       EATING
   }
    public String recuperation(Relax relax){

        class Health{
            float lackOfAir= We.this.getLackOfAir();
            float lackOfFreeze= We.this.getLackOfFreeze();
        public void fullRecovery(){
            lackOfAir=0;
            lackOfFreeze=0;
            }
        public void recovery(){
            lackOfAir-=0.1;
            lackOfFreeze-=0.1;
        }
        }
        try {
            death(lackOfAir);
            death(lackOfFreeze);
            if (relax == Relax.SLEEP) {
                Health health = new Health();
                health.fullRecovery();
                lackOfAir = health.lackOfAir;
                lackOfFreeze = health.lackOfFreeze;
                return "здоровье полностью восстановлено";
            } else {
                Health health = new Health();
                health.recovery();
                lackOfAir = health.lackOfAir;
                lackOfFreeze = health.lackOfFreeze;
                return "здоровье частично восстановлено";
            }
        }
        catch (DethException p){
            return p.getMessage();
        }

    }
    public String getConditionInTheMoment() {
        return conditionInTheMoment;
    }

    public static class Denfort extends ActiveObject{
        private String name="Denfort";

        private String condition="нет состояния";

        private Denfort() {}
        private Denfort holder= null;
        public Denfort create(){
            if(holder==null){
                holder=new Denfort();
                return holder;
            }
            else return holder;
        }
        public String drivePlane(){
            try {
                death(We.lackOfAir);
                death(We.lackOfFreeze);
            conditionInTheMoment="летят в самолете";
            condition="вдит самолет";
            return name + " водит самолет";}
            catch (DethException p){
                return p.getMessage();
            }
        }
        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getCondition() {
            return condition;
        }
    }

    public static final class  Author extends ActiveObject{
        private String name="I";
        private String condition;

        public String lookAround(){
            try {
                death(We.lackOfAir);
                death(We.lackOfFreeze);
                condition = "осматривается";
                return "осматривается";
            }
            catch (DethException p){
                return p.getMessage();
            }
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getCondition() {
            return condition;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public boolean isWearClothes() {
        return wearClothes;
    }

    public float getLackOfAir() {
        return lackOfAir;
    }

    public float getLackOfFreeze() {
        return lackOfFreeze;
    }

    public float getHealth() {
        return health;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof We)) return false;
        We we = (We) o;
        return Objects.equals(getName(), we.getName()) && Objects.equals(getConditionInTheMoment(), we.getConditionInTheMoment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getConditionInTheMoment());
    }

    @Override
    public String toString() {
        return "We{" +
                "name='" + name + '\'' +
                ", conditionInTheMoment='" + conditionInTheMoment + '\'' +
                '}';
    }
}
