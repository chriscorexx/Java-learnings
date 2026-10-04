class Calculator{
    int add(int a, int b){
     return a +  b;
  }

   int add(int a, int b, int c){
    return a + b + c;
  }

   double add(double a, double b){
    return a + b;
  }

  public static void main(String[] args){
    Calculator obj = new Calculator();

    System.out.println("Addition of two numbers: "+ obj.add(10,20));

    System.out.println("Addition of Three numbers: "+ obj.add(23, 34, 45));

    System.out.println("Addition of Two decimal integers: "+ obj.add(23.1, 24.6));

  }
}

//function overloading example
