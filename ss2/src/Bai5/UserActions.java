package Bai5;

interface UserActions {

    default void logActivity(String activity) {
        System.out.println("User Activity: " + activity);
    }

}
