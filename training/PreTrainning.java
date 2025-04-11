package training;

import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class PreTrainning {
	public static void main(String[] args) {
		
		try {
			File file = new File("F:\\Learning\\Code\\Java-Eclipse\\"
					+ "AI_First_Project\\src\\Data\\rawData\\viwik18_aa.txt");
			Scanner sc = new Scanner (file);
			
			while (sc.hasNext()) {	
				String word = sc.next();
				try (BufferedWriter br = new BufferedWriter(new FileWriter("F:\\Learning\\Code\\"
						+ "Java-Eclipse\\AI_First_Project\\src\\Data\\preTrainedData\\preTrainedData.txt" , true))) {
					if (!word.equals("")) br.write(word + " ");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		}
		
		
	}
}
