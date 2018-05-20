package dao;

import java.sql.*; // Use classes in java.sql package
import java.util.ArrayList;
import java.util.List;

import model.TAccount;

public class DatabaseDAO {
	private static DatabaseDAO instancia;
	private static Connection conn;
	final private static String url = "jdbc:mysql://fenrir.info.uaic.ro:3306/UCMINFO";
	final private static String user = "UCMINFO";
	final private static String pass = "KsPEUUoazj";

	private DatabaseDAO() {
		try {

			conn = DriverManager.getConnection(url, user, pass); // MySQL
			System.out.println("Connected");

		}

		catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public static DatabaseDAO getInstance() {
		if (instancia == null) {
			instancia = new DatabaseDAO();
		}
		return instancia;
	}

	public boolean checkUser(String username, String password) throws SQLException {
		Statement stmt = conn.createStatement();

		// Step 3: Execute a SQL SELECT query, the query result
		// is returned in a 'ResultSet' object.
		try {
			String strSelect = "select username,password from users where username='" + username + "' and password ='"
					+ password + "'";
			System.out.println("The SQL query is: " + strSelect); // Echo For debugging
			System.out.println();

			ResultSet rset = stmt.executeQuery(strSelect);

			// Step 4: Process the ResultSet by scrolling the cursor forward via next().
			// For each row, retrieve the contents of the cells with getXxx(columnName).
			System.out.println("Succesfull check for user login");
			return rset.next();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public boolean checkUsernameExists(String username) throws SQLException {
		Statement stmt = conn.createStatement();

		// Step 3: Execute a SQL SELECT query, the query result
		// is returned in a 'ResultSet' object.
		try {
			String strSelect = "select username from users where username='" + username + "'";
			System.out.println("The SQL query is: " + strSelect); // Echo For debugging
			System.out.println();

			ResultSet rset = stmt.executeQuery(strSelect);

			// Step 4: Process the ResultSet by scrolling the cursor forward via next().
			// For each row, retrieve the contents of the cells with getXxx(columnName).
			System.out.println("Succesfull check for user login");
			return rset.next();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public void addNewUser(TAccount _user) throws SQLException {

		// Step 3: Execute a SQL SELECT query, the query result
		// is returned in a 'ResultSet' object.
		String strSelect = "Insert INTO users ( email,username,password) values (?,?,?)";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(strSelect);
			preparedStatement.setString(1, _user.getUsername());
			preparedStatement.setString(2, _user.getEmail());
			preparedStatement.setString(3, _user.getPassword());

			System.out.println("The SQL query is: " + strSelect); // Echo For debugging
			System.out.println();
			preparedStatement.executeUpdate();
			System.out.println("Succesfull register");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// public static void main(String[] args) throws SQLException {
	// DatabaseDAO db = DatabaseDAO.getInstance();
	// System.out.println(db.checkUser("tester2", "12345"));
	// db.addNewUser("tester","test@ucm.es", "12345");
	//
	// }

	public String getPassByEmail(String email) throws SQLException {
		Statement stmt = conn.createStatement();

		// Step 3: Execute a SQL SELECT query, the query result
		// is returned in a 'ResultSet' object.
		try {
			String strSelect = "select password from users where email='" + email + "'";
			System.out.println("The SQL query is: " + strSelect); // Echo For debugging
			System.out.println();

			ResultSet rset = stmt.executeQuery(strSelect);

			// Step 4: Process the ResultSet by scrolling the cursor forward via next().
			// For each row, retrieve the contents of the cells with getXxx(columnName).
			if (rset.next()) {
				String pass = rset.getString("password");
				return pass;
			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "User not valid";

	}

	public void finalize() {
		try {
			this.conn.close();
			System.out.println("Closed Connection in the finalizer");
		} catch (Exception e) {
		}
	}

	public TAccount retriveById(String id) throws SQLException {
		Statement stmt = conn.createStatement();

		// Step 3: Execute a SQL SELECT query, the query result
		// is returned in a 'ResultSet' object.
		try {
			String strSelect = "select * from users where id='" + id + "'";
			System.out.println("The SQL query is: " + strSelect); // Echo For debugging
			System.out.println();

			ResultSet rset = stmt.executeQuery(strSelect);

			// Step 4: Process the ResultSet by scrolling the cursor forward via next().
			// For each row, retrieve the contents of the cells with getXxx(columnName).
			if (rset.next()) {
				String pass = rset.getString("password");
				String username = rset.getString("username");
				String email = rset.getString("email");
				TAccount aux = new TAccount(username, email, pass);
				return aux;
			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public List<String> getUserFriends(TAccount user) throws SQLException {
		List<String> friends = new ArrayList<String>();
		Statement stmt = conn.createStatement();
		String id = this.retriveIdByUsername(user);

		// Step 3: Execute a SQL SELECT query, the query result
		// is returned in a 'ResultSet' object.
		try {
			String strSelect = "select id_user2 from friends where id_user1='" + id + "'";
			System.out.println("The SQL query is: " + strSelect); // Echo For debugging
			System.out.println();

			ResultSet rset = stmt.executeQuery(strSelect);

			// Step 4: Process the ResultSet by scrolling the cursor forward via next().
			// For each row, retrieve the contents of the cells with getXxx(columnName).
			while (rset.next()) {
				String aux = rset.getString("id_user2");
				TAccount aux2 = DatabaseDAO.getInstance().retriveById(aux);

				friends.add(aux2.getUsername());
			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			return friends;
		}

	}

	public String retriveIdByUsername(TAccount user) throws SQLException {
		Statement stmt = conn.createStatement();

		// Step 3: Execute a SQL SELECT query, the query result
		// is returned in a 'ResultSet' object.
		try {
			String strSelect = "select id from users where username='" + user.getUsername() + "'";
			System.out.println("The SQL query is: " + strSelect); // Echo For debugging
			System.out.println();

			ResultSet rset = stmt.executeQuery(strSelect);

			// Step 4: Process the ResultSet by scrolling the cursor forward via next().
			// For each row, retrieve the contents of the cells with getXxx(columnName).
			if (rset.next()) {
				String id = rset.getString("id");
				return id;
			}
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "not exist";

	}

	public boolean checkFriendship(TAccount _user1, TAccount _user2) throws SQLException {
		// Step 3: Execute a SQL SELECT query, the query result
		// is returned in a 'ResultSet' object.
		Statement stmt = conn.createStatement();

		String strSelect = "select * from friends where id_user1='"
				+ DatabaseDAO.getInstance().retriveIdByUsername(_user1) + "' AND id_user2='"
				+ DatabaseDAO.getInstance().retriveIdByUsername(_user2) + "'";
		try {

			System.out.println("The SQL query is: " + strSelect); // Echo For debugging
			System.out.println();
			ResultSet rset = stmt.executeQuery(strSelect);
			return rset.next();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;

	}

	public void addFriend(TAccount _user1, TAccount _user2) {
		// Step 3: Execute a SQL SELECT query, the query result
		// is returned in a 'ResultSet' object.
		String strSelect = "Insert INTO friends ( id_user1	,id_user2) values (?,?)";

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(strSelect);
			preparedStatement.setString(1, retriveIdByUsername(_user1));
			preparedStatement.setString(2, retriveIdByUsername(_user2));

			System.out.println("The SQL query is: " + strSelect); // Echo For debugging
			System.out.println();
			preparedStatement.executeUpdate();
			System.out.println("Succesfull register");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}