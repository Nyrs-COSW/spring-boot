package com.eci.nyrs.angularnyrs.service;


import com.eci.nyrs.angularnyrs.models.Nurse;
import com.eci.nyrs.angularnyrs.models.Nursingservices;
import com.eci.nyrs.angularnyrs.models.Patient;
import com.eci.nyrs.angularnyrs.models.User;
import com.eci.nyrs.angularnyrs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 */
//@Service
public class UserServiceImpl
        implements UserService
{

    private List<User> users = new ArrayList<>();
    private List<Nurse> nurses = new ArrayList<>();
    private List<Patient> patients = new ArrayList<>();

    @Autowired
    private UserRepository userrepo;


    @Autowired
    public UserServiceImpl()
    {
    }

    @PostConstruct
    private void populateSampleData()
    {
        Nurse n1 = new Nurse( "nurse1@mail.com", "1234", "Andrea", "Ramirez", "AndreaRamirezNurse",35,"Cuidado a Mayores y a mujeres embarazadas",20 );
        Nurse n2 = new Nurse( "nurse2@mail.com", "1234", "Jose", "Gonzales", "JoseEnfermero" , 40, "Cuidados paliativos", 30);
        Nurse n3 = new Nurse("danilo.villarraga@mail.escuelaing.edu.co", "1234", "Alejandro", "Villarraga", "AlejandroVillarraga", 23, "Cuidados paliativos", 5 );
        Nurse n4  = new Nurse( "jairo.gonzalez@mail.escuelaing.edu.co", "1234", "Jairo", "Gonzalez", "JairoGonzalez", 23, "Cuidado de mujeres", 7 );


        Patient p1 = new Patient( "patient@mail.com", "1234", "Ernesto", "Sarmiento", "PacienteErnesto",40,13354841,165189 );
        Patient p2 =  new Patient( "javier.silva@mail.escuelaing.edu.co", "1234", "Javier", "Silva", "JavierSilva",23, 234542,1234 );
        Patient p3 = new Patient( "leonardo.castro@mail.escuelaing.edu.co", "1234", "Leonardo", "Castro", "LeonardoCastro" , 21, 2342,10);


        ArrayList<Nursingservices> aln1 = new ArrayList<>();
        aln1.add(new Nursingservices("Post-Operatorio", "asdaasdf", "/assets/images/posoperatorio.svg"));
        aln1.add(new Nursingservices("Maternidad", "asdaasdf", "/assets/images/mother.svg"));
        n1.setServices(aln1);
        n2.setServices(aln1);

        ArrayList<Nursingservices> aln2 = new ArrayList<>();
        aln2.add(new Nursingservices("Terapia", "asdaasdf", "/assets/images/massage.svg"));
        aln2.add(new Nursingservices("Transplantes", "asdaasdf", "/assets/images/heart.svg"));
        aln2.add(new Nursingservices("Adulto-Mayor", "asdaasdf", "/assets/images/grandfather.svg"));
        n3.setServices(aln2);
        n4.setServices(aln2);



        nurses.add(n1);
        nurses.add(n2);
        nurses.add(n3);
        nurses.add(n4);

        patients.add(p1);
        patients.add(p2);
        patients.add(p3);


        //users.add(n1);
        //users.add(n2);
        //users.add(n3);
        //users.add(n4);
        //users.add(p1);
        //users.add(p2);
        //users.add(p3);

    }


    @Override
    public List<User> getUsers()
    {
        return users;
    }

    @Override
    public User getUser( String LocalUsername )
    {
        int j = -1;
        for(int i=0;i<users.size();i++) {
            if(users.get(i).getUsername().equals(LocalUsername)){
                j = i;
            }
        }
        return users.get(j);
    }


    @Override
    public Patient createPatient( Patient user )
    {

        patients.add( user );
        return user;
    }

    @Override
    public Nurse createNurse(Nurse user) {
        nurses.add(user);
        return user;
    }

    @Override
    public User findUserByEmail( String email )
    {
        return users.get( 0 );
    }

    @Override
    public User findUserByEmailAndPassword( String email, String password )
    {
        return users.get( 0 );
    }

    @Override
    public List<Nurse> getNursingPersonalByService(String service) {
        List<Nurse> nursePersonal = new ArrayList<>();
        for (int i = 0; i < nurses.size() ; i++) {
            List<Nursingservices> n = nurses.get(i).getServices();
            for (int j = 0; j < n.size() ; j++){
                if(n.get(j).getName().equals(service)){
                    nursePersonal.add(nurses.get(i));
                }
            }
        }
        return nursePersonal;
    }




}