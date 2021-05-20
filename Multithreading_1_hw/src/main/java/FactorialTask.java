import calculator.Calculator;

public class FactorialTask implements Runnable{

    private Calculator calculator;
    private int arg;

    public FactorialTask(Calculator calculator, int arg) {
        this.calculator = calculator;
        this.arg = arg;
    }


    @Override
    public void run() {
        System.out.println( "factorial(" + arg +") = " + calculator.calcFactorial( arg ));
    }
}
