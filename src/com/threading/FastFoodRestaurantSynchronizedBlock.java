package com.threading;

public class FastFoodRestaurantSynchronizedBlock {

    private String lastClientName;

    private int numberOfBurgersSold;

    public String getLastClientName() {
        return lastClientName;
    }

    public void setLastClientName(String lastClientName) {
        this.lastClientName = lastClientName;
    }

    public int getNumberOfBurgersSold() {
        return numberOfBurgersSold;
    }

    public void setNumberOfBurgersSold(int numberOfBurgersSold) {
        this.numberOfBurgersSold = numberOfBurgersSold;
    }



    public void buyBurgers(String clientName){
        alongRunningProcess();
        synchronized (this){
            this.lastClientName = clientName;
            numberOfBurgersSold++;
            System.out.println(clientName + " bought a burger");
        }
    }

    public void alongRunningProcess (){
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        FastFoodRestaurantSynchronizedBlock fastFoodRestaurant = new FastFoodRestaurantSynchronizedBlock();
        Thread t1 = new Thread(()->{
            fastFoodRestaurant.buyBurgers("Mike");
        });

        Thread t2 = new Thread(()->{
            fastFoodRestaurant.buyBurgers("Sarah");
        });

        Thread t3 = new Thread(()->{
            fastFoodRestaurant.buyBurgers("Nick");
        });

        Thread t4 = new Thread(()->{
            fastFoodRestaurant.buyBurgers("Amy");
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("Total number of burgers sold: "+ fastFoodRestaurant.getNumberOfBurgersSold());

        System.out.println("Last client name: " + fastFoodRestaurant.getLastClientName());

        System.out.println("Total execution time: " + (System.currentTimeMillis() - startTime) + " in ms");
    }
}
