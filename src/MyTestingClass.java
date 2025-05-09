public class MyTestingClass {
    private String name;
    private int id;

    public MyTestingClass(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int hashCode() {
        String strKey = name + id; // Используем поля объекта
        int hash = 0;
        int p = 31;
        int m = 1_000_000_009;

        for (int i = 0; i < strKey.length(); i++) {
            hash = (int)((hash * p + strKey.charAt(i)) % m);
        }

        return hash;
    }


    @Override
    public String toString() {
        return name + ": " + id;
    }
}
