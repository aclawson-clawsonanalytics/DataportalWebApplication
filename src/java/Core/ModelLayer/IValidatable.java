/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.ModelLayer;
import java.util.List;

/**
 *
 * @author andrewclawson
 */
public interface IValidatable {
    
    List<String> GetValidationErrors();
    boolean IsValid();
    
}
