import application.generatorController.Generator;

/**
 * Created by Maarten de Klerk on 18-1-2017.
 */
public class Main {
    public static void main(String[] args){
        Generator generator = new Generator();
        generator.generateBusinessRuleById(1);
    }
}
