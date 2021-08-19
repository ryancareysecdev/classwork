
public class ACard {
	private int rank;
	private String suit;
	public ACard() {
		rank=0;
		suit="";
	}
	public ACard(int givenrank) {
		rank = givenrank;
		suit = "";
	}
	public ACard(String givensuit) {
		rank = 0;
		suit = givensuit;
	}
	public ACard(int givenrank, String givensuit) {
		rank = givenrank;
		suit = givensuit;
	}
	public void setRank(int newrank) {
		rank = newrank;
	}
	public void setSuit(String newsuit) {
		suit = newsuit;
	}
	public int getRank() {
		return rank;
	}
	public String getSuit() {
		return suit;
	}
	public void setRankandSuit(int newrank, String newsuit) {
		rank = newrank;
		suit = newsuit;
	}

}
