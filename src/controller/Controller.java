package controller;

import gui.FormDataObject;
import model.AgeCategory;
import model.Database;
import model.EmploymentCategory;
import model.Gender;
import model.Person;

public class Controller {

	Database db = new Database();

	public void addPerson(FormDataObject dataObject) {
		String name = dataObject.getName();
		String occupation = dataObject.getOccupation();
		int ageCat = dataObject.getAgeCategory();
		String empCat = dataObject.getEmpCat();
		boolean isUs = dataObject.isUsCitizen();
		String taxId = dataObject.getTaxId();
		String gender = dataObject.getGender();
		
		AgeCategory ageCategory;
		
		switch(ageCat) {
		case 0:
			ageCategory = AgeCategory.child;
			break;
		case 1:
			ageCategory = AgeCategory.adult;
			break;
		case 2:
			ageCategory = AgeCategory.senior;
			break;
		default:
			ageCategory = null;
		}
		
		EmploymentCategory employmentCategory;
		
		if (empCat.equals("employed")) {
			employmentCategory = EmploymentCategory.employed;
		} else if (empCat.equals("unemployed")) {
			employmentCategory = EmploymentCategory.unemployed;
		} else if (empCat.equals("selfemployed")) {
			employmentCategory = EmploymentCategory.selfEmployed;
		} else {
			employmentCategory = EmploymentCategory.other;
			System.err.println(empCat);
		}
		
		Gender genderCat;
		
		if(gender.equals("male")) {
			genderCat = Gender.male;
		} else {
			genderCat = Gender.female;
		}
		
		Person person = new Person(name, occupation, ageCategory, employmentCategory, 
				taxId, isUs, genderCat);
		
		db.addPerson(person);
	}
}
