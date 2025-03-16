package be.ses;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import org.junit.jupiter.api.Test;

class CheckNeighboursInGridTest {

    @Test
    void controleMiddelsteWaarde_wanneerEenBuurGemeenschappelijk_danResultListOf1() {
        // Arange
        List<Integer> grid = List.of(
            1, 2, 3,
            3, 2, 6,
            7, 8, 9
        );
        int width = 3;
        int height = 3;
        int indexToCheck = 4;

        // Act
        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);

        // 
        assertIterableEquals(List.of(1), result);
    }

    @Test
    void controleMiddelsteWaarde_wanneerAlleBurenGelijk_danResultListOf4() {
        // Arange
        List<Integer> grid = List.of(
            1, 2, 3,
            2, 2, 2,
            7, 2, 9
        );
        int width = 3;
        int height = 3;
        int indexToCheck = 4;

        // Act
        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);

        // 
        assertIterableEquals(List.of(1, 3, 5, 7), result);
    }

    @Test
    void testRechterZijde() {

        List<Integer> grid = List.of(
            1, 2, 7,
            4, 5, 7,
            7, 8, 7
        );
        int width = 3;
        int height = 3;
        int indexToCheck = 5;

        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);

        assertIterableEquals(List.of(2, 8), result);
    }

    @Test
    void controleHoek() {

        List<Integer> grid = List.of(
            5, 2, 7,
            4, 5, 7,
            4, 8, 7
        );
        int width = 3;
        int height = 3;
        int indexToCheck = 6;

        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);

        assertIterableEquals(List.of(3), result);
    }

    @Test
    void geenGemeenschappelijkeBuren() {

        List<Integer> grid = List.of(
            1, 2, 3,
            4, 5, 6,
            7, 8, 9
        );
        int width = 3;
        int height = 3;
        int indexToCheck = 1;

        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);

        assertIterableEquals(List.of(), result);
    }

    

    @Test
    void testInvalidIndexThrowsException() {
        // Arrange: Setup grid en index
        List<Integer> grid = List.of(
            1, 2, 3,
            4, 5, 6,
            7, 8, 9
        );
        int width = 3;
        int height = 3;
        int indexToCheck = 10; // Ongeldige index buiten de grid

        // Act & Assert: Verwacht een IndexOutOfBoundsException
        Throwable thrown = catchThrowable(() -> {
            CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToCheck);
        });

        // Assert: Controleer of de juiste exception wordt gegooid en de juiste boodschap bevat
        assertThat(thrown)
            .isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("Index " + indexToCheck + " out of bounds for length " + grid.size()); // Waarom kan hier niet gewoon "Index out of bounds" staan?
    }

}