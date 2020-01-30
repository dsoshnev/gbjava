package lesson5;

public class App5 {
    public static void main(String[] args) throws Exception {


        //Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
        //Конструктор класса должен заполнять эти поля при создании объекта.
        //Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
        //Создать массив из 5 сотрудников.
        //Пример:
        //Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
        //persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
        //persArray[1] = new Person(...);
        //...
        //persArray[4] = new Person(...);
        //С помощью цикла вывести информацию только о сотрудниках старше 40 лет.

        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Ivanov Ivan", "Engineer", "Ivanov.Ivan@mailbox.com", "892312312", 30000, 30);
        empArray[1] = new Employee("Petrov Petr", "Doctor", "Petrov.Petr@mailbox.com", "8916123456", 50000, 40);
        empArray[2] = new Employee("Sidorov Semion", "Programmer", "Sidorov.Semion@mailbox.com", "8903987654", 60000, 50);
        empArray[3] = new Employee("Vasin Vasiliy", "Driver", "Vasin.Vasiliy@mailbox.com", "8956876549", 40000, 45);
        empArray[4] = new Employee("Dmitriev Dmitry", "Acountant", "Dmitriev.Dmitry@mailbox.com", "8800856478", 100000, 66);

        for (Employee emp : empArray) {
            if(emp.getAge() > 40) {
                System.out.println(emp);
            }

        }

    }

}
