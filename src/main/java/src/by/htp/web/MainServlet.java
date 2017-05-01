package src.by.htp.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.by.htp.web.command.Command;
import src.by.htp.web.command.CommandChooser;

import static src.by.htp.web.util.Permanents.*;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet doPost");
        processRequest(request, response);
    } 
    
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("servlet doGet");
        processRequest(req, resp);
	}
   
    public void forward(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException{
    	  RequestDispatcher disp =request.getRequestDispatcher(page);
    	  disp.forward(request, response);
    	 }
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String action = request.getParameter(REQUEST_PARAM_ACTION);
    	Command command = CommandChooser.chooseCommand(action);
    	String page = command.execute(request, response);
    	forward(request, response, page);
        }
    }
