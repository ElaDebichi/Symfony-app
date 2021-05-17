/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.netdev.mindspace.services.UserService;

/**
 *
 * @author hp
 */
public class SignUpForm extends BaseForm{
     public SignUpForm(Resources res) {
        super(new BorderLayout());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        tb.setUIID("Container");
        getTitleArea().setUIID("Container");
        Form previous = Display.getInstance().getCurrent();
        tb.setBackCommand("", e -> previous.showBack());
        setUIID("SignIn");
                
       
        TextField nom = new TextField("", "First Name", 20, TextField.ANY);
        TextField prenom = new TextField("", "Name", 20, TextField.ANY);
         TextField email = new TextField("", "Email", 20, TextField.EMAILADDR);
        TextField town = new TextField("", "Town", 20, TextField.ANY);
        TextField fb = new TextField("", "Facebook", 20, TextField.ANY);
        TextField linkdin = new TextField("", "Linkdin", 20, TextField.ANY);
      
        TextField password = new TextField("", "Password", 20, TextField.PASSWORD);
        TextField confirmPassword = new TextField("", "Confirm Password", 20, TextField.PASSWORD);
        TextField telephone = new TextField("", "phone", 20, TextField.ANY);
         
        
            TextField img = new TextField("", "img", 20, TextField.ANY);
              TextField level = new TextField("", "level", 20, TextField.ANY);
                TextField type_candidat = new TextField("", "type_candidat", 20, TextField.ANY);
                  TextField description = new TextField("", "description", 20, TextField.ANY);

      
        nom.setSingleLineTextArea(false);
        prenom.setSingleLineTextArea(false);
        email.setSingleLineTextArea(false);
        town.setSingleLineTextArea(false);
        fb.setSingleLineTextArea(false);
        linkdin.setSingleLineTextArea(false);
        password.setSingleLineTextArea(false);
        confirmPassword.setSingleLineTextArea(false);
        telephone.setSingleLineTextArea(false);
         img.setSingleLineTextArea(false);
          level.setSingleLineTextArea(false);
           type_candidat.setSingleLineTextArea(false);
            description.setSingleLineTextArea(false);
        Button next = new Button("Next");
        Button signIn = new Button("Sign In");
        signIn.addActionListener(e -> previous.showBack());
        signIn.setUIID("Link");
        Label alreadHaveAnAccount = new Label("Already have an account?");
        
        Container content = BoxLayout.encloseY(
                new Label("Sign Up", "LogoLabel"),
                
               
                new FloatingHint(nom),
                createLineSeparator(),
                new FloatingHint(prenom),
                createLineSeparator(),
                new FloatingHint(email),
                createLineSeparator(),
                new FloatingHint(town),
                createLineSeparator(),
                new FloatingHint(fb),
                createLineSeparator(),
                new FloatingHint(linkdin),
                createLineSeparator(),
                new FloatingHint(password),
                createLineSeparator(),
                new FloatingHint(confirmPassword),
                createLineSeparator(),
                new FloatingHint(telephone),
                createLineSeparator(),
                new FloatingHint(img),
                createLineSeparator(),
                new FloatingHint(level),
                createLineSeparator(),
                new FloatingHint(type_candidat),
                createLineSeparator(),
                new FloatingHint(description),
                createLineSeparator()
                
        );
        content.setScrollableY(true);
        add(BorderLayout.CENTER, content);
        add(BorderLayout.SOUTH, BoxLayout.encloseY(
                next,
                FlowLayout.encloseCenter(alreadHaveAnAccount, signIn)
        ));
        next.requestFocus();
        next.addActionListener((e)-> {
            UserService.getInstance().signup(nom, prenom, email, town, fb, linkdin, password, telephone,img,level,type_candidat,description, res);
            Dialog.show("succes", "maintenant vous etes Inscri", "ok",null);
            new NewsfeedForm(res).show();
        });
        
    }
    
    
}
