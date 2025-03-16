package be.ses;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import org.junit.jupiter.api.Test;

class CheckNeighboursInGridTest {

    @Test
    void testNeighboursInMiddle() {
        
        List<Integer> grid = List.of(
            1, 2, 3,
            4, 2, 6,
            7, 8, 9
        );
        int width = 3;
        int height = 3;
        int indexToCheck = 4;

        
        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);

        
        assertIterableEquals(List.of(1), result);
    }
}