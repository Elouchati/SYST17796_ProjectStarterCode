package war;

/**
 * This class represents a standard playing card.
 * Cards have a rank and a suit. The possible ranks are 2, 3, 4, 5, 6, 7, 8, 9, 10
 * jack, queen, king, and ace. The possible suits are clubs, diamonds, hearts, and spades.
 * Objects of this class are immutable. Once a Card object is created its suit and value 
 * cannot be changed.
 */

public class Deck implements Comparable<Card>
{   
    public static final int TWO = 0;
    public static final int THREE = 1;
    public static final int FOUR = 2;
    public static final int FIVE = 3;
    public static final int SIX = 4;
    public static final int SEVEN = 5;
    public static final int EIGHT = 6;
    public static final int NINE = 7;
    public static final int TEN = 8;
    public static final int JACK = 9;
    public static final int QUEEN = 10;
    public static final int KING = 11;
    public static final int ACE = 12;

    public static final int CLUBS = 0;
    public static final int DIAMONDS = 1;
    public static final int HEARTS = 2;
    public static final int SPADES = 3;

    private static final String[] ourRanks = {"2", "3", "4",
        "5", "6", "7", "8", "9", "10", "Jack",
        "Queen", "King", "Ace"};
    private static final String[] ourSuits = {"Clubs", "Diamonds", "Hearts", "Spades"};

    private final int mySuit;
    private final int myRank;

    //constructors

    /**
     * Default constructor.
     * <br>pre:  none<br>
     * <br>post:   getRank() = TWO, getSuit() = CLUBS
     */
    public Deck(){   
    	this(TWO, CLUBS);
    }

    /**
     * Create a card with the specified rank and suit.
     * <br> pre: validSuit(suit), validRank(rank)
     * <br> post:   getRank() = rank, getSuit() = suit
     */
    public Deck(int suit, int rank){   
    	assert validSuit(suit) && validRank(rank) : "Failed precondition. validSuit(suit): "
    		+ validSuit(suit) + ", validRank(rank): " + validRank(rank) ;
    	myRank = rank;
        mySuit = suit;
    }
    
    //accessors

    /**
     * get this Card's rank.
     * <br>pre: none
     * post: returns this Card's rank
     * @return this Card's rank
     */
    public int getRank(){       
    	return myRank;    
    }

    /**
     * get this Card's suit.
     * <br>pre: none<br>
     * post: returns this Card's suit
     * @return this Card's suit
     */
    public int getSuit(){   
    	return mySuit; 
    }

    /**
     * determine if a given int represents a valid rank for this classes' cards.
     * <br>pre: none<br>
     * <br>post: returns true if rank between TWO and ACE inclusive, false otherwise
     * @return returns true if rank between TWO and ACE inclusive, false otherwise
    **/
    public static boolean validRank(int rank){   
    	return (TWO <= rank) && (rank <= ACE);    
    }

    /**
     * determine if a given int represents a valid suit for this classes' cards.
     * <br>pre: none<br>
     * <br>post: returns true if rank between CLUBS and SPADES inclusive, false otherwise
     * @return returns true if rank between CLUBS and SPADES inclusive, false otherwise
    **/
    public static boolean validSuit(int suit){
    	return (CLUBS <= suit) && (suit <= SPADES); 
    }

    /**
     * check to see if two Cards are equal.<br>pre: none
    <br>post: return true if otherCard has the same suit and rank as this Card, false otherwise
     * @param otherCard
     * @return return true if otherCard has the same suit and rank as this Card, false otherwise
     */
    @Override
    public boolean equals(Object otherCard){   
    	boolean result = false;
        if(otherCard == this)
            result = true;
        else if(otherCard != null && getClass() == otherCard.getClass())
        {   Card tempCard = (Card) otherCard;
            result = (myRank == tempCard.myRank) 
                && (mySuit == tempCard.mySuit);
        }
        return result;
    }
    
    /**
     * return a string representation of this card.
     * <br>pre: none
     * <br>post: return a string representation of this card.
     * @return return a string representation of this card.
     */
    @Override
    public String toString(){
    	return ourRanks[getRank()] + " of " + ourSuits[getSuit()];  
    }
    
    /**
     * compare this Card and another Card.Objects of this class are ordered based on rank, with ACE being highest and TWO being
 lowest.Ties in ranks are broken by rank with the order of ranks from lowest to 
 highest being CLUBS, DIAMONDS, HEARTS, SPADES
    <br>pre: other != null
    <br>post: return a positive int if the calling Card is greater than other.
     * return 0 if the two Cards are equal. Return a negative int if the calling Card
 is less than other
     * @param otherCard
     * @return
     */
    @Override
    public int compareTo(Card otherCard){   
    	int result = getRank() - otherCard.getRank();
    	if( result == 0)
    		result = getSuit() - otherCard.getSuit();
        return result;
    }

    void shuffle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Card dealCard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
