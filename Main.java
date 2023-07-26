package MyPackage;




public class Main {
    public static void main(String[] args) {
        // Operation in JDBC
        //  1. Driver Load
        //  2. Connection establish
        //  3. Statement Create
        //  4. Execute Query
        //  5. Connection Close

        JDBC_Commands jdbc = new JDBC_Commands();

//        jdbc.createTable();
//        jdbc.createData();
//        jdbc.readData();
//        jdbc.updateData();
        jdbc.deleteData();

    }

}