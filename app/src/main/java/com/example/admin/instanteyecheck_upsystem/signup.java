package com.example.admin.instanteyecheck_upsystem;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signup extends AppCompatActivity {

    com.example.admin.instanteyecheck_upsystem.DatabaseHelper helper = new com.example.admin.instanteyecheck_upsystem.DatabaseHelper(this);
    String name,username,email,password,cpassword;
    private Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        session = new Session(this);
        if(session.loggedin())
        {
            startActivity(new Intent(signup.this,options.class));
            finish();
        }
        final TextInputLayout nameWrapper = (TextInputLayout) findViewById(R.id.nameWrapper);
        final TextInputLayout usernameWrapper = (TextInputLayout) findViewById(R.id.usernameWrapper);
        final TextInputLayout emailWrapper = (TextInputLayout) findViewById(R.id.emailWrapper);
        final TextInputLayout passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);
        final TextInputLayout cpasswordWrapper = (TextInputLayout) findViewById(R.id.cpasswordWrapper);

        nameWrapper.setHint("Name");
        usernameWrapper.setHint("Username");
        emailWrapper.setHint("Email");
        passwordWrapper.setHint("Password");
        cpasswordWrapper.setHint("Confirm Password");
        Button btn=(Button)findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
                name = nameWrapper.getEditText().getText().toString();
                username = usernameWrapper.getEditText().getText().toString();
                email = emailWrapper.getEditText().getText().toString();
                password = passwordWrapper.getEditText().getText().toString();
                cpassword = cpasswordWrapper.getEditText().getText().toString();

                if(validateName(name)!=0)
                {
                    if(validateName(name)==1)
                        nameWrapper.setError("Name should only contain alphabets");
                    if(validateName(name)==2)
                        nameWrapper.setError("Name should have more than 4 letters");
                }
                else if(validateUsername(username)!=0){
                    nameWrapper.setErrorEnabled(false);
                    if(validateUsername(username)==1)
                        usernameWrapper.setError("Username already exist");
                    if(validateUsername(username)==2)
                        usernameWrapper.setError("Username should only contains alphanumeric values");
                    if(validateUsername(username)==3)
                        usernameWrapper.setError("The length of username should have more than 4 characters ");

                }
                else if (!validateEmail(email))
                {   usernameWrapper.setErrorEnabled(false);
                    emailWrapper.setError("Not a valid email address!");}
                else if (!validatePassword(password))
                {   emailWrapper.setErrorEnabled(false);
                    passwordWrapper.setError("Password length must be greater than 5"); }
                else if(!confirmPass(password,cpassword))
                {
                    passwordWrapper.setErrorEnabled(false);
                    cpasswordWrapper.setError("Password Don't Match");
                }
                else {
                    nameWrapper.setErrorEnabled(false);
                    usernameWrapper.setErrorEnabled(false);
                    emailWrapper.setErrorEnabled(false);
                    passwordWrapper.setErrorEnabled(false);
                    cpasswordWrapper.setErrorEnabled(false);
                    doLogin();
                }
            }
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }





    private static final String Uname_PATTERN = "^[a-zA-Z0-9]*";
    private Pattern pattern3 = Pattern.compile(Uname_PATTERN);
    private Matcher matcher3;
    public boolean unamecontain(String name){
        matcher3=pattern3.matcher(name);
        return matcher3.matches();

    }
    public int validateUsername(String name){
        int i=0;
        if(!helper.SearchUname(name))
            i=1;
        if(!unamecontain(name))
            i=2;
        if (name.length() < 5)
            i=3;

        return i;
    }

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;

    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
        //NAME CHECK FUNCTION
    private static final String name_pattern= "^^[a-zA-Z\\s]+$";
    private Pattern pattern2 = Pattern.compile(name_pattern);
    private Matcher matcher2;
    public boolean namecontain(String name){
        matcher2=pattern2.matcher(name);
        return matcher2.matches();

    }
    public int validateName(String name){
        int i=0;
        if(!namecontain(name))
            i=1;
        if (name.length() < 5)
                i=2;


        return i;
    }
    public boolean validatePassword(String password) {
        return password.length() > 5;
    }

    public boolean confirmPass(String pass1,String pass2)
    {
        if(pass1.equals(pass2))
            return true;
        else
            return false;
    }

    public void doLogin()
    {
        Toast msg1 = Toast.makeText(signup.this, "You are registered!", Toast.LENGTH_LONG);
        msg1.show();
        Intent i = new Intent(signup.this, login.class);
        startActivity(i);
        finish();
        Contact c = new Contact();
        c.setName(name);
        c.setEmail(email);
        c.setUsername(username);
        c.setPassword(password);
        helper.insertContact(c);

    }

}
