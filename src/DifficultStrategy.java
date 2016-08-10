import java.util.ArrayList;

public class DifficultStrategy extends Strategy {

	@Override
	public int nextMove(int bidOn, ArrayList<Boolean> myHand, ArrayList<Boolean> playedCards, float cScore, float hScore) {
		float diffScore = cScore - hScore;
		// Case1
		if (cScore > hScore) {
			// subCase1
			if (bidOn < diffScore) {
				// ArrayList<Boolean> commonPossibleBid =
				// commonPossibleBids(playedCards, myHand);
				return lowestBid(myHand);
			}
			// subCase2
			else {

			}
		}
		return 0;

	}

	public int highestBid(ArrayList<Boolean> arr) {
		return arr.lastIndexOf(false);
	}

	public int lowestBid(ArrayList<Boolean> arr) {
		return arr.indexOf(false);
	}

	public ArrayList<Boolean> commonPossibleBids(ArrayList<Boolean> p1, ArrayList<Boolean> c1) {
		ArrayList<Boolean> commonPossibleBid = p1;
		commonPossibleBid.retainAll(c1);
		return commonPossibleBid;
	}

}
