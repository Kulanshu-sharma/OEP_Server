package SEP_Backend.SEP.dtos;

import java.util.List;

public class QuestionDto {
	
		private Long testId;
		private int quesType;
	    private String quesDescription;
	    private int marks;
	    private int optionsCount;
	    private List<OptionDto> options;
	    private int correctOptionNumber; 
	    private String ansDescription; 
	    private List<Long> correctOptionNumbers; 
		public Long getTestId() {
			return testId;
		}
		public void setTestId(Long testId) {
			this.testId = testId;
		}
		public int getQuesType() {
			return quesType;
		}
		public void setQuesType(int quesType) {
			this.quesType = quesType;
		}
		public String getQuesDescription() {
			return quesDescription;
		}
		public void setQuesDescription(String quesDescription) {
			this.quesDescription = quesDescription;
		}
		public int getMarks() {
			return marks;
		}
		public void setMarks(int marks) {
			this.marks = marks;
		}
		public int getOptionsCount() {
			return optionsCount;
		}
		public void setOptionsCount(int optionsCount) {
			this.optionsCount = optionsCount;
		}
		public List<OptionDto> getOptions() {
			return options;
		}
		public void setOptions(List<OptionDto> options) {
			this.options = options;
		}
		public int getCorrectOptionNumber() {
			return correctOptionNumber;
		}
		public void setCorrectOptionNumber(int correctOptionNumber) {
			this.correctOptionNumber = correctOptionNumber;
		}
		public String getAnsDescription() {
			return ansDescription;
		}
		public void setAnsDescription(String ansDescription) {
			this.ansDescription = ansDescription;
		}
		public List<Long> getCorrectOptionNumbers() {
			return correctOptionNumbers;
		}
		public void setCorrectOptionNumbers(List<Long> correctOptionNumbers) {
			this.correctOptionNumbers = correctOptionNumbers;
		}
		

	   
	
}
	