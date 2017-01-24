package domain.defineDomain;

import data.definePersistency.facade.DefinePersistencyService;

import java.util.ArrayList;
import java.util.HashMap;

public class BusinessRuleBuilder {

    public BusinessRule defineBusinessRule(int businessRuleID)
    {
        HashMap<String,Object> details = DefinePersistencyService.getInstance().getBusinessRuleDetails(businessRuleID);
        BusinessRule businessRule = new BusinessRule(businessRuleID, (String) details.get("name"), details);
        HashMap<String,Object> typeDetails = DefinePersistencyService.getInstance().getBusinessRuleTypeDetails(businessRuleID);


        BusinessruleType businessruleType;

        int typeId = (Integer)typeDetails.get("id");
        String typeName = (String)typeDetails.get("name");
        String typeCode = (String)typeDetails.get("code");
        String typeDescription = (String)typeDetails.get("description");
        String typeExample = "";
        if(typeDetails.containsKey("example"))
            typeExample = (String)typeDetails.get("example");
        Category typeCategory = new Category((Integer)typeDetails.get("categoryid"),(String)typeDetails.get("categoryname"));


        if(!typeExample.equals(""))
            businessruleType = new BusinessruleType(typeId,typeName,typeCode,typeDescription,typeCategory);
        else
            businessruleType = new BusinessruleType(typeId,typeName,typeCode,typeDescription, typeExample,typeCategory);

        businessRule.setRuleType(businessruleType);

        TargetDatabase targetDatabase = new TargetDatabase(businessRuleID);
        businessRule.setTargetDatabase(targetDatabase);

        ArrayList<HashMap<String,Object>> attributesDetails = DefinePersistencyService.getInstance().getBusinessRuleAttributesDetails(businessRuleID);
        for(HashMap<String, Object> map : attributesDetails)
        {
            Attribute attribute = new Attribute(map);
            businessRule.addAttribue(attribute);
        }
        return businessRule;
    }
}