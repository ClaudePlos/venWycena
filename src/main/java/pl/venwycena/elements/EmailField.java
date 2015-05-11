/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.venwycena.elements;

import com.vaadin.data.validator.EmailValidator;
import com.vaadin.ui.TextField;

/**
 *
 * @author k.skowronski
 */
public class EmailField extends TextField {
    
    public EmailField(String caption) {
        super(caption);
        setImmediate(true);
        addValidator(new EmailValidator("Invalid email"));
    }

    
}
