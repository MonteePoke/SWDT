import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Objects;

public class MyString {
    private String string = null;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public MyString(String string) {
        setString(string);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyString myString = (MyString) o;
        return Objects.equals(string, myString.string);
    }

    @Override
    public int hashCode() {
        byte[] bytes = string.getBytes(Charset.forName("CP855"));

        long hash = 0;
        BigInteger base = new BigInteger("31");

        for (int i = 0; i < bytes.length; i++) {
            hash += base.pow(bytes.length-1-i).longValue() * (bytes[i] & 0xFF);
        }
        return (int) hash;
    }

    @Override
    public String toString() {
        return string;
    }
}
