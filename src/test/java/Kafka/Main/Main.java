package Kafka.Main;

class Name{
    public String val;
    public Name(String val){
        this.val = val;
    }
}
public class Main {
    public static void main(String[] args) {
        Name s1 = new Name("123");
        Name s2 = new Name("123");
        Name s3 = s1;
        System.out.println(s3.hashCode());
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}
