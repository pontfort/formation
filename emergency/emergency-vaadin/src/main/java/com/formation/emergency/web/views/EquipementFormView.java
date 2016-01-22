package com.formation.emergency.web.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.formation.emergency.business.ILogistique;
import com.formation.emergency.domain.pojo.Equipement;
import com.formation.emergency.exception.IndisponibiliteException;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.SelectionEvent;
import com.vaadin.event.SelectionEvent.SelectionListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;

@Component
public class EquipementFormView extends VerticalLayout implements View {
	
	private BeanItemContainer<Equipement> container;
	private ILogistique logistique;
	private BeanFieldGroup<Equipement> fieldGroup;
	private Equipement equipement;
	
	TextField reference = new TextField("Reference : ");
	ComboBox paysOrigine = new ComboBox("Pays Origine : ");
	DateField dateAchat = new DateField("Date Achat : ");
	TextField prix = new TextField("Prix : ");
	
	@Autowired
	public EquipementFormView(ILogistique logistique) {
		container = new BeanItemContainer<Equipement>(Equipement.class);
		this.logistique = logistique;
		container.addAll(logistique.getAll());
		buildForm();
		buildView();
	}
	
	

	private void buildView() {
		Grid grid = new Grid();
		addComponent(grid);
		grid.setContainerDataSource(container);
		grid.addSelectionListener(new SelectionListener() {
			
			@Override
			public void select(SelectionEvent event) {
				fieldGroup.setItemDataSource((Equipement) grid.getSelectedRow());
			}
		});
	}
	
	private void buildForm() {
		VerticalLayout vertical = new VerticalLayout();
		
		
		
		
		
		
		
		
		
		
		
		
		
		reference.setImmediate(true);
		addComponent(reference);
		paysOrigine.setImmediate(true);
		paysOrigine.addItem("france");
		paysOrigine.addItem("italie");
		paysOrigine.addItem("allemagne");
		paysOrigine.select("italie");
		addComponent(paysOrigine);
		dateAchat.setImmediate(true);
		addComponent(dateAchat);
		prix.setImmediate(true);
		addComponent(prix);
		
		fieldGroup = new BeanFieldGroup<Equipement>(Equipement.class);
		fieldGroup.setItemDataSource(equipement);
		fieldGroup.bindMemberFields(this);
		
		Button ajouter = new Button("Ajouter");
		ajouter.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				/*
				equipement.setReference(reference.getValue());
				equipement.setPaysOrigine((String)paysOrigine.getValue());
				equipement.setDateAchat(dateAchat.getValue());
				equipement.setPrix(Integer.parseInt(prix.getValue()));
				container.addBean(equipement);
				try {
					logistique.acheterReparer(equipement);
				} catch (Exception e) {
					e.printStackTrace();
				}*/
			}
		});
		addComponent(ajouter);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		
	}
}
