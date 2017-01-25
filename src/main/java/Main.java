import application.generatorController.Generator;

public class Main {
    public static void main(String[] args){
        Generator generator = new Generator();
        generator.generateBusinessRuleById(12);
    }
}
