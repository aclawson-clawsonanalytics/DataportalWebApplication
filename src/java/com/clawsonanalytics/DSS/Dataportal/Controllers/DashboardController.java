/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.DSS.Dataportal.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;
import org.springframework.context.annotation.Scope;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.SessionAttributes;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
/**
 *
 * @author andrewclawson
 */
@Controller
@Scope("session")
public class DashboardController {
    public DashboardController(){
        
    }
    
    @RequestMapping(value="/dashboard")
    public String LoadDashboard(HttpServletRequest request){
        
        return "dashboard/dashboard";
        //return new ModelAndView();
    }
}
