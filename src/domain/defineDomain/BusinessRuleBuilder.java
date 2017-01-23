package domain.defineDomain;

import data.definePersistency.facade.DefinePersistency;

import java.util.ArrayList;
import java.util.HashMap;

public class BusinessRuleBuilder {

    public void defineBusinessRule(int businessRuleID)
    {
        HashMap<String,Object> details = DefinePersistency.getInstance().getBusinessRuleDetails(businessRuleID);
        HashMap<String,Object> typeDetails = DefinePersistency.getInstance().getBusinessRuleTypeDetails(businessRuleID);

        BusinessRule businessRule = new BusinessRule(businessRuleID, (String) details.get("name"), details);
        BusinessruleType businessruleType;

        int typeId = (Integer)typeDetails.get("id");
        String typeName = (String)typeDetails.get("name");
        String typeCode = (String)typeDetails.get("code");
        String typeDescription = (String)typeDetails.get("description");
        String typeExample = "";
        if(typeDetails.containsKey("example"))
            typeExample = (String)typeDetails.get("example");
        Category typeCategory = new Category((Integer)typeDetails.get("categoryid"),(String)typeDetails.get("categoryname"));


        if(typeExample != "")
            businessruleType = new BusinessruleType(typeId,typeName,typeCode,typeDescription,typeCategory);
        else
            businessruleType = new BusinessruleType(typeId,typeName,typeCode,typeDescription, typeExample,typeCategory);

        businessRule.setRuleType(businessruleType);

        TargetDatabaseType targetDatabaseType = new TargetDatabaseType(businessRuleID);

        businessruleType.setTargetDatabaseType(targetDatabaseType);

        ArrayList<HashMap<String,Object>> attributesDetails = DefinePersistency.getInstance().getBusinessRuleAttributesDetails(businessRuleID);
        for(HashMap<String, Object> map : attributesDetails)
        {
            Attribute attribute = new Attribute(map);
            businessRule.addAttribue(attribute);
        }

        //TODO figure the fuck out how template shit works
    }
}