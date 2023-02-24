import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Random;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class CrystalVase extends Thread {
   
    private boolean isSomeoneInTheRoom = false;

    int n = 100;
    void SolveCrystalVase()
    {
        Guest[] arr = new Guest[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Guest();
        }
        Queue<Guest> q = new LinkedList<>();
        
        String name = "threadName";
        Thread t;
        t = new Thread(this, name);
        t.start();

        Random randI = new Random();
        int myRandInt = randI.nextInt(1);
        
        try
        {
            for(int i = 0; i < n; i++)
            {
                myRandInt = randI.nextInt(1);
                if(myRandInt == 1)
                {
                    q.add(arr[i]);
                }
                Thread.sleep(1 / 1000000000);
            }
        }
        catch (InterruptedException e) {
            System.out.println(name + "Interrupted");
        }

        ReentrantLock lock = new ReentrantLock();
        while(q.size() != 0)
        {
            lock.lock();
            try
            {
                Guest removedGuest = q.remove();
                myRandInt = randI.nextInt(9);
                if(myRandInt == 3)
                {
                    q.add(removedGuest);
                }
            }finally
            {
                lock.unlock();
            }
            
        }
    }
    
    public static void main(String args[]) {

        CrystalVase g = new CrystalVase();

        long startTime = Calendar.getInstance().getTimeInMillis();
        g.SolveCrystalVase();
        long endTime = Calendar.getInstance().getTimeInMillis();
        
        System.out.println("Time taken: " + (endTime - startTime) + " ms\n");
    }
    
    
    
    class Guest
    {
        private boolean wantToSeeVaseAgain = false;

        public Guest() {

        }
        public void setWantToSeeVaseAgain(boolean wantToSeeVaseAgain) {
            this.wantToSeeVaseAgain = wantToSeeVaseAgain;
        }
        public boolean wantToSeeVaseAgain() {
            return wantToSeeVaseAgain;
        }
    }
    
    
    
    
    

        
}
