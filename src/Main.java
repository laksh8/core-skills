public class Main {
    public static void main(String[] args){

        // trying out dynamic array features

        DynamicArray da = new DynamicArray(5);
        System.out.println("capacity " + da.getCapacity());

        da.set(5,32);
        da.set(0, 99);
        da.set(0,32);
        da.set(3,33);

        da.pushback(34);

        da.getAll();

        da.popback();

        System.out.println("size " + da.getSize());
        System.out.println("capacity " + da.getCapacity());


    }
}
