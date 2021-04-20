public class Student {
	int id;
	String fullName;
	String firstName;
	String lastName;
	String gender;
	String dob;
	String address;
	String guardianName;
	String cno;
	String occupation;
	String admissionDate;
	String addmissionNo;
	int status;
	
	public Student() {
		
	}
	
	public Student(String fullName, String firstName, String lastName, String gender, String dob, String address,
			String guardianName, String cno, String occupation, String admissionDate, String addmissionNo) {
		super();
		this.fullName = fullName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.guardianName = guardianName;
		this.cno = cno;
		this.occupation = occupation;
		this.admissionDate = admissionDate;
		this.addmissionNo = addmissionNo;
	}
	
	public Student(int id, String fullName, String firstName, String lastName, String gender, String dob, String address,
			String guardianName, String cno, String occupation, String admissionDate, String addmissionNo, int status) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.guardianName = guardianName;
		this.cno = cno;
		this.occupation = occupation;
		this.admissionDate = admissionDate;
		this.addmissionNo = addmissionNo;
		this.status = status;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getDob() {
		return dob;
	}
	
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getGuardianName() {
		return guardianName;
	}
	
	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}
	
	public String getCno() {
		return cno;
	}
	
	public void setCno(String cno) {
		this.cno = cno;
	}
	
	public String getOccupation() {
		return occupation;
	}
	
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public String getAdmissionDate() {
		return admissionDate;
	}
	
	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}
	
	public String getAddmissionNo() {
		return addmissionNo;
	}
	
	public void setAddmissionNo(String addmissionNo) {
		this.addmissionNo = addmissionNo;
	}

	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
