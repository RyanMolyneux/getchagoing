package getchagoing.library.algorithms.sorting;

import java.util.List;
import java.util.ArrayList;

public class MergeSort {

    /**
     * Algorithm: sortSequenceOfItems
     * 1. Input sequenceOfItems
     * 2. Input startIndexOfSequence
     * 3. Input endIndexOfSequence
     * 4. if startIndexOfSequence < endIndexOfSequence then
     *    4.1 middleIndexOfSequence <- (startIndexOfSequence + endIndexOfSequence)/2
     *    4.2 sortSequenceOfItems( sequenceOfItems, startIndexOfSequence, middleIndexOfSequence )
     *    4.3 sortSequenceOfItems( sequenceOfItems, (middleIndexOfSequence + 1), endIndexOfSequence)
     *    4.4 mergeSortedSubsequences( sequenceOfItems, startIndexOfSequence, middleIndexOfSequence, endIndexOfSequence )
     * 5. Output null
     */
    public static <T extends Comparable<T>> void sortSequenceOfItems(List<T> sequenceOfItems, int startIndexOfSequence, int endIndexOfSequence ) {

       if ( startIndexOfSequence < endIndexOfSequence ) {

          int middleIndexOfSequence = ( startIndexOfSequence + endIndexOfSequence ) / 2;

          sortSequenceOfItems( sequenceOfItems, startIndexOfSequence, middleIndexOfSequence );
          sortSequenceOfItems( sequenceOfItems, (middleIndexOfSequence + 1), endIndexOfSequence );
          mergeSortedSubsequences( sequenceOfItems, startIndexOfSequence, middleIndexOfSequence, endIndexOfSequence );

       }

    }

    /**
     * Algorithm: mergeSortedSubsequences
     * 1. Input sequenceOfItems  { a sequence of items containing subsequences that need to be merged in sorted order. }
     * 2. Input startIndexOfSequence
     * 3. Input middleIndexOfSequence
     * 4. Input endIndexOfSequence
     * 5. subsequence1Length <- (middleIndexOfSequence - startIndexOfSequence) + 1
     * 6. subsequence2Length <- (endIndexOfSequence - middleIndexOfSequence)
     * 7. subsequence1 <- { new instance of a sequence(array, list, etc... whatever you want) of length subsequence1Length. }
     * 8. subsequence2 <- { new instance of a sequence(array, list, etc...  indeed it can be whatever you desire based of this pesudo code) of length subsequence2Length. }
     * 9. i <- 0
     * 10. while i < subsequence1Length and i < subsequence2Length do
     *    10.1 if i < subsequence1Length then;
     *       10.1.1 subsequence1[i] <- sequenceOfItems[ (startIndexOfSequence + i) ]
     *    10.2 if i < subsequence2Length then;
     *       10.2.1 subsequence2[i] <- sequenceOfItems[ ( (middleIndexOfSequence + 1) + i ) ]
     *    10.3 i <- i + 1
     * 11. subsequence1CurrentIndex <- 0
     * 12. subsequence2CurrentIndex <- 0
     * 12. while subsequence1CurrentIndex < subsequence1Length and subsequence2CurrentIndex < subsequence2Length do
     *    12.1 if subsequence1[subsequence1CurrentIndex] < subsequence2[subsequence2CurrentIndex] then;
     *        12.1.1 sequenceOfItems[startIndexOfSequence] <- subsequence1[subsequence1CurrentIndex]
     *        12.1.2 subsequence1CurrentIndex <- subsequence1CurrentIndex + 1
     *    12.2 else
     *        12.2.1 sequenceOfItems[startIndexOfSequence] <- subsequence2[subsequence2CurrentIndex]
     *        12.2.2 subsequence2CurrentIndex <- subsequence2CurrentIndex + 1
     *    12.3 startIndexOfSequence <- startIndexOfSequence + 1
     * 13. while subsequence1CurrentIndex < subsequence1Length do
     *    13.1 sequenceOfItems[startIndexOfSequence] <- subsequence1[subsequence1CurrentIndex]
     *    13.2 startIndexOfSequence <- startIndexOfSequence + 1
     * 14. while subsequence2CurrentIndex < subsequence2Length do
     *    14.1 sequenceOfItems[startIndexOfSequence] <- subsequence2[subsequence2CurrentIndex]
     *    14.2 startIndexOfSequence <- startIndexOfSequence + 1
     * 15. Output null
     */

    public static <T extends Comparable<T>> void mergeSortedSubsequences(List<T> sequenceOfItems, int startIndexOfSequence, int middleIndexOfSequence, int endIndexOfSequence) {

        int subsequence1Length = (middleIndexOfSequence - startIndexOfSequence) + 1;
        int subsequence2Length = (endIndexOfSequence - middleIndexOfSequence);
        int subsequence1CurrentIndex = 0;
        int subsequence2CurrentIndex = 0;
        List<T> subsequence1 = new ArrayList<T>(subsequence1Length);
        List<T> subsequence2 = new ArrayList<T>(subsequence2Length);


        for (int i = 0; i < subsequence1Length || i < subsequence2Length; i++) {

            if ( i < subsequence1Length ) {

               subsequence1.add( sequenceOfItems.get( (startIndexOfSequence + i) ) );

            }

            if ( i < subsequence2Length ) {

               subsequence2.add( sequenceOfItems.get( ( (middleIndexOfSequence + 1) + i) ) );

            }

        }


        while ( subsequence1CurrentIndex < subsequence1Length && subsequence2CurrentIndex < subsequence2Length ) {

            if ( subsequence1.get(subsequence1CurrentIndex).compareTo( subsequence2.get(subsequence2CurrentIndex) ) < 0 ) {

                sequenceOfItems.set( startIndexOfSequence, subsequence1.get(subsequence1CurrentIndex) );
                subsequence1CurrentIndex++;

            } else {

                sequenceOfItems.set( startIndexOfSequence, subsequence2.get(subsequence2CurrentIndex) );
                subsequence2CurrentIndex++;

            }

            startIndexOfSequence++;

        }


        while ( subsequence1CurrentIndex < subsequence1Length ) {

            sequenceOfItems.set( startIndexOfSequence, subsequence1.get(subsequence1CurrentIndex) );
            subsequence1CurrentIndex++;
            startIndexOfSequence++;

        }

        while ( subsequence2CurrentIndex < subsequence2Length ) {

            sequenceOfItems.set( startIndexOfSequence, subsequence2.get(subsequence2CurrentIndex) );
            subsequence2CurrentIndex++;
            startIndexOfSequence++;

        }
    }

}
