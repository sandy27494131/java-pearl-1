package com.robert.arch.ood.poker;

class PokerCard implements Comparable<PokerCard> {
	private int num;

	private CardColor color;

	enum CardColor {
		Black, Red, Flower, Rectangle
	}

	public PokerCard(int num, CardColor color) {
		this.num = num;
		this.color = color;
	}

	public boolean equals(Object obj) {
		PokerCard otherPokerCard = (PokerCard) obj;
		if (otherPokerCard.num == num && otherPokerCard.color == color)
			return true;

		return false;
	}

	public int compareTo(PokerCard other) {
		if (equals(other))
			return 0;

		if (this.color != other.color)
			return 0;

		return this.num - other.num;
	}

	public String toString() {

		if (this.num == 0 && this.color == CardColor.Red)
			return "PokerCard [King]";
		else if (this.num == 0 && this.color == CardColor.Black)
			return "PokerCard [Small King]";

		char[] names = new char[] { 'J', 'Q', 'K' };
		return "PokerCard [num="
				+ (num <= 10 ? num : (char) names[num - 11] + "") + ", color="
				+ color + "]";
	}
}