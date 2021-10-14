package stringaddcalculator;

public class Application {
    public static void main(String[] args) {
        Application computer = new Application();
        computer.run();
    }
    private void run(){
        User user = new User();

        try{
            System.out.println(StringAddCalculator.splitAndSum(user.getInput()));
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
            run();
        }
    }
}
