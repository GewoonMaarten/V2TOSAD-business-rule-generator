package main.java.domain.defineDomain;

/**
 * Created by Maarten de Klerk on 13-1-2017.
 */
public class BusinessruleType {
    private int id;
    private String name;
    private String code;
    private String description;
    private String example;
    private Category category;

    public BusinessruleType(int id, String name, String code, String description, String example, Category category) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.example = example;
        this.category = category;
    }

    public BusinessruleType(int id, String name, String code, String description, Category category) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.category = category;
    }
}
