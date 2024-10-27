package SEP_Backend.SEP.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import SEP_Backend.SEP.Entity.AdminTbl;
import SEP_Backend.SEP.Entity.TestTbl;
import SEP_Backend.SEP.Repository.TestRepository;
import SEP_Backend.SEP.Repository.AdminRepository;
import SEP_Backend.SEP.dtos.TestDto;
import SEP_Backend.SEP.dtos.Reply;

@Service
public class ScheduledTestService {
	
	 @Autowired
	 private TestRepository testRepository;
	 @Autowired
	 private AdminRepository adminRepository;
	 
	 public Reply executeTest(TestDto testdto, String username) {
		 	TestTbl testTbl = testRepository.findByTest(testdto.getTestID());
		 	AdminTbl adminTbl = adminRepository.findByEmail(username);
	        Reply reply = new Reply();
	        reply.setAllowed(true);
	        reply.setMessage("Test is Ready to Execute");
	        reply.setErrFlag(false);
	        testTbl.setTestStatus("Scheduled");
	        testTbl.setAdminTbl(adminTbl);
        	testTbl = testRepository.save(testTbl);
	  return reply;
	 }
}
