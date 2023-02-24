To Compile through CMDPROMPT

Type javac ./BirthdayParty.java
Type java BirthdayParty This should compile the program and run 100 guest.

Type javac ./CrystalVase.java
Type java CrystalVase This should compile the program and run 100 guest.

Documentation

Problem 1)
  For problem 1 the solution that I programmed was to make sure that only one person can eat the cupcake meaning that all of the other guest will either leave the cupcake plate empty if they haven't eaten it or they will make sure to only call for the cupcake once. This means that there is only one person that going to be keeping count of the people that enter. This means that one person will be able to tell the minotaur that everyone has entered the maze solving the maze. The threading is used for each person but since you can only start the thread once. The thread is used for when the guest enters the maze. The proof of correction is to correct 
  
Problem 2)
  For problem 2 the solution that I choose was solution 3 because it was the easiest to code. The solution had to just account of the fact that a guest would want to come back and look at the vase again after their first encounter with the Vase. The reason for choosing the third choice was that I assume that there was first a 50% chance that someone wanted to see the vase. The next assumation that I maded was that after the first viewing of the vase there was a 10% chance that they want to see the vase again. So that means the while loop will keep going until all the guest don't want to see the vase anymore. I also used a lock to make sure that they can only view the vase one at a time but they are able to queue to see the vase constantly.
