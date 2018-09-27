package company.database;

public class Statements
{

    public static final String SQL_GET_CATEGORY_FROM_ID = "SELECT * FROM category where id = ?;";
    public static final String SQL_GET_PARTIPANTS = "SELECT id, name, surname, dob, category FROM participant;";
    public static final String SQL_GET_TIMES_FROM_PARTICIPANT = "SELECT * FROM times WHERE participant = ?;";

}
