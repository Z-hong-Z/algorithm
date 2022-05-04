package TrimTree;

public class Main {
    public static void main(String[] args) {
        Utils.insertTree("helloword");
        Utils.insertTree("helloword");
        Utils.insertTree("helloword");
        Utils.insertTree("heeloword");

        System.out.println(Utils.search("helloword"));
        System.out.println(Utils.getNumber("he"));
        Utils.delete("helloword");
        System.out.println(Utils.getNumber("he"));
    }
}
