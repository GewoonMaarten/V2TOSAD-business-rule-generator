package main.java.domain.defineDomain;

import java.util.HashMap;

/**
 * Created by Maarten de Klerk on 13-1-2017.
 */
public class BusinessRule {
    private int id;
    private String name;
    private HashMap<String, Object> values;
    private String generatedTrigger;

    public String getGeneratedTrigger() {
        return generatedTrigger;
    }

    public int getId() {

        return id;
    }

    public void setGeneratedTrigger(String generatedTrigger){
        this.generatedTrigger = generatedTrigger;
    }
}
