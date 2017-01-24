package domain.defineDomain;

public class BusinessruleType {
    private int businessRuleTypeID;
    private String name;
    private String code;
    private String description;
    private String example;
    private Category category;
    private int numberOfAttributes;
    private int numberOfValues;

    public BusinessruleType(int businessRuleTypeID, String name, String code, String description, String example, Category category, int numberOfAttributes, int numberOfValues) {
        this.businessRuleTypeID = businessRuleTypeID;
        this.name = name;
        this.code = code;
        this.description = description;
        this.example = example;
        this.category = category;
        this.numberOfAttributes = numberOfAttributes;
        this.numberOfValues = numberOfValues;
    }

    public int getBusinessRuleTypeID() {
        return businessRuleTypeID;
    }

    public void setBusinessRuleTypeID(int businessRuleTypeID) {
        this.businessRuleTypeID = businessRuleTypeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getNumberOfAttributes() {
        return numberOfAttributes;
    }

    public void setNumberOfAttributes(int numberOfAttributes) {
        this.numberOfAttributes = numberOfAttributes;
    }

    public int getNumberOfValues() {
        return numberOfValues;
    }

    public void setNumberOfValues(int numberOfValues) {
        this.numberOfValues = numberOfValues;
    }

    @Override
    public String toString() {
        return "BusinessruleType{" +
                "businessRuleTypeID=" + businessRuleTypeID +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", example='" + example + '\'' +
                ", category=" + category +
                ", numberOfAttributes=" + numberOfAttributes +
                ", numberOfValues=" + numberOfValues +
                '}';
    }
}
