class Jalebi{
    private static Jalebi jalebi=new Jalebi();
    public static Jalebi getJalebi(){
        return jalebi;
    }
}
public class Singleton_eager {
    public static void main(String[] args) {
        System.out.println(Jalebi.getJalebi().hashCode());
        System.out.println(Jalebi.getJalebi().hashCode());
    }
}
