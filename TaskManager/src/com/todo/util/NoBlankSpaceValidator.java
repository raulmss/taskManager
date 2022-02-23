package com.todo.util;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

//Aspect Orientation Programing
@FacesValidator
public class NoBlankSpaceValidator implements Validator {

    public void validate(FacesContext context, UIComponent component,
         Object value) throws ValidatorException {
        //Check if user has typed only blank spaces
        if(value.toString().trim().isEmpty()){
            FacesMessage msg = 
                new FacesMessage("Incorrect input provided", 
                        "Provide some meaningful character, instead of spaces");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            
            
            throw new ValidatorException(msg);

        }
    }
}