package domain.defineDomain;

import data.definePersistency.facade.DefinePersistencyService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class BusinessRuleBuilder {

    public BusinessRule defineBusinessRule(int businessRuleID)
    {
        HashMap<String,Object> details = DefinePersistencyService.getInstance().getBusinessRuleDetails(businessRuleID);
        BusinessRule businessRule = new BusinessRule(businessRuleID, (String) details.get("name"), details);
        HashMap<String,Object> typeDetails = DefinePersistencyService.getInstance().getBusinessRuleTypeDetails(((BigDecimal) details.get("businessruletypeid")).intValue());

        int typeId = ((BigDecimal)typeDetails.get("businessruletypeid")).intValue();
        String typeName = (String)typeDetails.get("name");
        String typeCode = (String)typeDetails.get("code");
        String typeDescription = (String)typeDetails.get("description");
        String typeExample = (String)typeDetails.get("example");
        Category typeCategory = new Category(((BigDecimal)typeDetails.get("categoryid")).intValue(),(String)typeDetails.get("categoryname"));

        BusinessruleType businessruleType = new BusinessruleType(typeId,typeName,typeCode,typeDescription, typeExample,typeCategory);

        businessRule.setRuleType(businessruleType);

        TargetDatabase targetDatabase = new TargetDatabase(((BigDecimal)details.get("targetdatabaseid")).intValue());
        businessRule.setTargetDatabase(targetDatabase);

        ArrayList<HashMap<String, Object>> targetDatabaseTables = DefinePersistencyService.getInstance().getTargetDatabaseTablesDetails(((BigDecimal)details.get("targetdatabaseid")).intValue());
        for(HashMap<String, Object> tableDetails : targetDatabaseTables)
        {
            TargetDatabaseTable targetDatabaseTable = new TargetDatabaseTable(((BigDecimal) tableDetails.get("targettableid")).intValue(), (String) tableDetails.get("name"));
            businessRule.addTable(targetDatabaseTable);
        }
        return businessRule;
    }
}