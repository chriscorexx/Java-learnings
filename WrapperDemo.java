import java.util.ArrayList;

class WrapperDemo
{
    // Program 1: Primitive to Object (Boxing)
    void boxing()
    {
        ArrayList<Integer> list = new ArrayList<Integer>();

        int a = 10;
        double b = 25.5;
        char c = 'A';

        list.add(Integer.valueOf(a));
        list.add(Integer.valueOf((int)b));
        list.add(Integer.valueOf((int)c));

        System.out.println("Primitive to Object:");

        for (Integer obj : list)
        {
            System.out.println(obj);
        }
    }

    // Program 2: Object to Primitive (Unboxing)
    void unboxing()
    {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(Integer.valueOf(100));
        list.add(Integer.valueOf(200));
        list.add(Integer.valueOf(300));

        System.out.println("Object to Primitive:");

        for (Integer obj : list)
        {
            int num = obj.intValue();
            System.out.println(num);
        }
    }

    public static void main(String[] args)
    {
        // Same object calling both methods
        WrapperDemo obj = new WrapperDemo();

        obj.boxing();
        obj.unboxing();
    }
}
