package uncomplete;

public class JVM {
    public static void main(String[] args) {
        String abc = new String("abc");
        char[] ch = {'a', 'b', 'c'};
        change(abc,ch);
        System.out.println(abc+"");
        System.out.println(ch);
    }

    public static void change(String str, char[] ch) {
        str = "gbc";
        ch[0] = 'g';
    }
}
