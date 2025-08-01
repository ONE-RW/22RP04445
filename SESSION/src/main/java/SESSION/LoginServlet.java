package SESSION;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = UserService.authenticateUser(username, password);
        
        if (user != null) {
            HttpSession session = request.getSession(true); 
            session.setAttribute("user", user);
            session.setAttribute("username", username);
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("role", user.getRole());
            response.sendRedirect("dashboard");
        } else {
            response.sendRedirect("error.html");
        }
    }
}

