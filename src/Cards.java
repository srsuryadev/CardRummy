import java.util.ArrayList;

public class Cards {
	private int rank,suite;
	
	static String[] suites = {"Clubs" , "Spades" , "Hearts", "Diamonds"};
	static String[] ranks = {"ace", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"};
	
	Cards(int rank, int suite){
		this.rank = rank;
		this.suite = suite;
	}
	
	
	public int getrank(){
		return this.rank;
	}
	
	public int getsuite(){
		return this.suite;
	}
	

}
