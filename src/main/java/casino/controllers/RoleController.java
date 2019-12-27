package casino.controllers;

import casino.models.Role;
import casino.services.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class RoleController {

    @GetMapping("/success")
    public void loginPageRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException, ServletException {

        String role = authResult.getAuthorities().toString();
        if (role.contains("admin")) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/admin/games"));
        } else if (role.contains("user")) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/rooms"));
        }
    }
}
