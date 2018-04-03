package com.eci.nyrs.angularnyrs.controller;

import com.eci.nyrs.angularnyrs.models.Nurse;
import com.eci.nyrs.angularnyrs.models.Patient;
import com.eci.nyrs.angularnyrs.models.User;
import com.eci.nyrs.angularnyrs.service.NurseService;
import com.eci.nyrs.angularnyrs.service.UserService;

import com.eci.nyrs.angularnyrs.service.PatientService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.sql.SQLException;
import java.util.Date;

/**
 */
@RestController
@RequestMapping( "/user" )
public class UserController
{

    @Autowired
    private UserService userService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private NurseService nurseService;

    @CrossOrigin
    @RequestMapping( value = "/login", method = RequestMethod.POST )
    public ResponseEntity<?> login(@RequestBody User login ) {


        String jwtToken = "";

        if ( login.getUsername() == null || login.getPassword() == null )
        {
            return new ResponseEntity<>( "Please fill in username and password", HttpStatus.FORBIDDEN );
        }

        String username = login.getUsername();
        String password = login.getPassword();

        Patient patient = patientService.getPatient(username);
        Nurse nurse = nurseService.getNurse(username);

        if ( patient == null )
        {
            String pwdNur = nurse.getPassword();

            if ( !password.equals( pwdNur ) )
            {
                System.out.println("clave mal 2");
                return new ResponseEntity<>( "Invalid login. Please check your name and password.", HttpStatus.FORBIDDEN );
            }
            System.out.println("AQUIIIIIIIIIII 2 Nurse");
            jwtToken = Jwts.builder().setSubject( username ).claim( "roles", "user" ).setIssuedAt( new Date() ).signWith(
                    SignatureAlgorithm.HS256, "secretkey" ).compact();
            System.out.println(jwtToken+" TOkern");
            return new ResponseEntity<>( new Token (jwtToken) ,HttpStatus.ACCEPTED);

        }
        else if( nurse == null){

            String pwdPat = patient.getPassword();

            if ( !password.equals( pwdPat ) )
            {
                System.out.println("clave mal 2");
                return new ResponseEntity<>( "Invalid login. Please check your name and password.", HttpStatus.FORBIDDEN );
            }
            System.out.println("AQUIIIIIIIIIII 2 Patient");
            jwtToken = Jwts.builder().setSubject( username ).claim( "roles", "user" ).setIssuedAt( new Date() ).signWith(
                    SignatureAlgorithm.HS256, "secretkey" ).compact();
            System.out.println(jwtToken+" TOkern");
            return new ResponseEntity<>( new Token (jwtToken) ,HttpStatus.ACCEPTED);

        }

        return new ResponseEntity<>("User username not found." ,HttpStatus.FORBIDDEN);

    }

    public class Token
    {

        String access_token;


        public Token( String access_token )
        {
            this.access_token = access_token;
        }


        public String getAccessToken()
        {
            return access_token;
        }

        public void setAccessToken( String access_token )
        {
            this.access_token = access_token;
        }
    }




}
