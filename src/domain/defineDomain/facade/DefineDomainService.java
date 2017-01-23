package domain.defineDomain.facade;

import domain.defineDomain.BusinessRule;

import java.util.ArrayList;

/**
 * Created by Maarten de Klerk on 18-1-2017.
 */
public class DefineDomainService {
    private static DefineDomainService instance = null;

    private ArrayList<BusinessRule> businessRules;

    private DefineDomainService(){
        businessRules = new ArrayList<BusinessRule>();
    }

    public DefineDomainService getInstance(){
        if(instance == null){
            instance = new DefineDomainService();
        }
        return instance;
    }

    public void setGeneratedCode(int id, String code){
        for (BusinessRule businessRule : businessRules){
            if(businessRule.getId() == id){
                businessRule.setGeneratedTrigger(code);
            }
        }
    }
    public ArrayList<String> getAllGeneratedBusinessRuleCode(){
        ArrayList<String> allGeneratedBusinessRuleCode = new ArrayList<String>();

        for(BusinessRule businessRule : businessRules){
            allGeneratedBusinessRuleCode.add(businessRule.getGeneratedTrigger());
        }
        return allGeneratedBusinessRuleCode;
    }
}