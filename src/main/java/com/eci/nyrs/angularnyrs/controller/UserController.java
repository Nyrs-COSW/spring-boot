package com.eci.nyrs.angularnyrs.controller;

import com.eci.nyrs.angularnyrs.models.User;

import com.eci.nyrs.angularnyrs.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 */
@RestController
@RequestMapping( "/user" )
public class UserController
{

    @Autowired
    private UserService userService;

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

        User user = userService.getUser(username);


        if ( user != null )
        {
            String pwdNur = user.getPassword();

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
    //------------------------------NURSE------------------------------------------
    @CrossOrigin
    @RequestMapping(value = "/nurse", method = RequestMethod.POST)
    public ResponseEntity<?> newNurse(@RequestBody User nurse) {
        return new ResponseEntity<>(userService.createNurse(nurse), HttpStatus.ACCEPTED);
    }
    @CrossOrigin
    @RequestMapping(value = "/nurse/edit", method = RequestMethod.POST)
    public ResponseEntity<?> editNurse(@RequestBody User nurse) {
        return new ResponseEntity<>(userService.editNurse(nurse), HttpStatus.ACCEPTED);
    }
    @CrossOrigin
    @RequestMapping(value = "/allNurse", method = RequestMethod.GET)
    public ResponseEntity<?> getAllNurse() {
        return new ResponseEntity<>(userService.getAllNurse(), HttpStatus.ACCEPTED);
    }

    @CrossOrigin
    @RequestMapping( value = "/nurse/{username}", method = RequestMethod.GET )
    public User getUserByUsername(@PathVariable("username") String username) {
        return userService.getUser(username);
    }

    @CrossOrigin
    @RequestMapping( value = "/personal/{service}", method = RequestMethod.GET )
    public List<User> getNursingPersonalByService(@PathVariable("service") String service) {
        return userService.getNursingPersonalByService(service);
    }
    //---------------------------PACIENTE-------------------------------
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getPatients() {
        return userService.getPatients();
    }

    @CrossOrigin
    @RequestMapping(value = "/patient", method = RequestMethod.POST)
    public ResponseEntity<?> newPatient(@RequestBody User patient) {

        return new ResponseEntity<>(userService.createPatient(patient), HttpStatus.ACCEPTED);

    }

    @CrossOrigin
    @RequestMapping(value = "/patient/edit", method = RequestMethod.POST)
    public ResponseEntity<?> updatePatient(@RequestBody User patient) {

        return new ResponseEntity<>(userService.editPatient(patient), HttpStatus.ACCEPTED);

    }

    @CrossOrigin
    @RequestMapping(value = "/patient/{username}", method = RequestMethod.GET)
    public ResponseEntity<?> getPatient(@PathVariable("username") String username) {

        return new ResponseEntity<>( userService.getUser(username) ,HttpStatus.ACCEPTED);

    }

    @CrossOrigin
    @RequestMapping( value = "/prueba", method = RequestMethod.GET )
    public ResponseEntity<?> prueba() throws ServletException, SQLException {
        return new ResponseEntity<>( userService.getPatients(),HttpStatus.ACCEPTED);

    }

}
