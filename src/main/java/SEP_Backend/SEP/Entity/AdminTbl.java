package SEP_Backend.SEP.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ADMIN_DETAILS")
public class AdminTbl {
	 
	    @Id
	    @Column(name = "EMAIL_ID")
	    private String email;
	    
	    @Column(name = "PASSWORD")
	    private String password;
	    
	    @Column(name = "NAME")
	    private String name;
	    
	    @Column(name = "PHONE_NO")
	    private String phoneno;
	    
	    @Column(name = "ORGANISATION")
	    private String org;

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPhoneno() {
			return phoneno;
		}

		public void setPhoneno(String phoneno) {
			this.phoneno = phoneno;
		}

		public String getOrg() {
			return org;
		}

		public void setOrg(String org) {
			this.org = org;
		}
	  

		
	    
}


