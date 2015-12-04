package com.formation.emergency.domain.pojo;

public class SelectorPredicate {
	private String key;
	
	private String value;
	
	private Operator operator;

	public SelectorPredicate(String key, String value, Operator operator) {
		super();
		this.setKey(key);
		this.setValue(value);
		this.setOperator(operator);
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

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	
}
