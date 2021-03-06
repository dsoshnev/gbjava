package java2.lesson21;

public class App21 {
    // 1.Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
    // Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
    // 2.Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять соответствующие
    // действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
    // 3.Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
    //*4.У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
    // Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.

    public static void main(String[] args) {

        Actor[] actors = {
            new Cat("Барсик", 5,1),
            new Human("Дмитрий", 50,2),
            new Robot("Василий", 500,3)};

        Exercise[] exercises = {
            new RunningTrack(5),
            new Wall(1),
            new RunningTrack(50),
            new Wall(2),
            new RunningTrack(500),
            new Wall(3)};

        for (Actor a : actors) {
            for (Exercise e : exercises) {
                if(!e.doIt(a)) { break; }
            }
        }
    }
}
