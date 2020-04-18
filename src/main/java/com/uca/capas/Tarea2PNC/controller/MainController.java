package com.uca.capas.Tarea2PNC.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@RequestMapping("/student")
	public @ResponseBody String StudenData() {
		
		return ("Student Data <br/> "
				+ "Name: Oscar Edenilson <br/>"
				+ "Lastname: Lovato Quintanilla <br/>"
				+ "ID: 00127417 <br/>"
				+ "Studying Career: Sofware engineering <br/>"
				+ "Year: 4 " );
	}
	
	@RequestMapping("/date")
	public @ResponseBody String date(HttpServletRequest request) {
		Integer day = Integer.parseInt(request.getParameter("day"));
		Integer month = Integer.parseInt(request.getParameter("month"));
		Integer year = Integer.parseInt(request.getParameter("year"));
		
		String dias []= {" SUNDAY ", " MONDAY "," TUESDAY "," WEDNESDAY "," THURSDAY "," FRIDAY "," SATURDAY "};
		
		if((day < 32)&&(month < 13)&&(year < 10000)){
            int a = (14 - month) / 12;
            int y = year - a;
            int m = month + 12 * a - 2;

            int d = (day + y + y/4 - y/100 + y/400 + (31*m)/12) % 7;
            return "The date "+day + "/" + month + "/"+ year + " is: " + dias[d];
       }else {
    	   return "invalid format";
       }
		
		
	}
}
