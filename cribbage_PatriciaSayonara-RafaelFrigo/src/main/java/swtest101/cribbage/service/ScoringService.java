package swtest101.cribbage.service;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import swtest101.cribbage.entity.Card;
import swtest101.cribbage.entity.Suit;

public class ScoringService {
	
	private static List<Card> cards;
	
	//Calculo de fatorial
	private static int factorial(int number) {
		int res = 1;
		
		for(int i = 1; i <= number; i++) {
			res *= i; 
		}
		
		return res;
	}
	
	//Combinacao sem repeticao
	private static int combinations(int numElements, int pattern) {
		int comb;
		
		comb = factorial(numElements)/(factorial(pattern)*factorial(numElements-pattern));
		
		return comb;
	}
	
	//Pair (par de cartas com o mesmo valor): 2 pontos
	private static Integer calcCombinationPair() {
		HashMap<Integer,Integer> ranks = new HashMap<Integer,Integer>();
		
		for(Card card: cards) {
			if(!ranks.containsKey(card.getRank())) {
				ranks.put(card.getRank(),1);
			}
			else {
				int withSameRank = ranks.get(card.getRank()) + 1;
				ranks.replace(card.getRank(), ranks.get(card.getRank()), withSameRank);
			}
		}
		
		int score = 0;
		
		Set<Integer> keys = ranks.keySet();
		for (Integer key : keys) {
			int current = ranks.get(key);
			if(current > 1) {
				score += combinations(current,2)*2;
			}
		}
		
		return score;
	}
	
	
	// Straight (sequência de 3 cartas ou mais): 1 ponto por carta
	private static Integer calcCombinationStraight() {
		
		return null;
	}
	
	//Flush (4 ou 5 cartas com o mesmo naipe): 1 ponto por carta
	private static Integer calcCombinationFlush() {
		HashMap<Suit,Integer> suits = new HashMap<Suit,Integer>();
		
		for(Card card: cards) {
			if(!suits.containsKey(card.getSuit())) {
				suits.put(card.getSuit(),1);
			}
			else {
				int withSameSuit = suits.get(card.getSuit()) + 1;
				suits.replace(card.getSuit(), suits.get(card.getSuit()), withSameSuit);
			}
		}
		
		int score = 0;
		
		Set<Suit> keys = suits.keySet();
		for (Suit key : keys) {
			int current = suits.get(key);
			if(current == 4 || current == 5) {
				score += current;
			}
		}
		return score;
	}

	//Nob (se o jogador tiver um valete do mesmo naipe da Start Card): 1 ponto
	private static Integer calcCombinationNob() {
		Suit startCardSuit = cards.get(0).getSuit();
		
		ListIterator<Card> iter = cards.listIterator(1);
		
		while(iter.hasNext()) {
			Card currentCard = iter.next();
			if(currentCard.getRank().equals(11) && startCardSuit.equals(currentCard.getSuit())) {
				return 1;
			}
		}
		
		return 0;
	}
	
	//15 (qualquer combinação de cartas que some 15): 2 pontos 
	//(Obs.: para a soma dos 15, as cartas Rei, Dama e Valete valem 10 e o Ás vale 1)
	private static Integer calcCombination15() {
		return null;
	}


	public static Integer calculateScore(String handOfCards) {
		int score = 0;
		
		cards = ParseStringService.parseToListOfCards(handOfCards);
		
		score += calcCombinationPair();
		//score += calcCombinationStraight();
		score += calcCombinationFlush();
		score += calcCombinationNob();
		//score += calcCombination15();
		
		return score;
	}

}
