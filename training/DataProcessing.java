package training;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DataProcessing {
	
	public static HashMap<OnePrevWord , Integer> cntTuple1 (ArrayList<String> lake) {
		HashMap<OnePrevWord , Integer> res = new HashMap<OnePrevWord, Integer>();
		
		for (int i = 1; i < lake.size(); ++ i) {
			OnePrevWord token = new OnePrevWord(lake.get(i) , lake.get(i - 1));
			if (!res.containsKey(token)) res.put(token, 1);
			else res.put(token , res.get(token) + 1);
		}
		
		return res;
	}
	public static HashMap<TwoPrevWords , Integer> cntTuple2 (ArrayList<String> lake) {
		HashMap<TwoPrevWords , Integer> res = new HashMap<TwoPrevWords, Integer>();
		
		for (int i = 2; i < lake.size(); ++ i) {
			TwoPrevWords token = new TwoPrevWords(lake.get(i) , lake.get(i - 1) , lake.get(i - 2));
			if (!res.containsKey(token)) res.put(token, 1);
			else res.put(token , res.get(token) + 1);
		}
		
		return res;
	}
	public static HashMap<ThreePrevWords , Integer> cntTuple3 (ArrayList<String> lake) {
		HashMap<ThreePrevWords , Integer> res = new HashMap<ThreePrevWords, Integer>();
	
			for (int i = 3; i < lake.size(); ++ i) {
				ThreePrevWords token = new ThreePrevWords(lake.get(i) , lake.get(i - 1) , 
														lake.get(i - 2) , lake.get(i - 3));
				if (!res.containsKey(token)) res.put(token, 1);
				else res.put(token , res.get(token) + 1);
			}
		
		return res;
	}
	
	public static void main(String[] args) {
		
		ArrayList<String> lake = new ArrayList<String>();
		try {
			File file = new File ("F:\\Learning\\Code\\Java-Eclipse\\"
					+ "AI_First_Project\\src\\Data\\preTrainedData\\preTrainedData.txt");
			Scanner sc = new Scanner (file);
			while (sc.hasNext()) {
				lake.add(sc.next());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!!");
			e.printStackTrace();
		}
		
		HashMap<OnePrevWord , Integer> mp1 = cntTuple1(lake);
		HashMap<TwoPrevWords , Integer> mp2 = cntTuple2(lake);
		HashMap<ThreePrevWords , Integer> mp3 = cntTuple3(lake);
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\Learning\\Code\\"
				+ "Java-Eclipse\\AI_First_Project\\src\\Data\\processedData\\processedData1.txt"))) {
			for (OnePrevWord t : mp1.keySet()) {
				bw.write(t.toString() + " " + mp1.get(t) + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\Learning\\Code\\"
				+ "Java-Eclipse\\AI_First_Project\\src\\Data\\processedData\\processedData2.txt"))) {
			for (TwoPrevWords t : mp2.keySet()) {
				bw.write(t.toString() + " " + mp2.get(t) + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\Learning\\Code\\"
				+ "Java-Eclipse\\AI_First_Project\\src\\Data\\processedData\\processedData3.txt"))) {
			for (ThreePrevWords t : mp3.keySet()) {
				bw.write(t.toString() + " " + mp3.get(t) + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
