package java2.lesson24;

public class App24 {

    //1. Создать окно для клиентской части чата: большое текстовое поле для отображения переписки в центре окна.
    // Однострочное текстовое поле для ввода сообщений и кнопка для отсылки сообщений на нижней панели.
    // Сообщение должно отсылаться либо по нажатию кнопки на форме, либо по нажатию кнопки Enter.
    // При «отсылке» сообщение перекидывается из нижнего поля в центральное.
    //2*. Добавить в левой панели окна список пользователей. Список должен быть заполнен статическими данными,
    // например массивом из кода. При выборе определенного пользователя отправка сообщения должна идти с учётом
    // его имени (можно дублировать 2 записи в чате: от себя и от пользователя)

    public static void main(String[] args) {
        new MyMainWindow();
    }
}
