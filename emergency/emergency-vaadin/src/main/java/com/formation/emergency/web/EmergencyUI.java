package com.formation.emergency.web;

import java.util.ResourceBundle;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.formation.emergency.web.views.EquipementFormView;
import com.formation.emergency.web.views.PatientFormView;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Component;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;

@SpringUI
@Theme("emergency")
@Transactional
@PreserveOnRefresh
public class EmergencyUI extends UI {

	@Autowired
	EquipementFormView equipementFormView;
	@Autowired
	PatientFormView patientFormView;
	Navigator navigator;
	ResourceBundle labels;
	
	@Override
	protected void init(VaadinRequest request) {
		labels = ResourceBundle.getBundle("message", getLocale());
		
		VerticalLayout root = new VerticalLayout();
		
		VerticalLayout header = new VerticalLayout();
		header.setStyleName("header");
		root.addComponent(header);
		
		VerticalLayout content = new VerticalLayout();
		content.setStyleName("content");
		root.addComponent(content);
		
		navigator = new Navigator(this, content);
		navigator.addView(MenuSite.ACCUEIL.name(), patientFormView);
		navigator.addView(MenuSite.LOGISTIQUE.name(), equipementFormView);
		navigator.navigateTo(MenuSite.LOGISTIQUE.name());
		
		VerticalLayout footer = new VerticalLayout();
		footer.setStyleName("footer");
		root.addComponent(footer);
		
		header.addComponent(getMenu());
		
		setContent(root);
	}
	
	private Component getMenu(){
		MenuBar menubar = new MenuBar();
		
		menubar.addItem(labels.getString(MenuSite.ACCUEIL.getKeyLabel()), FontAwesome.HOSPITAL_O, new Command() {
			
			@Override
			public void menuSelected(MenuItem selectedItem) {
				navigator.navigateTo(MenuSite.ACCUEIL.name());
			}
		});
		
		menubar.addItem(labels.getString(MenuSite.LOGISTIQUE.getKeyLabel()), FontAwesome.AMBULANCE, new Command() {
			
			@Override
			public void menuSelected(MenuItem selectedItem) {
				navigator.navigateTo(MenuSite.LOGISTIQUE.name());
			}
		});
		
		return menubar;
	}

}
