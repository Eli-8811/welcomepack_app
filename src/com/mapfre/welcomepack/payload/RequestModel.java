package com.mapfre.welcomepack.payload;

import java.util.List;

public class RequestModel {

    private String attributes;
    private String documentType;
    private List<Condition> conditions;
    
    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public static class Condition {
        private String attribute;
        private String operator;
        private Value value;
        private String connector;
        public String getAttribute() {
            return attribute;
        }
        public void setAttribute(String attribute) {
            this.attribute = attribute;
        }
        public String getOperator() {
            return operator;
        }
        public void setOperator(String operator) {
            this.operator = operator;
        }
        public Value getValue() {
            return value;
        }
        public void setValue(Value value) {
            this.value = value;
        }
        public String getConnector() {
            return connector;
        }
        public void setConnector(String connector) {
            this.connector = connector;
        }
    }

    public static class Value {
        private String value;
        private Object objectQuery;
        private boolean isQuery;
        public String getValue() {
            return value;
        }
        public void setValue(String value) {
            this.value = value;
        }
        public Object getObjectQuery() {
            return objectQuery;
        }
        public void setObjectQuery(Object objectQuery) {
            this.objectQuery = objectQuery;
        }
        public boolean isQuery() {
            return isQuery;
        }
        public void setQuery(boolean isQuery) {
            this.isQuery = isQuery;
        }
    }
    
}
