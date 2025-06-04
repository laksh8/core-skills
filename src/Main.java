public class Main {
    public static void main(String[] args) {

        // trying out hash map

        HashedMap hm = new HashedMap(10);

        hm.insert(5, 234);
        hm.insert(15, 233);

        hm.insert(5, 123);
        hm.insert(15, 234);

        System.out.println("Size: "+ hm.getSize());
        System.out.println("Arr Length: "+ hm.getArrLength());
        System.out.println("Load Factor: "+ (float)hm.getSize()/hm.getArrLength());

        for (int i = 0; i < 7; i++){
            hm.insert(i, 45);
        }

        System.out.println("Size: "+ hm.getSize());
        System.out.println("Arr Length: "+ hm.getArrLength());
        System.out.println("Load Factor: "+ (float)hm.getSize()/hm.getArrLength());

        hm.displayMap();

        hm.insert(45, 32);

        System.out.println("Size: "+ hm.getSize());
        System.out.println("Arr Length: "+ hm.getArrLength());
        System.out.println("Load Factor: "+ (float)hm.getSize()/hm.getArrLength());

        hm.displayMap();

        hm.remove(15);
        hm.remove(14);

        System.out.println(hm.get(5));
        System.out.println(hm.get(4));

    }
}