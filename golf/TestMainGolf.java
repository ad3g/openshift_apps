package com.golf;

//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//import com.bcbsm.eit.carrier.CarrierService;
//import com.bcbsm.eit.carrier.PartdCarrList;
//import com.bcbsm.eit.common.api.APIEnvelop;
//import com.bcbsm.eit.common.props.CMProperties;

public class TestMainGolf {

    public static void main(String[] args) throws Exception {
    	System.out.println("Start TestMainGolf:");
    	
//    	randomGroupAssignment();
//    	for (int i = 2;i < 29;i++){
//    		testNumGroups(i);
//    	}
    	//testAlpha();
    	//testGroupAssignment(13);
   	
    	System.out.println("End   TestMainGolf:");
    }
    private static void testGroupAssignment(int numOfPlayers){
    	
    	ArrayList<Player> lP = new ArrayList<Player>();
    	PlayerDao pDao = new PlayerDao();
    	lP = pDao.listPlayers(numOfPlayers);
    	randomizePlayers(lP);
    	
    	GroupResult gr = determineNumberOfGroups(lP.size());
  
    	int k = 0;
    	int grp = 1;

    	for (int i = 0;i < gr.getiNumTwosomes();i++){
    		for (int j = 0;j < 2;j++){
    			System.out.println("Group # " + Status.get(grp) + " P-Id: " + lP.get(k).getpId() + " P-Name: " + lP.get(k).getpName());
    			k++;
    		}
    		grp++;
    	}
    	for (int i = 0;i < gr.getiNumThreesomes();i++){
    		for (int j = 0;j < 3;j++){
	    		System.out.println("Group # " + Status.get(grp) + " P-Id: " + lP.get(k).getpId() + " P-Name: " + lP.get(k).getpName());
	    		k++;
    		}
    		grp++;
    	}
    	for (int i = 0;i < gr.getiNumFoursomes();i++){
    		for (int j = 0;j < 4;j++){
    			System.out.println("Group # " + Status.get(grp) + " P-Id: " + lP.get(k).getpId() + " P-Name: " + lP.get(k).getpName());
    			k++;
    		}
    		grp++;
    	}
	}
    
    private static void testNumGroups(int iReceived){
    	GroupResult gr = new GroupResult();
    	int iS = iReceived;
    	int iR = 0;
    	
    	gr = determineNumberOfGroups(iS);
    	iR = ((gr.getiNumFoursomes() * 4) + (gr.getiNumThreesomes() * 3) + (gr.getiNumTwosomes() * 2));
    	if (iS == iR){
    		System.out.println("Match S: " + iS + " R: " + iR);
    	}
    	else
    	{
    		System.out.println("Not Match S: " + iS + " R: " + iR);
    	}
    	
    }
    private static void randomizePlayers(ArrayList<Player> lP){

    	long seed = System.nanoTime();
    	Collections.shuffle(lP, new Random(seed));
    	
    	for (int i=0;i<lP.size();i++){
    		System.out.println("Player Name: " + lP.get(i).getpName());
    	}
     }

    private static void randomGroupAssignment(){
    	
    	System.out.println("Start testGroupAssignment");
 
    	ArrayList<Player> lP = new ArrayList<Player>();
    	PlayerDao pDao = new PlayerDao();
    	lP = pDao.listPlayers(12);

    	System.out.println("B4 shuffle: ");
    	for (int i=0;i<lP.size();i++){
    		System.out.println("Player Name: " + lP.get(i).getpName());
    	}
    	
    	long seed = System.nanoTime();
    	Collections.shuffle(lP, new Random(seed));
    	
    	System.out.println("After shuffle: ");
    	for (int i=0;i<lP.size();i++){
    		System.out.println("Player Name: " + lP.get(i).getpName());
    	}
    	
    	System.out.println("End testGroupAssignment");
     }
    private static GroupResult determineNumberOfGroups(int numOfPlayers){
    	
    	/* 
    	2 = 2
    	3 = 3
    	4 = 4
    	5 = 2/3
    	6 = 3/3
    	7 = 3/4
    	8 = 4/4
    	9 = 3/3/3
    	10 = 3/3/4
    	11 = 3/4/4
    	12 = 4/4/4
    	13 = 3/3/3/4
    	14 = 3/3/4/4
    	15 = 3/4/4/4
    	16 = 4/4/4/4
    	17 = 3/3/3/4/4
    	18 = 3/3/4/4/4
    	19 = 3/4/4/4/4
    	20 = 4/4/4/4/4
    	21 = 3/3/3/4/4/4
    	22 = 3/3/4/4/4/4
    	23 = 3/4/4/4/4/4
    	24 = 4/4/4/4/4/4
    	25 = 3/3/3/4/4/4/4
    	26 = 3/3/4/4/4/4/4
    	27 = 3/4/4/4/4/4/4
    	28 = 4/4/4/4/4/4/4
    	*/
    	GroupResult gr = new GroupResult();
    	if (numOfPlayers == 2){ gr.setiNumTwosomes(1);}
    	if (numOfPlayers == 3){ gr.setiNumThreesomes(1);}
    	if (numOfPlayers == 4){ gr.setiNumFoursomes(1);}
    	if (numOfPlayers == 5){ gr.setiNumThreesomes(1); gr.setiNumTwosomes(1);}
    	if (numOfPlayers == 6){ gr.setiNumThreesomes(2);}
    	if (numOfPlayers == 7){ gr.setiNumThreesomes(1); gr.setiNumFoursomes(1);}
    	if (numOfPlayers == 8){ gr.setiNumFoursomes(2);}
    	if (numOfPlayers == 9){ gr.setiNumThreesomes(3);}
    	if (numOfPlayers == 10){ gr.setiNumThreesomes(2); gr.setiNumFoursomes(1);}
    	if (numOfPlayers == 11){ gr.setiNumThreesomes(1); gr.setiNumFoursomes(2);}
    	if (numOfPlayers == 12){ gr.setiNumFoursomes(3);}
    	if (numOfPlayers == 13){ gr.setiNumThreesomes(3); gr.setiNumFoursomes(1);}
    	if (numOfPlayers == 14){ gr.setiNumThreesomes(2); gr.setiNumFoursomes(2);}
    	if (numOfPlayers == 15){ gr.setiNumThreesomes(1); gr.setiNumFoursomes(3);}
    	if (numOfPlayers == 16){ gr.setiNumFoursomes(4);}
    	if (numOfPlayers == 17){ gr.setiNumThreesomes(3); gr.setiNumFoursomes(2);}
    	if (numOfPlayers == 18){ gr.setiNumThreesomes(2); gr.setiNumFoursomes(3);}
    	if (numOfPlayers == 19){ gr.setiNumThreesomes(1); gr.setiNumFoursomes(4);}
    	if (numOfPlayers == 20){ gr.setiNumFoursomes(5);}
    	if (numOfPlayers == 21){ gr.setiNumThreesomes(3); gr.setiNumFoursomes(3);}
    	if (numOfPlayers == 22){ gr.setiNumThreesomes(2); gr.setiNumFoursomes(4);}
    	if (numOfPlayers == 23){ gr.setiNumThreesomes(1); gr.setiNumFoursomes(5);}
    	if (numOfPlayers == 24){ gr.setiNumFoursomes(6);}
    	if (numOfPlayers == 25){ gr.setiNumThreesomes(3); gr.setiNumFoursomes(4);}
    	if (numOfPlayers == 26){ gr.setiNumThreesomes(2); gr.setiNumFoursomes(5);}
    	if (numOfPlayers == 27){ gr.setiNumThreesomes(1); gr.setiNumFoursomes(6);}
    	if (numOfPlayers == 28){ gr.setiNumFoursomes(7);}
    	
    	return gr;
    }
    public enum Status {
    	 Aces(1),
    	 Kings(2),
    	 Queens(3),
    	 Jacks(4),
    	 Tens(5),
    	 Nines(6),
    	 Eights(7),
    	 Sevens(8),
    	 Sixes(9),
    	 Fives(10),
    	 Fours(11),
    	 Threes(12),
    	 Twos(13),
    	 Ones(14);

    	 private static final Map<Integer,Status> lookup 
    	      = new HashMap<Integer,Status>();

    	 static {
    	      for(Status s : EnumSet.allOf(Status.class))
    	           lookup.put(s.getCode(), s);
    	 }

    	 private int code;

    	 private Status(int code) {
    	      this.code = code;
    	 }

    	 public int getCode() { return code; }

    	 public static Status get(int code) { 
    	      return lookup.get(code); 
    	 }
    }
}
