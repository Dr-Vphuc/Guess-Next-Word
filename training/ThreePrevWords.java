package training;

import java.util.Objects;

public class ThreePrevWords implements TuplePrevWords {
	private String currWord = "";
	private String prevWord1 = "";
	private String prevWord2 = "";
	private String prevWord3 = "";
	
	public ThreePrevWords () {}
	public ThreePrevWords (String a) {
		this.currWord = a;
	}
	public ThreePrevWords (String a , String b , String c , String d) {
		currWord = a;
		prevWord1 = b;
		prevWord2 = c;
		prevWord3 = d;
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

	public void setPrev2 (String a) {
		prevWord1 = a;
	}
	public String getPrev2 () {
		return prevWord2;
	}
	
	public void setPrev3 (String a) {
		prevWord1 = a;
	}
	public String getPrev3 () {
		return prevWord3;
	}
	
	public void setPrev1 (String a) {
		prevWord1 = a;
	}
	public String getPrev1 () {
		return prevWord1;
	}
	
	public void setPrevs (String a , String b , String c) {
		prevWord1 = a;
		prevWord2 = b;
		prevWord3 = c;
	}
	public String[] getPrevs () {
		String[] res = new String [3];
		res[0] = prevWord1;
		res[1] = prevWord2;
		res[2] = prevWord3;
		
		return res;
	}
	
	public String toString () {
		return prevWord3 + " " + prevWord2 + " " + prevWord1 + " " + currWord;
	}
	@Override
	public int compareTo(TuplePrevWords a) {
		// TODO Auto-generated method stub
		ThreePrevWords o = (ThreePrevWords) a;
		return this.toString().compareTo(o.toString());
	}
	@Override
	public boolean equals (Object o) {
		return this.compareTo((ThreePrevWords)o) == 0;
	}
	@Override
	public int hashCode () {
		return Objects.hash(currWord , prevWord1 , prevWord2 , prevWord3);
	}
	@Override
	public boolean prevEquals (String s) {
		return (prevWord3 + prevWord2 + prevWord1).equals(s);
	}

}
