/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.MyUser;
import java.io.IOException;
import java.io.PrintWriter;
import DataBase.UserDAO;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
public class singIn extends HttpServlet {

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            MyUser user = new MyUser();
            System.out.println("email from signIn class is : " + request.getParameter("emailIn"));
            user.setUserEmail(request.getParameter("emailIn"));
            user.setUserPassword(request.getParameter("passwordIn"));
            String validateEmail = request.getParameter("emailIn");
            boolean isValidEmail = isValidEmailAddress(validateEmail);
            System.out.println("Validatin of email using agex: " + isValidEmail);
            if (isValidEmail) {
                user = UserDAO.login(user);

            } else {
                response.sendRedirect("login_invalid.jsp"); //login page with e 
            }
            System.out.println("user validation :  " + user.isValid());
            if (user.isValid()) {

                HttpSession session = request.getSession(true);
                session.setAttribute("currentSessionUser", user);
                //cookies handling 
                session.setMaxInactiveInterval(30 * 60);
                String checkBoxSelection = request.getParameter("rememberMe");
                if (checkBoxSelection != null) {
                    Cookie cookiName = new Cookie("email", user.getUserEmail());
                    Cookie cookiPass = new Cookie("password", user.getUserPassword());
                    response.addCookie(cookiName);
                    response.addCookie(cookiPass);

                }
                response.sendRedirect("index.jsp"); //logged-in page --> profile      		
            } else {

                response.sendRedirect("login_invalid.jsp"); //login page with e 
            }
        } catch (Throwable theException) {
            System.out.println(theException);
        }
    }
    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {
        String emailFromCookie=null;
        String passFromCookie=null;
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie c = cookies[i];
                if (c.getName().equals("email")) {
                    emailFromCookie = c.getValue();
                }
                if (c.getName().equals("password")) {
                    passFromCookie = c.getValue();
                }
                if(emailFromCookie!=null&&passFromCookie!=null){
                MyUser user = new MyUser();
                System.out.println("email from signIn class is : " + request.getParameter("emailIn"));
                user.setUserEmail(emailFromCookie);
                user.setUserPassword(passFromCookie);
                user = UserDAO.login(user);
                
                HttpSession session = request.getSession(true);
                session.setAttribute("currentSessionUser", user);
                }
                resp.sendRedirect("index"); //login page with e 
                

            }

        }

//To change body of generated methods, choose Tools | Templates.
    }

}
