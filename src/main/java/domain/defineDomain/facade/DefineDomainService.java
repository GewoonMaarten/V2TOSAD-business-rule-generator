package main.java.domain.defineDomain.facade;

import main.java.domain.defineDomain.BusinessRule;
import main.java.domain.defineDomain.BusinessRuleBuilder;

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

    public static DefineDomainService getInstance(){
        if(instance == null){
            instance = new DefineDomainService();
        }
        return instance;
    }


    public BusinessRule getBusinessRule(int businessRuleID) {
        BusinessRuleBuilder businessRuleBuilder = new BusinessRuleBuilder();

        return businessRuleBuilder.defineBusinessRule(businessRuleID);
    }
}
