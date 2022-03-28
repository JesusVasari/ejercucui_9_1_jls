import java.sql.Connection
import java.sql.Date
import java.sql.DriverManager


data class catalogo(val id: Int, val autor: String, val genero:String,
                    val precio:Double, val fecha : Date, val des:String)


fun main(args: Array<String>) {
    val acceso = "jdbc:oracle:thin:@localhost:1521/XE"

    // get the connection
    val connection = DriverManager
        .getConnection(acceso, "alumno", "alumno")

    println(connection.isValid(0))

    // the query is only prepared not executed
    val query = connection.prepareStatement("SELECT * FROM libros")

    // the query is executed and results are fetched
    val result = query.executeQuery()

    // an empty list for holding the results
    val users = mutableListOf<catalogo>()

    while (result.next()) {

        // getting the value of the id column
        val id = result.getInt("ID")

        // getting the value of the name column
        val name = result.getString("AUTOR")

        val gen = result.getString("genero")

        val precio = result.getDouble("precio")

        val fecha = result.getDate("fecha")

        val desc = result.getString("descripcion")

        /*
        constructing a User object and
        putting data into the list
         */
        users.add(catalogo(id, name ,gen,precio,fecha,desc))
    }
    println(users)

}
