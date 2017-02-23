package by.peshko.soccms.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) final String error,
                        @RequestParam(value = "logout", required = false) final String logout, final Model model,
                        final HttpServletRequest request) {

        if (error != null) {
            model.addAttribute("error", "Invalid username and password!");
        }
        if (logout != null) {
            model.addAttribute("msg", "You've been logged out successfully.");
        }
        String targetUrl = getRememberMeTargetUrlFromSession(request);
        if (StringUtils.hasText(targetUrl)) {
            model.addAttribute("targetUrl", targetUrl);
            model.addAttribute("loginUpdate", true);
        }

        return "/loginpage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(final Model model) {
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            final UserDetails userDetail = (UserDetails) auth.getPrincipal();
            model.addAttribute("username", userDetail.getUsername());
        }
        return "/error/403";
    }

    private String getRememberMeTargetUrlFromSession(final HttpServletRequest request) {
        String targetUrl = "";
        HttpSession session = request.getSession(false);
        if (session != null) {
            targetUrl = session.getAttribute("targetUrl") == null ? "" : session.getAttribute("targetUrl").toString();
        }
        return targetUrl;
    }
}
