package SEP_Backend.SEP.dtos;

import java.sql.Date;
import java.sql.Time;

public class TestDto {
	private Long testID;
	private String testName;
	private int totalMarks;
	private int approxQues;
	private int approxStudents;
	private Date expDate;
	private Time expTime;
	private String status;
	private String timeLimit;
	
	public Long getTestID() {
		return testID;
	}
	public void setTestID(Long testID) {
		this.testID = testID;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public int getApproxQues() {
		return approxQues;
	}
	public void setApproxQues(int approxQues) {
		this.approxQues = approxQues;
	}
	public int getApproxStudents() {
		return approxStudents;
	}
	public void setApproxStudents(int approxStudents) {
		this.approxStudents = approxStudents;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public Time getExpTime() {
		return expTime;
	}
	public void setExpTime(Time expTime) {
		this.expTime = expTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}
}
	
	