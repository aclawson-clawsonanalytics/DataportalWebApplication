/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.Forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import Core.ModelLayer.User;

/**
 *
 * @author andrewclawson
 */
public class LoginForm extends org.apache.struts.action.ActionForm {
    
    private String email;
    private String password;
    //private String username;
    private String missingFieldsError;
    private String authenticationError;
    private User user;

    /**
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param string
     */
    public void setEmail(String string) {
        this.email = string;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String string){
        this.password = string;
    }
    public String getMissingFieldsError(){
        return missingFieldsError;
    }
    
    public void setMissingFieldsError(){
        this.missingFieldsError = "<span style='color:red'>Missing either a username or password.</span>";
    }
    
    public void setAuthenticationError(){
        this.authenticationError = "<span style='color:red'>Cannot authenticate user.</span>";
    }
    
    public String getAuthenticationError(){
        return authenticationError;
    }
    
    public void setUser(String email, String password){
        if(User.Authenticate(email, password, "PRODUCTION")){
            this.user = User.GetByLoginCredentials(email, password, "PRODUCTION");
            if (this.user != null){
                //return user;
            }else{
                this.setAuthenticationError();
            }
        }else{
            this.setAuthenticationError();
        }
    }
    
    
    /**
     * @return
     */
    

    /**
     * @param i
     */
    /**
     *
     */
    public LoginForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getEmail() == null || getEmail().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
}
