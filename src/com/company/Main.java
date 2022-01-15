package com.company;

public class Main {

    public static void main(String[] args) {
        // анонимный класс создать здесь, мб реализация  интерфейса
        // в активобджект есть нестатический вложенный класс
        // осталось статический вложенный и локальный
        //локальный можно в we в метод чисто для присваивания переменной, чтобы класс отвечал за 1 действие!!! принцип единственной ответственности
        //статический вложенный класс в we
        // анонимный не то осталось придумать, что делать с ним
       We we = new We();
    Mountain mountain = new Mountain();
    AtmosphericPhenomena atm = new AtmosphericPhenomena();
       Description description= new Description() {
            public String getDescription(PassiveObject object, String content, String author){
                return "description of "+ object.getName()+" "+ content;
            }
        };

    Constractions cons = new Constractions();
    Camp camp= new Camp();
    System.out.println(
    we.move(we,camp,mountain,"самолет")+"\n"+
    description.getDescription(mountain,"мрачные, грозно темневшие над снежной линией, отделявшей обнаженную породу от вечных льдов","we")+"\n"+
    we.toDo(Activities.NOTICE,we,"все большее количество прилепившихся к горным склонам геометрически правильных конструкций и в очередной раз ")+"\n"+
    cons.stickTo(cons, mountain)+"\n"+
            description.getDescription(mountain,"достигавших и так приблизительно двенадцать тысяч футов, поэтому фактически нам нужно было подняться не на такую уж большую высоту","we")+"\n"+
            we.toDo(Activities.REMEMBER,we,"загадочные картины Николая Рериха из его азиатской серии")+"\n"+
    description.getDescription(mountain,"скорей всего эти гиганты точно так же высились здесь и в исключительно давние времена -- более пятидесяти миллионов лет назад","Лейк")+"\n"+
    we.toDo(Activities.GUESSING,we,"в этом нет смысла")+"\n"+
    atm.containDestruction()+"\n"+
    mountain.Destroid(atm)+"\n"+ we.flying()+"\n"+
            description.getDescription(we, "испытывали дискомфорт, потому что из-за плохой видимости пришлось оставить иллюминаторы открытыми", "we")+"\n"+
   we.move(we,camp,mountain,"самолет")
    );
    }
}
