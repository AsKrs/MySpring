package pj1.dto;

import java.util.Objects;

public class ResultDto {

	@Override
	public int hashCode() {
		return Objects.hash(memEmail, resultBlood, resultDate, resultDiges, resultEyes, resultIdx, resultLiver,
				resultSave, resultUser, resultVitamin);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultDto other = (ResultDto) obj;
		return Objects.equals(memEmail, other.memEmail) && resultBlood == other.resultBlood
				&& Objects.equals(resultDate, other.resultDate) && resultDiges == other.resultDiges
				&& resultEyes == other.resultEyes && resultIdx == other.resultIdx && resultLiver == other.resultLiver
				&& Objects.equals(resultSave, other.resultSave) && Objects.equals(resultUser, other.resultUser)
				&& resultVitamin == other.resultVitamin;
	}
	
	
	@Override
	public String toString() {
		return "ResultDto [resultIdx=" + resultIdx + ", memEmail=" + memEmail + ", resultUser=" + resultUser
				+ ", resultDate=" + resultDate + ", resultLiver=" + resultLiver + ", resultEyes=" + resultEyes
				+ ", resultVitamin=" + resultVitamin + ", resultBlood=" + resultBlood + ", resultDiges=" + resultDiges
				+ ", resultSave=" + resultSave + ", hashCode()=" + hashCode() + ", getResultIdx()=" + getResultIdx()
				+ ", getMemEmail()=" + getMemEmail() + ", getResultUser()=" + getResultUser() + ", getResultDate()="
				+ getResultDate() + ", getResultLiver()=" + getResultLiver() + ", getResultEyes()=" + getResultEyes()
				+ ", getResultVitamin()=" + getResultVitamin() + ", getResultBlood()=" + getResultBlood()
				+ ", getResultDiges()=" + getResultDiges() + ", getResultSave()=" + getResultSave() + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}


	private int resultIdx;
	private String memEmail;
	private String resultUser;
	private String resultDate;
	private int resultLiver;
	private int resultEyes;
	private int resultVitamin;
	private int resultBlood;
	private int resultDiges;
	private String resultSave;


	
	
	public int getResultIdx() {
		return resultIdx;
	}
	public void setResultIdx(int resultIdx) {
		this.resultIdx = resultIdx;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public String getResultUser() {
		return resultUser;
	}
	public void setResultUser(String resultUser) {
		this.resultUser = resultUser;
	}
	public String getResultDate() {
		return resultDate;
	}
	public void setResultDate(String resultDate) {
		this.resultDate = resultDate;
	}
	public int getResultLiver() {
		return resultLiver;
	}
	public void setResultLiver(int resultLiver) {
		this.resultLiver = resultLiver;
	}
	public int getResultEyes() {
		return resultEyes;
	}
	public void setResultEyes(int resultEyes) {
		this.resultEyes = resultEyes;
	}
	public int getResultVitamin() {
		return resultVitamin;
	}
	public void setResultVitamin(int resultVitamin) {
		this.resultVitamin = resultVitamin;
	}
	public int getResultBlood() {
		return resultBlood;
	}
	public void setResultBlood(int resultBlood) {
		this.resultBlood = resultBlood;
	}
	public int getResultDiges() {
		return resultDiges;
	}
	public void setResultDiges(int resultDiges) {
		this.resultDiges = resultDiges;
	}
	public String getResultSave() {
		return resultSave;
	}
	public void setResultSave(String resultSave) {
		this.resultSave = resultSave;
	}
	

}