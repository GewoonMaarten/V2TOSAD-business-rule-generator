package domain.defineDomain;

import data.definePersistency.facade.DefinePersistencyService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class TargetDatabaseTable
{
    private int targettableid;
    private String name;
    private ArrayList<TargetDatabaseAttribute> targetDatabaseAttributes;

    public TargetDatabaseTable(int targettableid, String name) {
        this.targettableid = targettableid;
        this.name = name;
        this.targetDatabaseAttributes = new ArrayList<TargetDatabaseAttribute>();

        ArrayList<HashMap<String,Object>> attributesDetails = DefinePersistencyService.getInstance().getTargetDatabaseTableAttributeDetails(targettableid);
        for(HashMap<String, Object> attributeDetails : attributesDetails)
        {
            this.addAttribute(new TargetDatabaseAttribute(((BigDecimal)attributeDetails.get("targetattributeid")).intValue(),
                    (String)attributeDetails.get("name"), (String)attributeDetails.get("type")));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAttribute(TargetDatabaseAttribute attribute)
    {
        this.targetDatabaseAttributes.add(attribute);
    }
}