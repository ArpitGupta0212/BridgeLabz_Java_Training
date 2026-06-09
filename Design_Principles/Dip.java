interface Database {

    void save();
}

class MySQLDatabase implements Database {

    public void save() {
        System.out.println("Saved in MySQL");
    }
}

class OracleDatabase implements Database {

    public void save() {
        System.out.println("Saved in Oracle");
    }
}

class StudentService {

    private Database db;

    public StudentService(Database db) {
        this.db = db;
    }

    public void saveStudent() {

        db.save();
    }
}

public class Dip {
    public static void main(String[] args) {
        Database database = new MySQLDatabase();

        StudentService service = new StudentService(database);

        service.saveStudent();
    }
}
