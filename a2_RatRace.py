# Do not import any modules. If you do, the tester may reject your submission.

# Constants for the contents of the maze.

# The visual representation of a wall.
WALL = '#'

# The visual representation of a hallway.
HALL = '.'

# The visual representation of a brussels sprout.
SPROUT = '@'

# Constants for the directions. Use these to make Rats move.

# The left direction.
LEFT = -1

# The right direction.
RIGHT = 1

# No change in direction.
NO_CHANGE = 0

# The up direction.
UP = -1

# The down direction.
DOWN = 1

# The letters for rat_1 and rat_2 in the maze.
RAT_1_CHAR = 'J'
RAT_2_CHAR = 'P'


class Rat:
    """ A rat caught in a maze. """

    # Write your Rat methods here.
    def __init__(self, symbol, row, column):
        """(Rat, str, int, int) -> NoneType

        Initialize a Rat with symbol symbol at row row and column column.
        And set its initial number of sprouts eaten num_sprouts eaten at 0.
        
        >>> rat1 = Rat('P', 1, 4)
        >>> rat1.symbol
        'P'
        >>> rat1.row
        1
        >>> rat1.col
        4
        >>> rat1.num_sprouts_eaten
        0
        """
        
        self.symbol = symbol
        self.row = row
        self.col = column
        self.num_sprouts_eaten = 0

    def set_location(self, row, column):
        """(Rat, int, int) -> NoneType

        Set the rat's row and col instance variables to the
        given rown and column.
        
        >>> rat1 = Rat('P', 1, 4)
        >>> rat1.set_location(2, 3)
        >>> rat1. row
        2
        >>> rat1.col
        3
        """

        self.row = row
        self.col = column

    def eat_sprout(self):
        """(Rat) -> NoneType

        Add one to the rat's instance variable num_sprouts_eaten. Eew.
        
        >>> rat1 = Rat('P', 1, 4)
        >>> rat1.num_sprouts_eaten
        0
        >>> rat1.eat_sprout()
        >>> rat1.num_sprouts_eaten
        1
        """

        self.num_sprouts_eaten += 1

    def __str__(self):
        """(Rat) -> str
    
        Return a string representation of the rat in format:
        'symbol at (row, col) ate num_sprouts_eaten sprouts'

        >>> rat1 = Rat('P', 1, 4)
        >>> rat1.set_location(2, 3)
        >>> rat1.eat_sprout()
        >>> rat1.eat_sprout()
        >>> str(rat1)
        'P at (2, 3) ate 2 sprouts'
        """

        return '{0} at ({1}, {2}) ate {3} sprouts.'.format(self.symbol,
                self.row, self.col, self.num_sprouts_eaten)
     

class Maze:
    """ A 2D maze. """

    # Write your Maze methods here.

    def __init__(self, maze, rat_1, rat_2):
        """(Maze, list of list of str, Rat, Rat) - > NoneType

        Initialize the maze with contents maze and the first rat rat_1
        and second rat rat_2. And set the initial number of sprouts
        left num_sprouts_left to the number of SPROUTs in maze.

        >>> M = Maze([['#', '#', '#', '#', '#', '#', '#'],
                 ['#', '.', '.', '.', '.', '.', '#'], 
                 ['#', '.', '#', '#', '#', '.', '#'], 
                 ['#', '.', '.', '@', '#', '.', '#'], 
                 ['#', '@', '#', '.', '@', '.', '#'], 
                 ['#', '#', '#', '#', '#', '#', '#']], 
                 Rat('J', 1, 1),
                 Rat('P', 1, 4))
        >>> M.maze
        [['#', '#', '#', '#', '#', '#', '#'],
        ['#', '.', '.', '.', '.', '.', '#'], 
        ['#', '.', '#', '#', '#', '.', '#'], 
        ['#', '.', '.', '@', '#', '.', '#'], 
        ['#', '@', '#', '.', '@', '.', '#'], 
        ['#', '#', '#', '#', '#', '#', '#']]
        
        """

        self.maze = maze
        self.rat_1 = rat_1
        self.maze[self.rat_1.row][self.rat_1.col] = self.rat_1.symbol
        self.rat_2 = rat_2
        self.maze[self.rat_2.row][self.rat_2.col] = self.rat_2.symbol
        num_sprouts_left = 0
        for i in maze:
            num_sprouts_left += i.count(SPROUT)
        self.num_sprouts_left = num_sprouts_left

        

    def is_wall(self, row, column):
        """(Maze, int, int) -> Bool

        Return True if and only if there is a wall at the given
        row and column of the maze.

        >>> M = Maze([['#', '#', '#', '#', '#', '#', '#'],
                 ['#', '.', '.', '.', '.', '.', '#'], 
                 ['#', '.', '#', '#', '#', '.', '#'], 
                 ['#', '.', '.', '@', '#', '.', '#'], 
                 ['#', '@', '#', '.', '@', '.', '#'], 
                 ['#', '#', '#', '#', '#', '#', '#']], 
                 Rat('J', 1, 1),
                 Rat('P', 1, 4))
        >>> M.is_wall(0, 3)
        True
        >>> M.is_wall(4, 4)
        False
        """

        return self.maze[row][column] == WALL

    def get_character(self, row, column):
        """(Maze, int, int) -> str
        
        Return the character in the maze at the given row and column.
        If there is a rat at that location, then its character
        should be returned rather than HALL.

        >>> M = Maze([['#', '#', '#', '#', '#', '#', '#'],
                 ['#', '.', '.', '.', '.', '.', '#'], 
                 ['#', '.', '#', '#', '#', '.', '#'], 
                 ['#', '.', '.', '@', '#', '.', '#'], 
                 ['#', '@', '#', '.', '@', '.', '#'], 
                 ['#', '#', '#', '#', '#', '#', '#']], 
                 Rat('J', 1, 1),
                 Rat('P', 1, 4))
        >>> M.get_character(3, 4)
        WALL
        >>> M.get_character(2, 6)
        HALL
        """

        char  = self.maze[row][column]

        if char == WALL:
            return WALL
        elif char == HALL:
            return HALL
        elif char == SPROUT:
            return SPROUT
        elif char == RAT_1_CHAR:
            return RAT_1_CHAR
        elif char == RAT_2_CHAR:
            return RAT_2_CHAR

    def move(self, rat, vertical_change, horizontal_change):
        """(Maze, Rat, int, int) -> bool

        The first parameter represents a maze, the second represents a rat,
        the third represents a vertical direction change(UP, NO_CHANGE or
        DOWN),and the fourth represents a horizontal direction change
        (LEFT, NO_CHANGE or RIGHT).

        Move the rat in the given direction, unless there is a wall in the way.
        Also, check for a SPROUTt at that location and, if present:
         - have the rat eat the Brussels sprout,
         - make that location a HALL, and
         - decrease the value that maze.num_sprouts_left refers to by one.

        Return True if and only if there wasn't a wall in the way.
        
        >>> M = Maze([['#', '#', '#', '#', '#', '#', '#'],
                 ['#', '.', '.', '.', '.', '.', '#'], 
                 ['#', '.', '#', '#', '#', '.', '#'], 
                 ['#', '.', '.', '@', '#', '.', '#'], 
                 ['#', '@', '#', '.', '@', '.', '#'], 
                 ['#', '#', '#', '#', '#', '#', '#']], 
                 Rat('J', 1, 1),
                 Rat('P', 1, 4))
        >>>

        """


        end_row = rat.row + vertical_change
        end_column = rat.col + horizontal_change

               
        if self.maze[end_row][end_column] == WALL:
            return False
        elif self.maze[end_row][end_column] == HALL:
            self.maze[rat.row][rat.col] = HALL
            self.maze[end_row][end_column] = rat.symbol
            Rat.set_location(rat, end_row, end_column)
            return True
        elif self.maze[end_row][end_column] == SPROUT:
            Rat.eat_sprout(rat)
            self.maze[rat.row][rat.col] = HALL
            self.maze[end_row][end_column] = rat.symbol
            self.num_sprouts_left -= 1
            Rat.set_location(rat, end_row, end_column)
            return True

        

    def __str__(self):
        """(Maze) -> str

        Return a string representation of the maze, using the format:
        
        #######
        #J..P.#
        #.###.#
        #..@#.#
        #@#.@.#
        #######
        J at (1, 1) ate 0 sprouts.
        P at (1, 4) ate 0 sprouts.

        >>> M = Maze([['#', '#', '#', '#', '#', '#', '#'],
                 ['#', '.', '.', '.', '.', '.', '#'], 
                 ['#', '.', '#', '#', '#', '.', '#'], 
                 ['#', '.', '.', '@', '#', '.', '#'], 
                 ['#', '@', '#', '.', '@', '.', '#'], 
                 ['#', '#', '#', '#', '#', '#', '#']], 
                 Rat('J', 1, 1),
                 Rat('P', 1, 4))
        >>> str(M)
        #######
        #J..P.#
        #.###.#
        #..@#.#
        #@#.@.#
        #######
        J at (1, 1) ate 0 sprouts.
        P at (1, 4) ate 0 sprouts.
        """

        m = []
        for i in self.maze:
            s = ''
            for j in i:
                s += j
            m.append(s)
            


        return '{0}\n{1}\n{2}'.format("\n".join(m), str(self.rat_1), str(self.rat_2))


