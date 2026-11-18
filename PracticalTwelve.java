class Demo {
    public static void main(String[] args) {
        Integer obj1 = Integer.valueOf(100);
        Double obj2 = Double.valueOf(25.5);
        Float obj3 = Float.valueOf(15.5f);

        int a = obj1.intValue();
        double b = obj2.doubleValue();
        float c = obj3.floatValue();

        System.out.println("Integer to int: " + a);
        System.out.println("Double to double: " + b);
        System.out.println("Float to float: " + c);
    }
}
