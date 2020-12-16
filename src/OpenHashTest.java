import Hashing.Node;
import Hashing.OpenHash;

import javax.sound.midi.Soundbank;

public class OpenHashTest {
    public static void run() {
        System.out.println("Открытое хеширование");
        int hashTableSize = 16;
        OpenHash<MyString, MyString> openHash = new OpenHash<MyString, MyString>(hashTableSize);

        String[] NumberArray = {"Один", "Два", "Три", "Четыре", "Пять"};
        String[] EnglishNumberArray = {"One", "Two", "Three", "Four", "Five"};

        for (int i = 0; i < NumberArray.length; i++) {
            openHash.insert(new MyString(NumberArray[i]), new MyString(i+1+""));
            openHash.insert(new MyString(NumberArray[i]), new MyString(NumberArray[i]));
            openHash.insert(new MyString(NumberArray[i]), new MyString(EnglishNumberArray[i]));
        }

        Node node = openHash.search(new MyString(NumberArray[3]));
        System.out.println(node.toString());

        System.out.println(openHash.toString());

        openHash.remove(new MyString("Один"), new MyString("Один"));

        System.out.println("Удаляем \"Один\" с ключем \"Один\"");
        System.out.println(openHash.toString());

        System.out.println("Добавляем \"6\" с ключем \"Шесть\"");
        openHash.insert(new MyString("Шесть"), new MyString("6"));
        System.out.println(openHash.toString()+"\n");
    }
}
