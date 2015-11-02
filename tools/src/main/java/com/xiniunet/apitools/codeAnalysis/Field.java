package com.xiniunet.apitools.codeAnalysis;

/**
 * Created by edward on 11/25/14.
 */
public class Field {
    private String name = "";
    private String type = "";
    private String description = "";
    private Boolean isDomain = false;
    private Boolean isEnum = false; // 是否为枚举型
    private String ctype = ""; //转换为C++类型
    private String astype = ""; //C++ astype
    private String iostype = ""; //转换为ios类型
    private String iostypeValue = "";
    private String parentName = "null";
    private String domainName = "null";

    public Boolean getIsLength() {
        return isLength;
    }

    public void setIsLength(Boolean isLength) {
        this.isLength = isLength;
    }

    private Boolean isNotNull = false;
    private Boolean isLength = false;
    private String minLength = "";
    private String maxLength = "";

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    private String declare = "";
    private String comment = "";

    public String getName() {
        return name;
    }

    public void setIsDomain(Boolean isDomain) {
        this.isDomain = isDomain;
    }

    public String getDeclare() {
        return declare;
    }

    public String getMinLength() {
        return minLength;
    }

    public void setMinLength(String minLength) {
        this.minLength = minLength;
    }

    public String getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(String maxLength) {
        this.maxLength = maxLength;
    }

    public void setDeclare(String declare) {
        this.declare = declare;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public Boolean getIsDomain() {
        return !(this.getType().equalsIgnoreCase("String")
                || this.getType().equalsIgnoreCase("Boolean")
                || this.getType().equalsIgnoreCase("Long")
                || this.getType().equalsIgnoreCase("Date")
                || this.getType().equalsIgnoreCase("Integer")
                || this.getType().equalsIgnoreCase("int")
                || this.getType().equalsIgnoreCase("float")
                || this.getType().equalsIgnoreCase("double")
                || this.getType().equalsIgnoreCase("char")
                || this.getType().equalsIgnoreCase("Character")
                || this.getType().equalsIgnoreCase("byte")
                || this.getType().equalsIgnoreCase("short"));
    }

    public Boolean getIsNotNull() {
        return isNotNull;
    }

    public void setIsNotNull(Boolean isNotNull) {
        this.isNotNull = isNotNull;
    }

    public Boolean getIsEnum() {
        return this.getType().endsWith("Enum");
    }

    public void setIsEnum(Boolean isEnum) {
        this.isEnum = isEnum;
    }

    public String getCtype() {
        if(!isDomain){
            // 基本型转换
            if(this.type.equalsIgnoreCase("string")){
                return "string";
            }
            if(this.type.toLowerCase().trim().equals("boolean")){
                return "bool";
            }
            if(this.type.equalsIgnoreCase("long")){
                return "long long";
            }
            if(this.type.equalsIgnoreCase("int")||this.type.equalsIgnoreCase("Integer")){
                return "int";
            }
            if(this.type.equalsIgnoreCase("date")){
                return "unsigned long long";
            }
            if(this.type.equalsIgnoreCase("short")){
                return "short";
            }
            if(this.type.toLowerCase().trim().equals("double")){
                return "double";
            }
        }
        return this.type;
    }


    public String getAstype() {
        if(!isDomain){
            // 基本型转换
            if(this.type.equalsIgnoreCase("string")){
                return "asString";
            }
            if(this.type.toLowerCase().trim().equals("boolean")){
                return "asBool";
            }
            if(this.type.equalsIgnoreCase("long")){
                return "asInt64";
            }
            if(this.type.equalsIgnoreCase("int")||this.type.equalsIgnoreCase("Integer")){
                return "asInt";
            }
            if(this.type.equalsIgnoreCase("date")){
                return "asUInt64";
            }
            if(this.type.equalsIgnoreCase("short")){
                return "asShort";
            }
            if(this.type.equalsIgnoreCase("double")){
                return "asDouble";
            }
        }
        return  this.type;
    }

    public String getIostype() {
        if(!isDomain){
            if(this.type.contains("<")) {
                this.type = this.type.split("<")[0];
            }
            // 基本型转换
            if(this.type.equalsIgnoreCase("string")){
                return "NSString*";
            } else if(this.type.toLowerCase().trim().equals("boolean")){
                return "BOOL";
            } else if(this.type.equalsIgnoreCase("long")){
                return "UInt64";
            } else if(this.type.equalsIgnoreCase("int")||this.type.equalsIgnoreCase("Integer")){
                return "NSInteger";
            } else if(this.type.equalsIgnoreCase("date")){
                return "NSString*";
            } else if(this.type.equalsIgnoreCase("short")){
                return "NSInteger";
            } else if(this.type.equalsIgnoreCase("double")){
                return "float";
            } else if(this.type.equals("List") || this.type.equals("ArrayList") || this.type.equals("LinkedList")) {
                return "NSArray*";
            } else if(this.type.equals("Map") || this.type.equals("HashMap")) {
                return "NSDictionary*";
            } else if(this.type.endsWith("Enum")) {
                return "NSString*";
            }
        }
        return this.type;
    }



    public String getIostypeValue() {
        if(!isDomain){
            if(this.type.contains("<")) {
                this.type = this.type.split("<")[0];
            }
            // 基本型转换
            if(this.type.equalsIgnoreCase("string")){
                return "string";
            } else if(this.type.toLowerCase().trim().equals("boolean")){
                return "bool";
            } else if(this.type.equalsIgnoreCase("long")){
                return "longLong";
            } else if(this.type.equalsIgnoreCase("int")||this.type.equalsIgnoreCase("Integer")){
                return "integer";
            } else if(this.type.equalsIgnoreCase("date")){
                return "NSString";
            } else if(this.type.equalsIgnoreCase("short")){
                return "integer";
            } else if(this.type.equalsIgnoreCase("double")){
                return "float";
            } else if(this.type.equals("List") || this.type.equals("ArrayList") || this.type.equals("LinkedList")) {
                return "to";
            } else if(this.type.equals("Map") || this.type.equals("HashMap")) {
                return "to";
            } else if(this.type.endsWith("Enum")) {
                return "string";
            }
        }
        return this.type;
    }
    public void print() {
        System.out.println("字段:" + this.getName() + "[" + this.getType() + "]," + this.getDescription()
                        + ",IsDomain=" + this.getIsDomain().toString()
                        + ",NotNull=" + this.getIsNotNull().toString()
                        + ",min=" + this.getMinLength().toString()
                        + ",max=" + this.getMaxLength().toString()
                     //   + ",comment=" + this.getComment().toString()
                      //  + ",declare=" + this.getDeclare().toString()
        );
    }
}
