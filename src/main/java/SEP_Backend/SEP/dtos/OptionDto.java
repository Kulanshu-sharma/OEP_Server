package SEP_Backend.SEP.dtos;

public class OptionDto {
	private Long optionID;
	private String optionDes;
	private int optionNumber;
	
	public int getOptionNumber() {
		return optionNumber;
	}
	public void setOptionNumber(int optionNumber) {
		this.optionNumber = optionNumber;
	}
	
	public Long getOptionID() {
		return optionID;
	}
	public void setOptionID(Long optionID) {
		this.optionID = optionID;
	}
	public String getOptionDes() {
		return optionDes;
	}
	public void setOptionDes(String optionDes) {
		this.optionDes = optionDes;
	}
}
