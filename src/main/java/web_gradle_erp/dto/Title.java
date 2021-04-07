package web_gradle_erp.dto;

public class Title {
	public int titleNo;
	public String titleName;

	public Title() {
	}

	public Title(int titleNo) {
		this.titleNo = titleNo;
	}

	public Title(int titleNo, String titleName) {
		this.titleNo = titleNo;
		this.titleName = titleName;
	}

	public int getTitleNo() {
		return titleNo;
	}

	public void setTitleNo(int titleNo) {
		this.titleNo = titleNo;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	@Override
	public String toString() {
		return "Title [titleNo=" + titleNo + ", titleName=" + titleName + "]";
	}



}
