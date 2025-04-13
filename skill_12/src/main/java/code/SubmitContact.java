package code;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/SubmitContact")
public class SubmitContact extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        // DB Connection details
        String url = "jdbc:postgresql://localhost:5432/contactdb";
        String dbUser = "postgres"; // Change if needed
        String dbPassword = "1234"; // Change to your password

        try {
            // Load PostgreSQL JDBC Driver
            Class.forName("org.postgresql.Driver");

            // Establish Connection
            Connection conn = DriverManager.getConnection(url, dbUser, dbPassword);

            // Prepare SQL statement
            String sql = "INSERT INTO contacts (name, email, phone) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phone);

            // Execute and check
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                out.println("<h3>Contact submitted successfully!</h3>");
            } else {
                out.println("<h3>Error while submitting contact.</h3>");
            }

            // Close connection
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace(out); // Show full error in browser for now
        }
    }
}
