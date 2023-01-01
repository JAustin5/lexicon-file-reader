// Jalena Austin

// I assert that I have written 100% of this code myself otherwise
// I will receive a 0% grade on this assignment.
//
// Status:
//
// This code is 100% tested and correct

public class LexEntry {
	private String word;
	private String speechTag;
	
	public LexEntry(String word, String speechTag) {
		super();
		this.word = word;
		this.speechTag = speechTag;
	}
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getSpeechTag() {
		return speechTag;
	}
	public void setSpeechTag(String speechTag) {
		this.speechTag = speechTag;
	}

}
