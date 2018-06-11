import copy
from pprint import pprint
from functools import total_ordering

'''
# * Board object that takes the form of a board[r][c] where r is the row number and c is the column number.

    Can be called upon with the __init__ defined method to create a board object.

# * Contains the Manhattan method for the A* search algorithm. The lower the Manhattan, the closer it is to the goal.
        
'''
# @total_ordering
class Board:

    blocks = None
    cached_manhattan = -1
    cached_dimension = -1
    cached_hash = -1
    
    '''
    Initializes the board object.
    '''
    def __init__(self, blocks):
        self.blocks = copy.deepcopy(blocks)        



    '''
    Returns a twin. Either self or the return Board will be a valid board to solve
    '''
    def twin(self):
        new_blocks = [[0 for x in range(self.dimension())] for y in range(self.dimension())]

        for row in range(0, self.dimension()):
            new_blocks[row] = copy.deepcopy(self.blocks[row])

        for row in new_blocks:
            if self.replace_two(row):
                break
    
        return Board(new_blocks)
    
    '''
    Switches the place of two consecutive numbers in an array
    '''
    @staticmethod
    def replace_two(arr):
        for c in range(len(arr) - 1):
            if arr[c] != 0 and arr[c + 1] != 0:
                temp = arr[c]
                arr[c] = arr[c + 1]
                arr[c + 1] = temp
                return True
        return False

    '''
    Returns the dimension of the board
    '''
    def dimension(self):            
        if self.cached_dimension == -1:
            self.cached_dimension = int(len(self.blocks))
        return self.cached_dimension
        
    '''
    Calculates the Manhattan value for the board.

    Returns the sum of vertical and horizontal distances that every block is away from where it should be.
    '''
    def manhattan(self):
        if self.cached_manhattan == -1:
            self.cached_manhattan = 0
            for row in range(self.dimension()):
                for col in range(self.dimension()):
                    if self.blocks[row][col] != 0:
                        num = self.blocks[row][col]
                        c_row = self.correct_row(num)
                        c_col = self.correct_col(num)
                        self.cached_manhattan += abs(c_row - row) + abs(c_col - col)
        return self.cached_manhattan

    '''
    Returns the row value of where the inputted number should be
    '''
    def correct_row(self, num):
        return int((num - 1) / self.dimension())

    
    '''
    Returns the column value of where the inputted number should be
    '''
    def correct_col(self, num):
        return int((num - 1) % self.dimension())


    '''
    Returns the number that should be at the row, col pairing
    '''
    def correct_num(self, row, col):
        if row == self.dimension() - 1 and col == self.dimension() - 1:
            return 0 # * Returns 0 if it is the very last block
        return (row * self.dimension()) + (col + 1)


    '''
    Returns the goal board for this dimension of board
    '''
    def goal_board(self):
        arr = [[0 for row in range(self.dimension())] for col in range(self.dimension())]
        for row in range(self.dimension()):
            for col in range(self.dimension()):
                arr[row][col] = self.correct_num(row, col)
        return Board(arr)

    '''
    Returns if one board is the exact same as the other
    '''
    def deep_board_equals(self, board_b):
        # Will return false if the dimensions of each are not the same
        if self.dimension() != board_b.dimension():
            return False

        # Caches the value for dimension so that it is not repetitively called
        # for row in range(self.dimension()):
        #     for col in range(self.dimension()):
        #         # If any two blocks are not the same, immediately return false
        #         if self.blocks[row][col] != board_b.blocks[row][col]:
        #             return False

        return self.blocks == board_b.blocks
        
        # Otherwise, return true
        # return True
        
    '''
    Returns true if this board is the goal board
    '''
    def is_goal(self):
        return self.deep_board_equals(self.goal_board())


    '''
    Returns a list of all possible moves
    '''
    def neighbors(self):
        # Initialize list of neighbor Boards that can be cycled through
        neighbors = []
        
        # Store the row and col values of the empty/0 tile
        row = 0
        col = 0
        

        # To store whether the place of the empty slot has been found
        found0 = False

        for r in range(self.dimension()):
            for c in range(self.dimension()):
                if self.blocks[r][c] == 0:
                    row = r
                    col = c
                    found0 = True
                if found0:
                    break
            if found0: 
                break

        # print("Found 0 at " + str(row) + " " + str(col))
        tempBlocks = [[0 for r in range(self.dimension())] for c in range(self.dimension())]

        if row > 0:
            # Swap upwards
            tempBlocks = self.deep_copy_blocks(self.blocks)
            temp = tempBlocks[row - 1][col]
            tempBlocks[row - 1][col] = tempBlocks[row][col]
            tempBlocks[row][col] = temp
            neighbors.append(Board(tempBlocks))
        if row < self.dimension() - 1:
            # Swap downwards
            tempBlocks = self.deep_copy_blocks(self.blocks)
            temp = tempBlocks[row + 1][col]
            tempBlocks[row + 1][col] = tempBlocks[row][col]
            tempBlocks[row][col] = temp
            neighbors.append(Board(tempBlocks))
        if col > 0:
            # Swap left
            tempBlocks = self.deep_copy_blocks(self.blocks)
            temp = tempBlocks[row][col - 1]
            tempBlocks[row][col - 1] = tempBlocks[row][col]
            tempBlocks[row][col] = temp
            neighbors.append(Board(tempBlocks))        
        if col < self.dimension() - 1:
            # Swap right
            tempBlocks = self.deep_copy_blocks(self.blocks)
            temp = tempBlocks[row][col + 1]
            tempBlocks[row][col + 1] = tempBlocks[row][col]
            tempBlocks[row][col] = temp
            neighbors.append(Board(tempBlocks))   
        return neighbors

    '''
    Return hash of array of blocks
    '''
    def hash(self):
        if self.cached_hash == -1:
            cached_hash = hash(str(self.blocks))
        return cached_hash
    
    def __hash__(self):
        return self.hash()
    '''
    Compare two boards using equals
    '''
    def __eq__(self, other):
        # for r in range(self.dimension()):
        #     for c in range(self.dimension()):
        #         if self.blocks[r][c] != other.blocks[r][c]:
        #             return False
        # return True
        return self.hash() == other.hash()

    '''
    Compare two
    '''
    def __lt__(self, other):
        # for r in range(self.dimension()):
        #     for c in range(self.dimension()):
        #         if self.blocks[r][c] < other.blocks[r][c]:
        #             return True
        # return False
        return self.hash() < other.hash()

    def __le__(self, other):
        return self.hash() <= other.hash()

    def __gt__(self, other):
        return self.hash() > other.hash()

    def __ge__(self, other):
        return self.hash() >= other.hash()

    def __ne__(self, other):
        return self.hash() != other.hash()
    '''
    Returns a string for print methods, etc.
    '''
    def __str__(self):
        result = ""
        for row in range(self.dimension()):
            for col in range(self.dimension()):
                if(self.blocks[row][col] == 0):
                    result += " \t"
                else:
                    result += "" + str(self.blocks[row][col]) + "\t"
            result += "\n"
        return result

    # def __repr__(self):
    #     return self.__str__()
    
    '''
    Returns a new object 2d array of the blocks
    '''
    @staticmethod
    def deep_copy_blocks(blocks):
        return copy.deepcopy(blocks)
'''
Unit testing
'''
if __name__ == "__main__":
    blocks = [[1, 2, 3],
            [4, 5, 6],
            [7, 8, 0]]
    board_a = Board(blocks)
    print(board_a)
    print("Neighbors: \n")
    for board in board_a.neighbors():
        print(str(board))

