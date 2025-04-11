package training;

public interface TuplePrevWords extends Comparable<TuplePrevWords> {
	public void setCurrWord(String a);
	public String getCurrWord();
	public int compareTo (TuplePrevWords a);
	public boolean prevEquals (String s);
}
