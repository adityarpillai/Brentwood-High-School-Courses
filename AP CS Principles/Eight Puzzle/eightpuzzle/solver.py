'''
Solver for the eight-puzzle using the A* algorithm. Creates the Solver class that can be used to list the solution given that is_solvable is True.

Also utilizes a class called search_node that is used for prioritizing in the heap.
'''


import heapq
from functools import total_ordering 
from board import Board

# temporary for testing
import time, datetime
class Solver:

    solution_list = []
    is_solvable = False 

    def __init__(self, board):
        
        sn = Search_Node(board, None)
        sn_twin = Search_Node(board.twin(), None)

        # Runs a quick check to see if current board is solution
        if sn.board.is_goal():
            self.solution_list.append(sn)
            self.is_solvable = True
            return
        elif sn_twin.board.is_goal():
            self.is_solvable = False
            return

        # Keeps a constant record of what is added (nothing will be removed)
        added = set()
        added_twin = set()
        added.add(sn.board)
        added_twin.add(sn_twin.board)
    
        # Priority queue for A* search
        min_PQ = []
        min_PQ_twin = []

        # Add first two items
        heapq.heappush(min_PQ, sn)
        heapq.heappush(min_PQ_twin, sn_twin)
        
        count = 1

        while not (sn.board.is_goal() or sn_twin.board.is_goal()):
            
            # print("Count: " + str(count))
            
            # Pop off the least priority searchnode
            sn = heapq.heappop(min_PQ)
            sn_twin = heapq.heappop(min_PQ_twin)
            
            # if count % 13 == 0:
            print("Searching... On iteration #" + str(count) + "\r", end="")

            # Move the original board
            for b in sn.board.neighbors():
                sn_new = Search_Node(b, sn)
                # print(sn_new.board)
                # print(sn_new.board.dimension())
                if sn_new.board not in added:
                    heapq.heappush(min_PQ, sn_new)
                    added.add(sn_new.board)
                    # heapq.heappush(added, sn_new.board)
                
            
            # Move the twin board
            for b_twin in sn_twin.board.neighbors():
                sn_new_twin = Search_Node(b_twin, sn_twin)
                if sn_new_twin.board not in added_twin:
                    heapq.heappush(min_PQ_twin, sn_new_twin)
                    added_twin.add(sn_new_twin.board)
                    # heapq.heappush(added, sn_new_twin.board)

            count += 1

        print("Calculated solvability on iteration #" + str(count) + ".\n\n")


        # If the twin board is the goal, this is a nonsolvable puzzle
        if sn_twin.board.is_goal():
            self.is_solvable = False
            while sn_twin is not None:
                self.solution_list.insert(0, sn_twin.board)
                sn_twin = sn_twin.previous
            return

        self.is_solvable = True
        while sn is not None:
            self.solution_list.insert(0, sn.board)
            sn = sn.previous
        


class Search_Node:

    board = None
    previous = None
    moves = 0

    cached_priority = -1

    def __init__(self, board, previous):
        self.board: Board = board
        self.previous: Search_Node = previous
        if previous is not None:
            self.moves = 1 + previous.moves

    def priority(self):
        if self.cached_priority == -1:
            self.cached_priority = self.moves + self.board.manhattan()
        return self.cached_priority

    '''
    Compare less than for two boards
    '''
    def __lt__(self, other):
        return self.priority() < other.priority()

    def __le__(self, other):
        return self.priority() <= other.priority()

    def __gt__(self, other):
        return self.priority() > other.priority()

    def __ge__(self, other):
        return self.priority() >= other.priority()

    def __ne__(self, other):
        return self.priority() != other.priority()
    
    '''
    Compare two boards using equals
    '''
    def __eq__(self, other):
        return self.priority() == other.priority()
    


'''
Unit testing
'''
if __name__ == "__main__":
    # # blocks = [[0, 12, 9, 13],
    #             [15, 11, 10, 14],
    #             [3, 7, 5, 6],
    #             [4, 8, 2, 1]]
    print("Starting...")
    start = datetime.datetime.now()

    blocks = [  [0, 12, 9, 13],
                [15, 11, 10, 14],
                [3, 7, 5, 6],
                [4, 8, 2, 1]]
    board_a = Board(blocks)
    
    s: Solver = Solver(board_a)
    print(len(s.solution_list))

    count = 1
    for board in s.solution_list:
        print("Step #" + str(count))
        print(board)
        count += 1
    
    end = datetime.datetime.now()

    print("Finished in " + str((end - start).total_seconds()))

    # print(s.is_solvable)
    # i = 1
    # for board in s.solution_list:
    #     print("Step " + str(i))
    #     print(board)
    #     i += 1
    # print(len(s.solution_list) - 1)

