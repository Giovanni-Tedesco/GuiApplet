public class QuestionsRepository {

    static Question[] qRepo = {

        new Question("What is the speed of an object of mass of 0.500kg moving at 4.00m/s colliding with another stationary object of mass 3.50kg?", "-3.00m/s", new String[] {"3.00m/s", "-3.00m/s", "1.0m/s", "-1.0m/s"}),
        new Question("A 4.0kg ball moving at 5.0m/s collides with a 2.0kg ball moving at -4.0m/s What is final velocity of the 2.0kg ball?", "8.00m/s", new String[] {"1.0m/s", "-8.00m/s", "8.00m/s", "-4.5m/s"}),
        new Question("On an air table a train of mass 1kg hits a second stationary train of mass 1kg moving at 3m/s. What is the speed of the second train?", "2", new String[] {"0", "2", "3", ""}),
        new Question("", "3", new String[] {"4", "3", "11", "100"}),

    };

    public static Question[] loadRepo() {
        return qRepo;
    }

}