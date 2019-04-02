import interpreter.*;
import interpreter.Number;

public class Main {

    public static void main(String[] args) {

        Expression e = new Plus(new Number(3d), new Multiply(new Divide(new Number(4d), new
                Number(2d)), new Number(5d)));

        System.out.print("Result is: " + e.calculate());

//        Interpreter interpreter = new ShuntingYard();
//        String[] exp = {"3","4","2","/","5","*","+"};
//        System.out.print("Result of postfix is: " + interpreter.evaluatePostfix(exp));
    }


}
