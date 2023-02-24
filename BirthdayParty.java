import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Random;

public class BirthdayParty extends Thread {
    private Boolean isCakeThere = false;
    private Boolean hasEveryoneEntered = false;
    private Boolean isThereSomeoneInTheMaze = false;

    int n = 100;

    int SolveBirthdayParty() {
        Guest[] arr = new Guest[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Guest();
        }

        String name = "threadName";
        Thread t;
        t = new Thread(this, name);
        t.start();

        BirthdayParty thread = new BirthdayParty();
        thread.start();

        Random randI = new Random();
        int myRandInt = randI.nextInt(n);
        int counterLocation = myRandInt;

        arr[counterLocation].setAmITheCounter(true);
        arr[counterLocation].setHaveICalledTheCupcake(true);
        arr[counterLocation].incCounter();

        while (hasEveryoneEntered == false) {

            myRandInt = randI.nextInt(n);
            boolean hastheGuestCalledACake = arr[myRandInt].getHaveICalledTheCupcake();
            try
            {
                if (myRandInt == counterLocation) {
                    if (isCakeThere == true) {
                        arr[counterLocation].incCounter();
                        isCakeThere = false;
                    }
                    if(isCakeThere == false)
                    {
                        if(arr[counterLocation].counter == n)
                        {
                            hasEveryoneEntered = true;
                        }
                    }
                }
                if (isCakeThere == false && hastheGuestCalledACake == false) {
                    isCakeThere = true;
                    arr[myRandInt].setHaveICalledTheCupcake(true);
    
                }
                if (isCakeThere == true && hastheGuestCalledACake == false) {
                    continue;
                }
                Thread.sleep(1/1000000000);

            }catch (InterruptedException e) {
                System.out.println(name + "Interrupted");
            }

            
        }

        return arr[counterLocation].getCounter();

    }

    public static void main(String args[]) {

        BirthdayParty g = new BirthdayParty();
        int howManyGuestEntered = g.SolveBirthdayParty();

        System.out.println(howManyGuestEntered);
    }

    class Guest {
        private boolean haveICalledTheCupcake = false;
        private boolean amITheCounter = false;
        private int counter = 0;

        public Guest() {

        }

        public boolean getAmITheCounter() {
            return amITheCounter;
        }

        public int getCounter() {
            return counter;
        }

        public boolean getHaveICalledTheCupcake() {
            return haveICalledTheCupcake;
        }

        public void setAmITheCounter(Boolean amITheCounter) {
            this.amITheCounter = amITheCounter;
        }

        public void setCounter(int counter) {
            this.counter = counter;
        }

        public void setHaveICalledTheCupcake(Boolean haveICalledTheCupcake) {
            this.haveICalledTheCupcake = haveICalledTheCupcake;
        }

        public void incCounter() {
            this.counter++;
            //System.out.println("Increase counter");
        }
    }
}