/**
 * @author Khoa Tran
 * @version 03/09/2013
 * A data structure that represents a pair of values.
 * @param <A> a generic type of the first element
 * @param <B> a generic type of the second element
 */

public class Pair<A, B> {
	
    /* Private data for a pair construct */
    private A first;
    private B second;

    /**
     * Constructor for the Pair class
     * @param first - the first element of a generic type A
     * @param second - the second element of a generic type B
     */
    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Checks if the two pairs are equal. Overrides the default "equal" method of 
     * Java Object class. Just for completeness.
     */
    public boolean equals(Object other) {
        if (other instanceof Pair) {
            @SuppressWarnings("unchecked")
                Pair<A, B> otherPair = (Pair<A, B>) other;
            return (( this.first == otherPair.first ||
                      (this.first != null && otherPair.first != null &&
                       this.first.equals(otherPair.first))) &&
                    ( this.second == otherPair.second ||
                      ( this.second != null && otherPair.second != null &&
                        this.second.equals(otherPair.second))) );
        }
        return false;
    }

    /**
     * Displays the pair in a tuple () format
     */
    public String toString()
    { 
        return "(" + first + ", " + second + ")"; 
    }

    /**
     * Gets the first element
     * @return the first element
     */
    public A getFirst() {
        return first;
    }

    /**
     * Sets the first element to a new value
     * @param first - the new first element of the pair
     */
    public void setFirst(A first) {
        this.first = first;
    }

    /**
     * Gets the second element
     * @return the second element
     */
    public B getSecond() {
        return second;
    }

    /**
     * Sets the second element to a new value
     * @param second - the new second element of the pair
     */
    public void setSecond(B second) {
        this.second = second;
    }
}
