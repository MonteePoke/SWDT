import Hashing.ClosedHash;

public class ClosedHashTest {
    public static void run() {
        System.out.println("Закрытое хеширование");
        int hashTableSize = 10;

        ClosedHash<MyString, MyString> closedHash = new ClosedHash<>(hashTableSize);

        String[] NumberArray = {"Один", "Два", "Три", "Четыре", "Пять", "Шесть", "Семь", "Восемь", "Девять", "Десять", "Одинадцать"};

        for (int i = 0; i < NumberArray.length; i++) {
            if(!closedHash.insert(new MyString(NumberArray[i]), new MyString(NumberArray[i]))){
                System.out.println(closedHash.toString());
                System.out.println("Произошло переполнение таблицы");
                break;
            }
        }

        int d = 3;
        if(!closedHash.remove(new MyString(NumberArray[d])))
            System.out.println("Не удалось найти объект");

        System.out.println("\nУдаляем \""+NumberArray[d]+"\" с ключем \""+NumberArray[d]+"\"");
        System.out.println(closedHash.toString());

        int i = 10;
        System.out.println("\nДобавляем \""+NumberArray[i]+"\" с ключем \""+NumberArray[i]+"\"");

        if(!closedHash.insert(new MyString(NumberArray[i]), new MyString(NumberArray[i])))
            System.out.println("Переполнение таблицы");

        System.out.println(closedHash.toString());

        System.out.println("\nДобавляем \"Five\" с ключем \"Пять\"");
        if(!closedHash.insert(new MyString("Пять"), new MyString("Five")))
            System.out.println("Произошло переполнение таблицы");
        System.out.println(closedHash.toString());
    }
}
