package ee.ignorance.transformiceapi.event;

import ee.ignorance.transformiceapi.titles.TribeRank;

public interface TribePlayerRankChangeListener {

	void tribePlayerRankChanged(String playerName, TribeRank rank);
}
