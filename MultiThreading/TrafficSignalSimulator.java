public class TrafficSignalSimulator {

    static class Road extends Thread {

        public Road(String name) {
            super(name);
        }

        @Override
        public void run() {

            for (int i = 1; i <= 3; i++) {

                try {

                    System.out.println(
                            getName()
                                    + " GREEN");

                    Thread.sleep(5000);

                    System.out.println(
                            getName()
                                    + " RED");

                    Thread.yield();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        Road r1 = new Road("Road-1");
        Road r2 = new Road("Road-2");
        Road r3 = new Road("Road-3");

        r1.start();
        r2.start();
        r3.start();
    }
}