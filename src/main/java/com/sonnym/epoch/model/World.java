package com.sonnym.epoch.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World {
	private static final int STARTING_YEAR = 0;
	private static final long DEFAULT_SEED = 1;
	private List<Settlement> settlements;
	private int currentYear;
	private final long seed;
	private final Random random;

	public World(long seed) {
		this.random = new Random(seed);
		this.seed = seed;
		this.settlements = new ArrayList<>();
		this.currentYear = STARTING_YEAR;
	}

	public World() {
		this(DEFAULT_SEED);
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

	public long getSeed() {
		return seed;
	}

	public int nextInt(int bound) {
		return random.nextInt(bound);
	}

}
