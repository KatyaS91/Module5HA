package data;

/**
 * Created by Katsiaryna_Skarzhyns on 12/18/2017.
 */
public enum  TestData {

	URL("https://mail.google.com"),
	LOGIN("berezhkov.agm@gmail.com"), //berezhkov.agm@gmail.com
	PASSWORD("berezhkovMm8");

	private String value;

	TestData(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
