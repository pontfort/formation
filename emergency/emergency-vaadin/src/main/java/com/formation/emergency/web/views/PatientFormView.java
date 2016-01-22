package com.formation.emergency.web.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.formation.emergency.business.IAccueil;
import com.formation.emergency.domain.pojo.Adresse;
import com.formation.emergency.domain.pojo.EtatPatient;
import com.formation.emergency.domain.pojo.Patient;
import com.formation.emergency.exception.RechercheException;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.SelectionEvent;
import com.vaadin.event.SelectionEvent.SelectionListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification.Type;

@Component
public class PatientFormView extends VerticalLayout implements View {
	
	private BeanItemContainer<Patient> container;
	private IAccueil accueil;
	private BeanFieldGroup<Patient> fieldGroupPatient;
	private BeanFieldGroup<Adresse> fieldGroupAdresse;
	private Patient patient;
	private Adresse adresse;
	
	TextField nom = new TextField("Nom : ");
	TextField prenom = new TextField("Prénom : ");
	DateField dateNaissance = new DateField("Date Naissance : ");
	TextField numeroSecu = new TextField("Numero SécuSO : ");
	ComboBox etat = new ComboBox("Etat Patient : ");
	
	TextField adresse1 = new TextField("Adresse1 : ");
	TextField adresse2 = new TextField("Adresse2 : ");
	ComboBox ville = new ComboBox("Ville : ");
	TextField codePostal = new TextField("Code Postal : ");
	
	@Autowired
	public PatientFormView(IAccueil accueil) {
		container = new BeanItemContainer<Patient>(Patient.class);
		this.accueil = accueil;
		container.addAll(accueil.getAll());
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
				fieldGroupPatient.setItemDataSource((Patient) grid.getSelectedRow());
			}
		});
	}

	private void buildForm() {
		addComponent(nom);
		addComponent(prenom);
		addComponent(dateNaissance);
		addComponent(numeroSecu);
		etat.addItem(EtatPatient.DOIT_CONSULTER);
		etat.addItem(EtatPatient.MORT);
		etat.addItem(EtatPatient.NOUVEAU_NE);
		etat.addItem(EtatPatient.RENTRE_CHEZ_LUI);
		addComponent(etat);
		
		addComponent(adresse1);
		addComponent(adresse2);
		ville.addItem("Paris");
		ville.addItem("Toulouse");
		ville.addItem("Montpellier");
		ville.addItem("Bordeaux");
		ville.select("Toulouse");
		addComponent(ville);
		addComponent(codePostal);
		
		fieldGroupPatient = new BeanFieldGroup<Patient>(Patient.class);
		fieldGroupPatient.setItemDataSource(patient);
		fieldGroupPatient.bindMemberFields(this);
		
		fieldGroupAdresse = new BeanFieldGroup<Adresse>(Adresse.class);
		fieldGroupAdresse.setItemDataSource(adresse);
		fieldGroupAdresse.bindMemberFields(this);
		
		Button ajouter = new Button("Receptionner");
		ajouter.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				Notification.show(nom.getValue().concat(" ").concat(prenom.getValue()).concat(" receptionné."), Type.WARNING_MESSAGE);
				Patient bean = new Patient();
				
				Adresse adresse = new Adresse();
				adresse.setLibelle1(adresse1.getValue());
				adresse.setLibelle2(adresse2.getValue());
				adresse.setCodePostal(Integer.parseInt(codePostal.getValue()));
				adresse.setVille((String)ville.getValue());
				
				bean.setAdresse(adresse);
				bean.setEtat((EtatPatient)etat.getValue());
				bean.setNom(nom.getValue());
				bean.setPrenom(prenom.getValue());
				bean.setNumeroSecu(numeroSecu.getValue());
				bean.setDateNaissance(dateNaissance.getValue());
				container.addBean(bean);
				try {
					accueil.receptionner(bean);
				} catch (RechercheException e) {
					e.printStackTrace();
				}

			}
		});
		addComponent(ajouter);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		
	}
}
