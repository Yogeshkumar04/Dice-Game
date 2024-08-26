**Dice Game**

This is a simple two-player dice game built with Kotlin and Jetpack Compose. The game allows two players to take turns rolling a dice, and the first player to reach or exceed a score of 20 wins the game.

**Features**

Two-Player Mode: The game supports two players who take turns rolling the dice.
Score Tracking: The current scores of both players are displayed on the screen.
Turn Indicator: The game displays whose turn it is to roll the dice.
Winning Condition: The first player to reach or exceed a score of 20 wins the game.
Play Again: After the game ends, players have the option to reset the scores and start a new game.


**How to Play**

The game starts with Player 1's turn.
Player 1 clicks the "Player 1" button to roll the dice.
The rolled dice will be displayed, and the score will be added to Player 1's total score.
The turn will switch to Player 2.
Player 2 clicks the "Player 2" button to roll the dice.
The rolled dice will be displayed, and the score will be added to Player 2's total score.
The game continues until one player reaches or exceeds a score of 20.
The winning player is announced, and the option to play again is provided.



**Code Overview**

Main Code
The core of the game is implemented in the DiceGameScreen composable function:

**State Management:** The game uses remember and mutableStateOf to manage the scores, current dice image, and the player's turn.
Dice Rolling: A random number between 1 and 6 is generated to simulate rolling the dice.

**Image Display:** The corresponding dice image is displayed based on the random number.

**Game Logic:** To determine the winner, The game checks if either player's score has reached or exceeded 20.

**Resetting the Game**
Players can click the "Play Again" button to reset the scores and start a new game when the game ends.

