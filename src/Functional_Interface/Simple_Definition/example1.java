package Functional_Interface.Simple_Definition;

public class example1 {

    @FunctionalInterface
    interface Square
    {
        int calculate(int x);
    }

    public static void main(String args[]) {
        int a = 5;

        // lambda expression to define the calculate method (implementing abstract method 'calculate')
        Square s = (x) -> x*x;

        // parameter passed and return type must be
        // same as defined in the prototype
        int ans = s.calculate(a);
        System.out.println(ans);
    }
}
