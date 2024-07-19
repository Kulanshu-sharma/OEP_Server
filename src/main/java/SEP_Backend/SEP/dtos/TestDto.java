package SEP_Backend.SEP.dtos;

import java.sql.Date;
import java.sql.Time;

public class TestDto {
	private String testName;
	private long totalMarks;
	private long approxQues;
	private long approxStudents;
	private Date expDate;
	private Time expTime;
	
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public long getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(long totalMarks) {
		this.totalMarks = totalMarks;
	}
	public long getApproxQues() {
		return approxQues;
	}
	public void setApproxQues(long approxQues) {
		this.approxQues = approxQues;
	}
	public long getApproxStudents() {
		return approxStudents;
	}
	public void setApproxStudents(long approxStudents) {
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
	
	
}
	
	