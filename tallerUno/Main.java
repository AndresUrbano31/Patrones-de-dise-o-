// BikeSystem.java
class BikeSystem {
    
    // 1. Static variable that holds the single instance
    private static BikeSystem instance = null;
    
    // 2. Regular attributes
    private int totalBikes;
    private int availableBikes;
    
    // 3. PRIVATE constructor (nobody can do "new BikeSystem()")
    private BikeSystem() {
        this.totalBikes = 10;
        this.availableBikes = 10;
        System.out.println("✅ System created with 10 bikes");
    }
    
    // 4. Public method to get the instance
    public static BikeSystem getInstance() {
        if (instance == null) {
            instance = new BikeSystem();
        }
        return instance;
    }
    
    // 5. Regular methods
    public void lendBike(String student) {
        if (availableBikes > 0) {
            availableBikes--;
            System.out.println("🚲 " + student + " took a bike. Remaining: " + availableBikes);
        } else {
            System.out.println("❌ " + student + " - No bikes available");
        }
    }
    
    public void returnBike(String student) {
        availableBikes++;
        System.out.println("✅ " + student + " returned a bike. Remaining: " + availableBikes);
    }
    
    public void showStatus() {
        System.out.println("\n--- CURRENT STATUS ---");
        System.out.println("Total: " + totalBikes);
        System.out.println("Available: " + availableBikes);
        System.out.println("In use: " + (totalBikes - availableBikes));
        System.out.println("--------------------\n");
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        
        System.out.println("=== BIKE SYSTEM ===\n");
        
        // Three students try to access the system
        BikeSystem system1 = BikeSystem.getInstance();
        BikeSystem system2 = BikeSystem.getInstance();
        BikeSystem system3 = BikeSystem.getInstance();
        
        // I test that they are the same object
        System.out.println("Are system1 and system2 the same? " + (system1 == system2));
        System.out.println("Are system2 and system3 the same? " + (system2 == system3));
        System.out.println();
        
        // Initial status
        system1.showStatus();
        
        // Students request bikes (I use any "system" because they're all the same)
        system1.lendBike("Carlos");
        system2.lendBike("Ana");
        system3.lendBike("Luis");
        
        // I show the status from any variable
        system1.showStatus();
        
        // They return bikes
        system1.returnBike("Carlos");
        system2.returnBike("Ana");
        
        // Final status
        system3.showStatus();
        
        System.out.println("✓ Everyone uses the same information!");
    }
}