package pl.edu.wszib.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    public ErrorController(){

    }

    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public String error(HttpServletRequest httpServletRequest){


         Object object = httpServletRequest.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

         if(object != null) {

             Integer code = Integer.valueOf(object.toString());
             if (code == HttpStatus.NOT_FOUND.value()) {
                 return "error-404";
             } else if (code == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                 return "error-500";

             }
         }
        return "error";
    }



    @RequestMapping(value = "/error", method = RequestMethod.POST)
    public String backToLogin(){
        return "redirect:login";
    }


    @Override
    public String getErrorPath() {
        return null;
    }
}
