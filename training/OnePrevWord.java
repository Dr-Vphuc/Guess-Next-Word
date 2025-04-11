package training;

import java.util.Objects;

public class OnePrevWord implements TuplePrevWords {
	private String currWord = "";
	private String prevWord1 = "";
	
	public OnePrevWord () {}
	public OnePrevWord (String cur) {
		this.currWord = cur;
	}
	public OnePrevWord (String cur , String prev) {
		this.currWord = cur;
		this.prevWord1 = prev;
	}
	
	@Override
	public void setCurrWord(String cur) {
		// TODO Auto-generated method stub
		currWord = cur;
	}
	@Override
	public String getCurrWord() {
		// TODO Auto-generated method stub
		return currWord;
	}
	
	public void setPrevWord(String prev) {
		// TODO Auto-generated method stub
		prevWord1 = prev;
	}
	public String getPrevWord() {
		// TODO Auto-generated method stub
		return prevWord1;
	}
	
	public String toString () {
		return prevWord1 + " " + currWord;
	}
	@Override
	public int compareTo (TuplePrevWords a) {
		OnePrevWord o = (OnePrevWord) a;
		return this.toString().compareTo(o.toString());
	}
	@Override
	public boolean equals (Object o) {
		return this.compareTo((TuplePrevWords)o) == 0;
	}
	@Override
	public int hashCode () {
		return Objects.hash(currWord , prevWord1);
	}
	@Override
	public boolean prevEquals (String s) {
		return (prevWord1).equals(s);
	}
}
