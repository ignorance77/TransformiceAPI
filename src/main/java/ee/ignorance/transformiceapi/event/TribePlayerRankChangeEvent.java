package ee.ignorance.transformiceapi.event;

import ee.ignorance.transformiceapi.titles.TribeRank;

public class TribePlayerRankChangeEvent implements Event<TribePlayerRankChangeListener> {

	private String playerName;
	private TribeRank rank;

	public TribePlayerRankChangeEvent(String playerName, TribeRank rank) {
		this.playerName = playerName;
		this.rank = rank;
	}

	public String getPlayerName() {
		return playerName;
	}

	public TribeRank getRank() {
		return rank;
	}

	@Override
	public void notifyListener(TribePlayerRankChangeListener listener) {
		listener.tribePlayerRankChanged(playerName, rank);
	}
}
