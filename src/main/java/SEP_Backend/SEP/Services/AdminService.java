package SEP_Backend.SEP.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SEP_Backend.SEP.Entity.AdminTbl;
import SEP_Backend.SEP.Entity.TestTbl;
import SEP_Backend.SEP.Repository.AdminRepository;
import SEP_Backend.SEP.Repository.TestRepository;
import SEP_Backend.SEP.dtos.Reply;
import SEP_Backend.SEP.dtos.TestDto;
import SEP_Backend.SEP.dtos.AdminDto;
import SEP_Backend.SEP.dtos.ChangePasswordDto;

@Service
public class AdminService {
	@Autowired
    private AdminRepository adminRepository;
	@Autowired
    private TestRepository testRepository;
	
    
	public AdminTbl findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }
    
    public List<TestTbl> findByAdminTblEmail(String username) {
        return testRepository.findByAdminTblEmail(username);
    }
    
    public void registerUser(AdminDto admindto, Reply reply){
    	if (adminRepository.findByEmail(admindto.getEmailID()) != null) {
            reply.setErrFlag(true);
            reply.setErrMsg("Entered Email Already Registered!!!");
            return;
        }
    	AdminTbl admintbl = new AdminTbl();
    	admintbl.setEmail(admindto.getEmailID());
    	admintbl.setName(admindto.getName());
    	admintbl.setOrg(admindto.getOrganisationName());
    	admintbl.setPhoneno(admindto.getContactNO());
    	admintbl.setPassword(admindto.getPassword());
    	
    	adminRepository.save(admintbl);
    }
    
    
	public TestTbl adminSettings(TestDto testdto, String username) {
    	
		TestTbl testTbl = testRepository.findByTest(testdto.getTestID());
        AdminTbl adminTbl = adminRepository.findByEmail(username);
 
    			testTbl.setTotalMarks(testdto.getTotalMarks());
    			testTbl.setApproxQuestion(testdto.getApproxQues());
    			testTbl.setApproxStudents(testdto.getApproxStudents());
    			testTbl.setExpectedDate(testdto.getExpDate());
    			testTbl.setExpectedTime(testdto.getExpTime());
    			testTbl.setTimeLimit(testdto.getTimeLimit());
    			testTbl.setAdminTbl(adminTbl);
    			return testRepository.save(testTbl);
    	}
	
	public boolean changePassword(ChangePasswordDto changePasswordDto, String username) {
		if (adminRepository.findByEmail(username) != null) {
			AdminTbl admintbl =adminRepository.findByEmail(username);
			admintbl.setPassword(changePasswordDto.getNewPassword());
			adminRepository.save(admintbl);
			return true;
		}
		else {
			return false;
		}
        
	}
}

