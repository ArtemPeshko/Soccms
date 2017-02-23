package by.peshko.soccms.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionsHandler {
    @ExceptionHandler(Exception.class)
    public String handleIOException(final Exception ex, final Model model) {
        model.addAttribute("ex", ex);
        return "/error/exceptionpage";
    }
}