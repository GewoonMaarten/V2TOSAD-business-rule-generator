import application.generatorController.Generator;

public class Main {
    public static void main(String[] args){
        Generator generator = new Generator();
        System.out.println(generator.generateBusinessRuleById(12));
    }
}
