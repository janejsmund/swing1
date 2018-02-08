package model;

public class Person {
	
	private static int count = 0;
	private String name, occupation, taxId;
	private int id;
	private boolean usCitizen;
	private AgeCategory ageCategory;
	private EmploymentCategory empCat;
	private Gender gender;

	public Person(String name, String occupation, AgeCategory ageCategory, EmploymentCategory employmentCategory,
			String taxId, boolean usCitizen, Gender gender) {
		setName(name);
		setOccupation(occupation);
		setAgeCategory(ageCategory);
		setEmpCat(employmentCategory);
		setTaxId(taxId);
		setUsCitizen(usCitizen);
		setGender(gender);
		
		setId(count++);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isUsCitizen() {
		return usCitizen;
	}

	public void setUsCitizen(boolean usCitizen) {
		this.usCitizen = usCitizen;
	}

	public AgeCategory getAgeCategory() {
		return ageCategory;
	}

	public void setAgeCategory(AgeCategory ageCategory) {
		this.ageCategory = ageCategory;
	}

	public EmploymentCategory getEmpCat() {
		return empCat;
	}

	public void setEmpCat(EmploymentCategory empCat) {
		this.empCat = empCat;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}
