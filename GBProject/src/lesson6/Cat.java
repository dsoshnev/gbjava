package lesson6;

public class Cat  extends Animal {

    //3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;прыжок: кот 2 м.,
    //   собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
    public Cat(String nickName) {
        super(nickName,200,0,2);
    }
}
