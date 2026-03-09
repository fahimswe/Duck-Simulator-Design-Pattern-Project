import java.util.Scanner;

public class DuckSimulator {

    static AbstractDuckFactory factory = new CountingDuckFactory();
    static Flock flock = new Flock();
    static Quackologist observer = new Quackologist();

    public static void main(String[] args) {

        initializeSystem();

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            printHeader();
            printMenu();

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    simulateFlock();
                    break;
                case 2:
                    showTotalQuacks();
                    break;
                case 3:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

            pause();

        } while (choice != 3);

        sc.close();
    }

    static void initializeSystem() {

        flock.add(factory.createMallardDuck());
        flock.add(factory.createRedheadDuck());
        flock.add(factory.createDuckCall());
        flock.add(factory.createRubberDuck());

        flock.registerObserver(observer);
    }

    static void printHeader() {
        System.out.println("\n=================================================");
        System.out.println("           🦆 DUCK MONITORING SYSTEM 🦆");
        System.out.println("=================================================");
    }

    static void printMenu() {
        System.out.println("1️⃣  Simulate Flock");
        System.out.println("2️⃣  Show Total Quacks");
        System.out.println("3️⃣  Exit");
        System.out.println("-------------------------------------------------");
    }

    static void simulateFlock() {

        System.out.println("\n🚀 Starting Simulation...\n");

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flock.quack();
    }

    static void showTotalQuacks() {
        System.out.println("\n📊 TOTAL QUACKS RECORDED: "
                + QuackCounter.getQuacks());
    }

    static void pause() {
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}