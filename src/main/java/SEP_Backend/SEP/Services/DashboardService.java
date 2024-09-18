package SEP_Backend.SEP.Services;


import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SEP_Backend.SEP.Entity.AdminTbl;
import SEP_Backend.SEP.Entity.TestTbl;
import SEP_Backend.SEP.Repository.AdminRepository;
import SEP_Backend.SEP.Repository.TestRepository;


@Service
public class DashboardService {
	
	@Autowired
	private TestRepository testRepository;
	@Autowired
	private AdminRepository adminRepository;
	public Dictionary<String, String> dashboardAdminData(String email) {
		
		AdminTbl admin = adminRepository.findByEmail(email);
		
		Dictionary<String, String> AdminData = new Hashtable<>();
		if (admin != null) {
			String name = admin.getName() != null ? admin.getName() : "Unknown";
		    String adminemail = admin.getEmail() != null ? admin.getEmail() : "No email";
		    String phoneno = admin.getPhoneno() != null ? admin.getPhoneno() : "No phone number";
		    AdminData.put("Name", name);
		    AdminData.put("Email",adminemail);
		    AdminData.put("PhoneNo", phoneno);
		
		}
		return AdminData;
	}
	
	public Dictionary<String, Integer> dashboardData(String email) {
		
		Dictionary<String, Integer> Data = new Hashtable<>();
		Data.put("Draft", 0);
		Data.put("Scheduled", 0);
		Data.put("Result Awaited", 0);
		Data.put("Completed", 0);
		Data.put("Live", 0);
		List<TestTbl> tests = testRepository.findByAdminTblEmail(email);
		if (tests != null) {
	        	for (TestTbl test : tests) {
	        		if ("Draft".equals(test.getTestStatus())){
	        			updateValue(Data,"Draft");
	        		}
	        		if ("Complete".equals(test.getTestStatus())){
	        			updateValue(Data,"Completed");
	        		}
	        		
	        	}
	    }
		return Data;
	}
	public static void updateValue(Dictionary<String, Integer> Data, String key) {
        if (Data.get(key) != null) {
            int newValue = Data.get(key) + 1;
            Data.put(key, newValue);
        }
	}
}
