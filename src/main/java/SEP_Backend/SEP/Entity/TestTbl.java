package SEP_Backend.SEP.Entity;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.*;

@Entity
@Table(name = "TEST_DETAILS_TBL")
public class TestTbl {
	
	@Id
	@Column(name = "TEST_ID")
    private int test_id;
	
	@ManyToOne
	@JoinColumn(name = "ADMIN_ID", referencedColumnName = "EMAIL_ID")
	private AdminTbl adminTbl;
	
	@Column(name = "EXAM_NAME")
    private String exam_name;
	
	@Column(name = "TOTAL_MARKS")
    private int totalMarks;
	
	@Column(name = "APPROX_QUESTIONS")
    private int approxQuestion;
	
	@Column(name = "APPROX_STUDENTS")
    private int approxStudents;
	
	@Column(name = "EXPECTED_DATE")
    private Date expectedDate;
	
	@Column(name = "EXPECTED_TIME")
    private Time expectedTime;
	
	@Column(name = "TEST_STATUS")
    private String testStatus;

	public int getTest_id() {
		return test_id;
	}

	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}



	public AdminTbl getAdminTbl() {
		return adminTbl;
	}

	public void setAdminTbl(AdminTbl adminTbl) {
		this.adminTbl = adminTbl;
	}

	public String getExam_name() {
		return exam_name;
	}

	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public int getApproxQuestion() {
		return approxQuestion;
	}

	public void setApproxQuestion(int approxQuestion) {
		this.approxQuestion = approxQuestion;
	}

	public int getApproxStudents() {
		return approxStudents;
	}

	public void setApproxStudents(int approxStudents) {
		this.approxStudents = approxStudents;
	}

	public Date getExpectedDate() {
		return expectedDate;
	}

	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}

	public Time getExpectedTime() {
		return expectedTime;
	}

	public void setExpectedTime(Time expectedTime) {
		this.expectedTime = expectedTime;
	}

	public String getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}

	
	
}
