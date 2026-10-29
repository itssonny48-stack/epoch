package com.sonnym.epoch.model;

import java.util.ArrayList;
import java.util.List;

public class World {
	private static final int STARTING_YEAR = 0;
	private List<Settlement> settlements;
	private int currentYear;

	public World() {
		this.settlements = new ArrayList<>();
		this.currentYear = STARTING_YEAR;
	}

	public void addSettlement(Settlement settlement) {
		settlements.add(settlement);
	}

	public int getCurrentYear() {
		return currentYear;
	}

	public int getTotalPopulation() {
		int total = 0;
		for (Settlement settlement : settlements) {
			total = total + settlement.getPopulation();
		}
		return total;
	}

	public List<Settlement> getSettlements() {
		return List.copyOf(settlements);
	}

}
