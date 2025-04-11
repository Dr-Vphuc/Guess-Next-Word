package training;

import java.util.Objects;

public class TwoPrevWords implements TuplePrevWords {
	private String currWord = "";
	private String prevWord1 = "";
	private String prevWord2 = "";
	
	public TwoPrevWords () {}
	public TwoPrevWords (String currWord) {
		this.currWord = currWord;
	}
	public TwoPrevWords (String curr , String prev1 , String prev2) {
		currWord = curr;
		prevWord1 = prev1;
		prevWord2 = prev2;
	}
	
	@Override
	public void setCurrWord(String a) {
		// TODO Auto-generated method stub
		currWord = a;
	}
	@Override
	public String getCurrWord() {
		// TODO Auto-generated method stub
		return currWord;
	}
	
	public void setPrev1 (String a) {
		prevWord1 = a;
	}
	public String getPrev1 () {
		return prevWord1;
	}
	
	public void setPrev2 (String a) {
		prevWord2 = a;
	}
	public String getPrev2 () {
		return prevWord2;
	}
	
	public void setPrevs (String a, String b) {
		prevWord1 = a;
		prevWord2 = b;
	}
	public String [] getPrevs () {
		String[] res = new String [2];
		res[0] = prevWord1;
		res[1] = prevWord2;
		return res;
	}
	
	public String toString () {
		return prevWord2 + " " + prevWord1 + " " + currWord;
	}
	@Override
	public int compareTo(TuplePrevWords a) {
		// TODO Auto-generated method stub
		TwoPrevWords o = (TwoPrevWords) a;
		return this.toString().compareTo(o.toString());
	}
	
	@Override
	public boolean equals (Object o) {
		return this.compareTo((TwoPrevWords)o) == 0;
	}
	@Override
	public int hashCode () {
		return Objects.hash(currWord , prevWord1 , prevWord2);
	}
	@Override
	public boolean prevEquals (String s) {
		return (prevWord2 + prevWord1).equals(s);
	}
	
	
}
