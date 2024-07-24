package SEP_Backend.SEP.Services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import SEP_Backend.SEP.Entity.TestTbl;
import SEP_Backend.SEP.Repository.TestRepository;
import SEP_Backend.SEP.dtos.TestDto;

@Service
public class TestService {
	
	@Autowired
	private TestRepository testRepository;
	
	public List<TestDto> getAllTestsForAdmin(String email) {
		
        List<TestTbl> tests = testRepository.findByAdminTblEmail(email);
        List<TestDto> testDtos = null;
  	
        if (tests != null) {
        	testDtos = new ArrayList<>();
        	for (TestTbl test : tests) {
        		TestDto testDTO = new TestDto();
        		testDTO.setTestID(test.getTest_id());
        		testDTO.setTestName(test.getExam_name());
        		testDTO.setTotalMarks(test.getTotalMarks());
        		testDTO.setApproxQues(test.getApproxQuestion());
        		testDTO.setApproxStudents(test.getApproxStudents());
        		testDTO.setExpDate(test.getExpectedDate());
        		testDTO.setExpTime(test.getExpectedTime());
        		testDTO.setStatus(test.getTestStatus());
        		testDtos.add(testDTO);
        	}
        	
        }
		return testDtos;
     }
}