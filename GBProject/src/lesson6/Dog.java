package lesson6;

import java.util.Random;

public class Dog extends Animal{

    //3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;прыжок: кот 2 м.,
    //   собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
    public Dog(String nickName) {

        super(nickName, 500,10, 0.5);
        double[] runs = {100,200,300,400,500};
        Random rand = new Random();
        this.setMaxRunLength(runs[rand.nextInt(5)]);
    }
}
