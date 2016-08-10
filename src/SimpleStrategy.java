import java.util.ArrayList;

public class SimpleStrategy extends Strategy {

	@Override
	int nextMove(int bidOn,ArrayList<Boolean> myHand, ArrayList<Boolean> playedCards, float cScore, float hSCore) {
		return bidOn;
	}


	

}
