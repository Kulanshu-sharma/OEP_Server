package SEP_Backend.SEP.dtos;

public class AdminDto {
	 private String name;
     private String emailID;
     private String contactNO;
     private String organisationName;
     private String password;
    
         
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmailID() {
			return emailID;
		}
		public void setEmailID(String emailID) {
			this.emailID = emailID;
		}
		public String getContactNO() {
			return contactNO;
		}
		public void setContactNO(String contactNO) {
			this.contactNO = contactNO;
		}
		public String getOrganisationName() {
			return organisationName;
		}
		public void setOrganisationName(String organisationName) {
			this.organisationName = organisationName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
}
