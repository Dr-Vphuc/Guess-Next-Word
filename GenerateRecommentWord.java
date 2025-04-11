import java.io.*;
import java.util.*;
import training.OnePrevWord;
import training.TwoPrevWords;
import training.ThreePrevWords;
import training.TuplePrevWords;

public class GenerateRecommentWord {
    static class cntPair implements Comparable<cntPair>{
        public TuplePrevWords key;
        public int cnt;

        public cntPair (TuplePrevWords key) {
            this.key = key;
            cnt = 0;
        }
        public cntPair (TuplePrevWords key , int cnt) {
            this.key = key;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(cntPair o) {
            // TODO Auto-generated method stub
            return o.cnt - this.cnt ;
        }
    }

    public static ArrayList<cntPair> retrieval1 (GenerateRecommentWord g) {
        ArrayList<cntPair> prev1List = new ArrayList<cntPair>();
        try (BufferedReader br = new BufferedReader(new FileReader("F:\\Learning\\Code\\Java-Eclipse"
                + "\\AI_First_Project\\src\\Data\\processedData\\processedData1.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] s = line.split("\\s+");
                OnePrevWord o = new OnePrevWord(s[1] , s[0]);
                GenerateRecommentWord.cntPair cnt1 =
                        new cntPair((TuplePrevWords) o, Integer.parseInt(s[2]));
                prev1List.add(cnt1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prev1List;
    }
    public static ArrayList<cntPair> retrieval2 (GenerateRecommentWord g) {
        ArrayList<cntPair> prev2List = new ArrayList<cntPair>();
        try (BufferedReader br = new BufferedReader(new FileReader("F:\\Learning\\Code\\Java-Eclipse"
                + "\\AI_First_Project\\src\\Data\\processedData\\\\processedData2.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] s = line.split("\\s+");
                TwoPrevWords o = new TwoPrevWords(s[2] , s[1] , s[0]);
                GenerateRecommentWord.cntPair cnt2 =
                        new cntPair(o, Integer.parseInt(s[3]));
                prev2List.add(cnt2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prev2List;
    }
    public static ArrayList<cntPair> retrieval3 (GenerateRecommentWord g) {
        ArrayList<cntPair> prev3List = new ArrayList<cntPair>();
        try (BufferedReader br = new BufferedReader(new FileReader("F:\\Learning\\Code\\Java-Eclipse"
                + "\\AI_First_Project\\src\\Data\\processedData\\\\processedData3.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] s = line.split("\\s+");
                ThreePrevWords o = new ThreePrevWords(s[3] , s[2] , s[1] , s[0]);
                GenerateRecommentWord.cntPair cnt3 =
                        new cntPair(o, Integer.parseInt(s[4]));
                prev3List.add(cnt3);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prev3List;
    }

    public static void main(String[] args) {
        System.out.println("Loading...");
        GenerateRecommentWord g = new GenerateRecommentWord();
        ArrayList<cntPair> prev1List =  retrieval1(g);
        ArrayList<cntPair> prev2List = retrieval2(g);
//        ArrayList<cntPair> prev3List = retrieval3(g);

        System.out.println("\t\tChương trình AI tự hoàn thiện câu.");
        System.out.println("Nhập 1 vài từ (3 từ trở lên AI sẽ hoạt động hiệu quả nhất) : ");
        System.out.println("Ấn '.' nếu muốn dừng lại nhé.");
        String input = "";
        StringBuilder stc = new StringBuilder();
        Scanner sc = new Scanner (System.in);
        input = sc.nextLine();
        stc = new StringBuilder(input);
        while  (input.charAt(0) != '.') {

            String[] tokens = stc.toString().split("\\s+");
            String prev1 = tokens[tokens.length - 1];
            String prev2 = "" , prev3 = "";
            if (tokens.length >= 2)
                prev2 = tokens[tokens.length - 2];
            if (tokens.length >= 3)
                prev3 = tokens[tokens.length - 3];

            ArrayList<cntPair> relateTuple1 = new ArrayList<cntPair>();
            for (cntPair i : prev1List) {
                if (i.key.prevEquals(prev1)) relateTuple1.add(i);
            }
            Collections.sort(relateTuple1);

            ArrayList<cntPair> relateTuple2 = new ArrayList<cntPair>();
            if (tokens.length >= 2) {
                for (cntPair i : prev2List) {
                    if (i.key.prevEquals(prev2 + prev1)) relateTuple2.add(i);
                }
                Collections.sort(relateTuple2);

            }

            ArrayList<String> rcm = new ArrayList<String>();
            while (rcm.size() < 3 && relateTuple2.size() != 0) {
                boolean check = false;
                for (String s : rcm) {
                    if (s.equals(relateTuple2.get(0).key.getCurrWord())) check = true;
                }
                if (check) {
                    relateTuple2.remove(0);
                    continue;
                }
                rcm.add(relateTuple2.get(0).key.getCurrWord());
                relateTuple2.remove(0);
            }
            while (rcm.size() < 3 && relateTuple1.size() != 0) {
                boolean check = false;
                for (String s : rcm) {
                    if (s.equals(relateTuple1.get(0).key.getCurrWord())) check = true;
                }
                if (check) {
                    relateTuple1.remove(0);
                    continue;
                }
                rcm.add(relateTuple1.get(0).key.getCurrWord());
                relateTuple1.remove(0);
            }

            for (int j = 0; j < rcm.size(); ) {
                System.out.print(++j + ":" + rcm.get(j - 1) + ", ");
            }

            System.out.print("\n" + stc + " ");
            input = sc.nextLine();
            if (Character.isDigit(input.charAt(0))) {
                stc.append(" ").append(rcm.get(Integer.parseInt(input) - 1));
            } else stc.append(" ").append(input);
        }

        sc.close();

    }

}