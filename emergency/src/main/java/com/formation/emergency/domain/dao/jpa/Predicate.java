package com.formation.emergency.domain.dao.jpa;

public class Predicate {
	
	private String fieldName;
	private Object fieldValue;
	private OperatorPredicate operator;
	
	public Predicate() {	
	}

	public Predicate(String fieldName, Object fieldValue, OperatorPredicate operator) {
		this();
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		this.operator = operator;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}

	public OperatorPredicate getOperator() {
		return operator;
	}

	public void setOperator(OperatorPredicate operator) {
		this.operator = operator;
	}
	
	

}
