package SEP_Backend.SEP.dtos;

import java.util.List;

public class QuestionDto {
	
		private Long testId;
		private int quesType;
	    private String quesDescription;
	    private int marks;
	    private int optionsCount;
	    private List<OptionDto> options;
	    private int correctOptionId; 
	    private String ansDescription; 
	    private List<Long> correctOptionIds; 
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
		public int getCorrectOptionId() {
			return correctOptionId;
		}
		public void setCorrectOptionId(int correctOptionId) {
			this.correctOptionId = correctOptionId;
		}
		public String getAnsDescription() {
			return ansDescription;
		}
		public void setAnsDescription(String ansDescription) {
			this.ansDescription = ansDescription;
		}
		public List<Long> getCorrectOptionIds() {
			return correctOptionIds;
		}
		public void setCorrectOptionIds(List<Long> correctOptionIds) {
			this.correctOptionIds = correctOptionIds;
		}

	   
	
}
	