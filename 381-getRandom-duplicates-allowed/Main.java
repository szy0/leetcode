public class Main {
    public static void main(String[] args) {
        RandomizedCollection rc = new RandomizedCollection();
        rc.insert(10);
        rc.insert(10);
        rc.insert(20);
        rc.insert(20);
        rc.insert(30);
        rc.insert(30);


        rc.remove(10);
        rc.remove(20);
        rc.remove(30);
        rc.remove(30);

        // System.out.println("test1");
        // System.out.println("test2");
        // System.out.println("test3");
        // System.out.println("test4");

        System.out.println(rc.getRandom());
        System.out.println(rc.getRandom());
        System.out.println(rc.getRandom());
        System.out.println(rc.getRandom());
        System.out.println(rc.getRandom());
        System.out.println(rc.getRandom());
        System.out.println(rc.getRandom());


    }
}