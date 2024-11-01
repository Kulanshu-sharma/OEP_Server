package SEP_Backend.SEP.Entity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "TEST_DETAILS_TBL")
public class TestTbl {
	
	@Id
	@Column(name = "TEST_ID")
    private Long test;
	
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
	
	@Column(name = "TIME_LIMIT")
	private String timeLimit;
	
	@OneToMany(mappedBy = "testTbl")
	@Column(name="QUESTION_TBL")
    private List<QuestionTbl> questions;

	
	public Long getTest() {
		return test;
	}

	public void setTest(Long test) {
		this.test = test;
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

	public String getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}

	public List<QuestionTbl> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionTbl> questions) {
		this.questions = questions;
	}
}

