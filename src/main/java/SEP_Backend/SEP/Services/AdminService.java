package SEP_Backend.SEP.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SEP_Backend.SEP.Entity.AdminTbl;
import SEP_Backend.SEP.Repository.AdminRepository;
import SEP_Backend.SEP.dtos.Reply;
import SEP_Backend.SEP.dtos.AdminDto;

@Service
public class AdminService {
	@Autowired
    private AdminRepository adminRepository;
    
    public AdminTbl findByEmail(String email) {
        return adminRepository.findByEmail(email);
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
}
