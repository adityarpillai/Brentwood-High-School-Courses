#!/usr/bin/env python

'''
    Eight Puzzle. 

    A simple command line interface that plays the eight puzzle, where you shift numbers in a grid to keep them in order.
    
    Copyright (C) 2018

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
'''

from termcolor import cprint, colored
import random
from board import Board
from solver import Solver

'''
Main method of the program. Will instantiate the game
'''
def main():
    cprint("Welcome to the Eight Puzzle game.\n\n", "red", attrs=["bold"])
    
    option = option_menu()
    while option == 1:
        print("Entered game...\n\n")
        play_game()
        option = option_menu()
    
'''
Plays a game
='''
def play_game():
    cprint("Enter the size of the board you wish to play (typically use 3)", "red")
    sz = int(input())
    
    # create a random board
    total = pow(sz, 2)

    nums = [num for num in range(total)]
    random.shuffle(nums)
    # print(nums)

    blocks = [[0 for r in range(sz)] for c in range(sz)]
    for num in range(total):
        blocks[int(num / sz)][int(num % sz)] = nums[num]

    cprint("\n\nPlease wait. We are currently checking if this board is solvable. This may take a while since the board is randomly generated...", "blue")
    
    # print(blocks)
    a_board = Board(blocks)
    a_solver = Solver(a_board)
    
    if not a_solver.is_solvable:
        a_board = a_board.twin()
    
    print("This game is solvable in a minimum of " + str(len(a_solver.solution_list)) + " moves.\n\n")

    while not a_board.is_goal():
        a_board = play_round(a_board)
    
    cprint(str(a_board), "red")
    cprint("You won!", "green", attrs=["bold"])


'''
Plays a single round of the game.
'''
def play_round(board):
    cprint(str(board), "red")
    cprint("\n\nEnter the tile you wish to move to the zero space, or enter -1 for a hint.", "blue", attrs=["bold"])
    try:
        num = int(input())
    except ValueError:
        cprint("Invalid move.", "red")
        return board
    print("\n\n")
    if num == -1:
        solver = Solver(board)
        board_comp = solver.solution_list[1]
        cprint("The computer recommends moving the " + str(get_difference(board, board_comp)) + " tile.\n", "blue")
    else:
        for b in board.neighbors():
            if get_difference(board, b) == num:
                return b
        cprint("Invalid move.", "red")
    return board

'''
Returns which tile has moved between the two boards entered.
'''
def get_difference(board_a, board_b):
    # init_r, init_c = 0, 0
    # fin_r, fin_c = 0, 0
    for r in range(board_a.dimension()):
        for c in range(board_a.dimension()):
            if board_a.blocks[r][c] == 0:
                return board_b.blocks[r][c]
    
'''
Menu to select to play or exit the game
'''
def option_menu():
    cprint("Enter 1 to play a game.", "blue")
    cprint("Enter any other key to exit.", "red")
    user_input = input("Enter your option: ")
    if user_input == "1":
        return 1
    return 0


'''
Invokes main method if called directly
'''
if __name__ == "__main__":
    
    main()

