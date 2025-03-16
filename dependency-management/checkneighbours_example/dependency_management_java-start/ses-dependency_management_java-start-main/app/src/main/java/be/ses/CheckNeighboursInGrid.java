package be.ses;

import java.util.ArrayList;
import java.util.List;

public class CheckNeighboursInGrid {

    /**
    * This method takes a 1D Iterable and an element in the array and gives back an iterable containing the indexes of all neighbours with the same value as the specified element
    *@return - Returns a 1D Iterable of ints, the Integers represent the indexes of all neighbours with the same value as the specified element on index 'indexToCheck'.
    *@param grid - This is a 1D Iterable containing all elements of the grid. The elements are integers.
    *@param width - Specifies the width of the grid.
    *@param height - Specifies the height of the grid (extra for checking if 1D grid is complete given the specified width)
    *@param indexToCheck - Specifies the index of the element which neighbours that need to be checked
    */

    public static Iterable<Integer> getSameNeighboursIds(Iterable<Integer> grid,int width, int height, int indexToCheck){
        List<Integer> neighboursWithSameValue = new ArrayList<>();
        List<Integer> gridList = new ArrayList<>();
        grid.forEach(gridList::add);
        
        int valueToCheck = gridList.get(indexToCheck);
        int row = indexToCheck / width;
        int col = indexToCheck % width;

        if (indexToCheck < 0 || indexToCheck >= gridList.size()) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        if (row > 0 ) {
            if (gridList.get(indexToCheck - width) == valueToCheck) {
                neighboursWithSameValue.add(indexToCheck - width);
            }
        }

        if (row < height - 1) {
            if (gridList.get(indexToCheck + width) == valueToCheck) {
                neighboursWithSameValue.add(indexToCheck + width);
            }
        }

        if (col > 0) {
            if (gridList.get(indexToCheck - 1) == valueToCheck) {
                neighboursWithSameValue.add(indexToCheck - 1);
            }
        }

        if (col < width - 1) {
            if (gridList.get(indexToCheck + 1) == valueToCheck) {
                neighboursWithSameValue.add(indexToCheck + 1);
            }
        }

        return neighboursWithSameValue;
    }
}