/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.Actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Core.Database.ConnectionManager;
import Core.ModelLayer.User;
import com.myapp.struts.Forms.LoginForm;


/**
 *
 * @author andrewclawson
 */
public class LoginAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String LOGIN_SUCCESS = "login_success";
    private static final String MISSING_LOGIN_FIELDS = "missing_login_fields";
    private static final String CANNOT_AUTHENTICATE = "cannot_authenticate";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        LoginForm loginForm = (LoginForm) form;
        String email = loginForm.getEmail();
        String password = loginForm.getPassword();
        
        if (email == null ||
                email.equals("") ||
                password == null ||
                password.equals("")){
            loginForm.setMissingFieldsError();
            return mapping.findForward(MISSING_LOGIN_FIELDS);
        }
        if (User.Authenticate(email, password, "PRODUCTION")){
            loginForm.setUser(email, password);
            return mapping.findForward(LOGIN_SUCCESS);
        }else{
            return mapping.findForward(CANNOT_AUTHENTICATE);
        }
        
        
        
        
    }
}
