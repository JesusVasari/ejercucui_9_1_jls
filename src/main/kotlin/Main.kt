import java.sql.Connection
import java.sql.DriverManager


data class livres(val id: Int, val autor: String)

fun selectAutor(connection: Connection) {
    val query = connection.prepareStatement("SELECT autor FROM livres")
    val result = query.executeQuery()

    val users = mutableListOf<livres>()
    println("Query lanzada para autor ${result.fetchSize}")

    while (result.next()) {
        println("Iteración...")

        // getting the value of the id column
        val id = result.getInt("id")

        // getting the value of the name column
        val name = result.getString("autor")
        /*
        constructing a User object and
        putting data into the list
         */
        println("Creando y añadiend libro: $id $name...")
        users.add(livres(id, name))
    }
    println("Usuarios: " + users)

}

fun selectTitulo(connection: Connection) {
    val query = connection.prepareStatement("SELECT titulo FROM libros")
    val result = query.executeQuery()
    val users = mutableListOf<livres>()
    println(users)
}
fun main(args: Array<String>) {
    val acceso = "jdbc:oracle:thin:@localhost:1521:XE"

    // get the connection
    val connection = DriverManager
        .getConnection(acceso, "alumno", "alumno")

    println(connection.isValid(0))
    //selectAutor(connection)
            sa(connection)
    connection.close()
    //selectTitulo(connection)
}


fun sa(c: Connection)
{
    val users = mutableListOf<livres>()
    val ps = c.prepareStatement("select autor from libros")
    val result = ps.executeQuery()

    println("Query lanzada para autor ${result}")

    while (result.next()) {
        println("Iteración...")
    }
    println("Usuarios: " + users)
}