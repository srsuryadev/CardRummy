import java.util.ArrayList;

public abstract class Strategy{

	abstract int nextMove(int bidOn,ArrayList<Boolean> myHand, ArrayList<Boolean> playedCards, float cScore, float hSCore);

}
