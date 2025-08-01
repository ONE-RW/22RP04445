package SESSION;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.html");
            return;
        }
        
        User user = (User) session.getAttribute("user");
        Role role = user.getRole();
        
        // Route to appropriate dashboard based on role
        switch (role.getRoleId()) {
            case 1: // System Admin
                response.sendRedirect("admin-dashboard.html");
                break;
            case 2: // Sports Editor
                response.sendRedirect("sports-dashboard.html");
                break;
            case 3: // Academic Editor
                response.sendRedirect("academic-dashboard.html");
                break;
            case 4: // Campus Life Editor
                response.sendRedirect("campus-dashboard.html");
                break;
            case 5: // Events Coordinator
                response.sendRedirect("events-dashboard.html");
                break;
            case 6: // Tech Editor
                response.sendRedirect("tech-dashboard.html");
                break;
            default:
                response.sendRedirect("error.html");
                break;
        }
    }
}