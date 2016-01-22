package com.formation.emergency.domain.pojo;

public class SelectorPredicate {

	private String key;
	private String value;
	private PredicateOperator operator;
	
	public SelectorPredicate() {
		super();
	}
	public SelectorPredicate(String key, String value, PredicateOperator operator) {
		super();
		this.key = key;
		this.value = value;
		this.operator = operator;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public PredicateOperator getOperator() {
		return operator;
	}
	public void setOperator(PredicateOperator operator) {
		this.operator = operator;
	}
}
