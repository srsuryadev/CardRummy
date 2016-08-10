import java.util.ArrayList;

public class MediumStrategy extends Strategy{

	@Override
	int nextMove(int bidOn, ArrayList<Boolean> myHand, ArrayList<Boolean> playedCards, float cScore, float hSCore) {
		if(bidOn == 12)
			return 1;
		else
			return bidOn + 1;
	}


}
