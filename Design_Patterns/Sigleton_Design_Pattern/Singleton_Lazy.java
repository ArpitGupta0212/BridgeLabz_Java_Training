import java.lang.reflect.Constructor;

class Samosa {
    private static Samosa samosa;

    private Samosa() {
        if (samosa != null) {
            throw new RuntimeException("You are trying to break Singleton pattern");
        }
    }

    public static Samosa getObject() {
        if (samosa == null) {
            synchronized (Samosa.class) {
                if (samosa == null) {
                    samosa = new Samosa();
                }
            }

        }
        return samosa;
    }
}

public class Singleton_Lazy {
    public static void main(String[] args) throws Exception {
        Samosa samo = Samosa.getObject();
        System.out.println(samo.hashCode());
        Constructor<Samosa> constructor = Samosa.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Samosa s2 = constructor.newInstance();

        // Samosa samo2=Samosa.getObject();

        System.out.println(s2.hashCode());
    }
}

// 1. Constructor Private
// 2. object create with the help of method public static
// 3. create private static variable to store object
