package com.robert.arch.ood.poker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.robert.arch.ood.poker.PokerCard.CardColor;

public class PokerControl {
	public static final int NUM = 54;

	private List<PokerCard> cards = new ArrayList<PokerCard>();
	
	private List<PokerUser> users = new ArrayList<PokerUser>();

	public PokerControl() {
		init();
	}

	private void init() {
		initCards();
		initUsers();
	}

	private void initCards() {
		for (int i = 0; i < 13; i++) {
			PokerCard pcBlack = new PokerCard(i + 1, CardColor.Black);
			PokerCard pcRed = new PokerCard(i + 1, CardColor.Red);
			PokerCard pcFlower = new PokerCard(i + 1, CardColor.Flower);
			PokerCard pcRectangle = new PokerCard(i + 1, CardColor.Rectangle);

			cards.add(pcBlack);
			cards.add(pcRed);
			cards.add(pcFlower);
			cards.add(pcRectangle);
		}

		PokerCard pcKing = new PokerCard(0, CardColor.Red);
		PokerCard pcAssistantKing = new PokerCard(0, CardColor.Black);

		cards.add(pcKing);
		cards.add(pcAssistantKing);
	}

	private void initUsers() {
		// TODO Not finished
		for (int i = 0; i < users.size(); i++) {
			users.add(new PokerUser(i, "User " + i));
		}
		
	}

	public void shuffle() {
		Random r = new Random(new Date().getTime());

		for (int k = 0; k < NUM; k++) {
			int i = r.nextInt(cards.size() - k) + k;

			swap(k, i);
		}
	}

	private void swap(int i, int j) {
		PokerCard card1 = cards.get(i);
		PokerCard card2 = cards.get(j);

		cards.set(i, card2);
		cards.set(j, card1);
	}

	public static void main(String[] args) {
		PokerControl pc = new PokerControl();

		System.out.println("Before Shuffle:" + pc.cards);

		pc.shuffle();

		System.out.println("After Shuffle:" + pc.cards);
	}

}
