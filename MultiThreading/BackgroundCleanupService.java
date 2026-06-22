public class BackgroundCleanupService {

    static class CleanupDaemon
            extends Thread {

        @Override
        public void run() {

            while (true) {

                try {

                    System.out.println(
                            "Cleaning temporary files...");

                    Thread.sleep(2000);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args)
            throws InterruptedException {

        CleanupDaemon daemon =
                new CleanupDaemon();

        daemon.setDaemon(true);

        daemon.start();

        Thread user1 =
                new Thread(() -> {

                    try {

                        for (int i = 1;
                             i <= 5;
                             i++) {

                            System.out.println(
                                    "User Task 1 Running");

                            Thread.sleep(1000);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        Thread user2 =
                new Thread(() -> {

                    try {

                        for (int i = 1;
                             i <= 7;
                             i++) {

                            System.out.println(
                                    "User Task 2 Running");

                            Thread.sleep(1000);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        user1.start();
        user2.start();

        user1.join();
        user2.join();

        System.out.println(
                "User Threads Finished");
    }
}