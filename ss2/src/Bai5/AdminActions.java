package Bai5;

interface AdminActions {

    default void logActivity(String activity) {
        System.out.println("Admin Activity: " + activity);
    }

}