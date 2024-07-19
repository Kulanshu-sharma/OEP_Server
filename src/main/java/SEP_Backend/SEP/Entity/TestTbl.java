package SEP_Backend.SEP.Entity;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.*;

@Entity
@Table(name = "TEST_DETAILS_TBL")
public class TestTbl {
	
	@Id
	@Column(name = "TEST_ID")
    private long test_id;
	
	@Column(name = "EXAM_NAME")
    private String exam_name;
	
	@Column(name = "TOTAL_MARKS")
    private long total_marks;
	
	@Column(name = "APPROX_QUESTIONS")
    private long approx_question;
	
	@Column(name = "APPROX_STUDENTS")
    private long approx_students;
	
	@Column(name = "EXPECTED_DATE")
    private Date expeted_date;
	
	@Column(name = "EXPECTED_TIME")
    private Time expected_time;
	
	@Column(name = "TEST_STATUS")
    private String test_status;

	public long getTest_id() {
		return test_id;
	}

	public void setTest_id(long test_id) {
		this.test_id = test_id;
	}

	public String getExam_name() {
		return exam_name;
	}

	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}

	public long getTotal_marks() {
		return total_marks;
	}

	public void setTotal_marks(long total_marks) {
		this.total_marks = total_marks;
	}

	public long getApprox_question() {
		return approx_question;
	}

	public void setApprox_question(long approx_question) {
		this.approx_question = approx_question;
	}

	public long getApprox_students() {
		return approx_students;
	}

	public void setApprox_students(long approx_students) {
		this.approx_students = approx_students;
	}

	public Date getExpeted_date() {
		return expeted_date;
	}

	public void setExpeted_date(Date expeted_date) {
		this.expeted_date = expeted_date;
	}

	public Time getExpected_time() {
		return expected_time;
	}

	public void setExpected_time(Time expected_time) {
		this.expected_time = expected_time;
	}

	public String getTest_status() {
		return test_status;
	}

	public void setTest_status(String test_status) {
		this.test_status = test_status;
	}
	
}
