import unittest
from checkneighbours import get_same_neighbours_ids

class TestCheckNeighbours(unittest.TestCase):
    def test_middelsteWaarde_wanneerEenBuurGemeenschappelijk_danResultListof1(self):
    # Arrange
        grid = [
            1, 4, 3,
            5, 5, 6,
            4, 4, 1
        ]
        # Act
        result = len(get_same_neighbours_ids(grid, 3, 3, 4))
    
        # Assert
        self.assertEqual(result, 1)  # Compare the result correctly

    
    def test_linkerZijde(self):
        # Arrange
        grid = [
            1, 4, 3,
            4, 4, 6,
            4, 4, 1
        ]
        # Act
        result = get_same_neighbours_ids(grid, 3, 3, 3)
        
        # Assert
        self.assertEqual(result, [1, 4, 6, 7])
        
    def test_controleMiddelsteWaarde_wanneerAlleRechtstreeksteBurenGemeenschappelijk_danResultListof8(self):
        # Arrange
        grid = [
            4, 4, 4,
            4, 4, 4,
            4, 4, 4
        ]
        
        # Act
        result = get_same_neighbours_ids(grid, 3, 3, 4)
        
        # Assert
        self.assertEqual(result, [0, 1, 2, 3, 5, 6, 7, 8])
        
    def test_geenGemeenschappelijkeBuren(self):
        # Arrange
        grid = [
            1, 2, 3,
            4, 5, 6,
            7, 8, 9
        ]
        
        # Act
        result = get_same_neighbours_ids(grid, 3, 3, 4)
        
        # Assert
        self.assertEqual(result, [])
        


    def test_controleHoek(self):
        
        # Arrange
        grid = [
            1, 2, 3,
            4, 1, 4,
            7, 1, 1
        ]
        
        # Act
        result = get_same_neighbours_ids(grid, 3, 3, 8)
        
        # Assert
        self.assertEqual(result, [4, 7])
        

    
    def test_indexOutOfBound(self):
        # Arrange
        grid = [
            1, 2, 3,
            4, 1, 6,
            7, 8, 1
        ]
        
        # Act & Assert
        with self.assertRaises(IndexError):
            get_same_neighbours_ids(grid, 3, 3, 9)  # 9 is out of bounds


if __name__ == '__main__':
    unittest.main()