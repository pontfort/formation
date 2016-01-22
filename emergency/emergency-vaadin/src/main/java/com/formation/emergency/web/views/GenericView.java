package com.formation.emergency.web.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

public class GenericView<T> extends VerticalLayout implements View {

	private static final long serialVersionUID = 1L;
	
	private T t;
	
	public GenericView() {
		buildForm();
	}
	
	private void buildForm() {
		//Field
	}

	@Override
	public void enter(ViewChangeEvent event) {
		
	}

	public Class getMaClass() {
		return t.getClass();
	}

}
