package com.eci.nyrs.angularnyrs.service;

import com.eci.nyrs.angularnyrs.models.Nurse;
import com.eci.nyrs.angularnyrs.models.Nursingservices;
import com.eci.nyrs.angularnyrs.models.Patient;
import com.eci.nyrs.angularnyrs.models.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class RequestUsersServiceImpl implements RequestUsersService {


    private List<Request> requests = new ArrayList<>();


    @Autowired
    public RequestUsersServiceImpl()
    {
    }


    @PostConstruct
    private void populateSampleData()
    {
        Nursingservices ns1 = new Nursingservices("Maternidad", "Servicio de Maternidad", "/assets/images/mother.svg");
        Nursingservices ns2 = new Nursingservices("Adulto Mayor", "Servicio de cuidad", "/assets/images/mother.svg");

        Nurse n1 = new Nurse( "nurse1@mail.com", "1234", "Andrea", "Ramirez", "AndreaRamirezNurse",35,"Cuidado a Mayores y a mujeres embarazadas",20 );
        Nurse n2 = new Nurse( "nurse2@mail.com", "1234", "Jose", "Gonzales", "JoseEnfermero" , 40, "Cuidados paliativos", 30);
        Nurse n3 = new Nurse("danilo.villarraga@mail.escuelaing.edu.co", "1234", "Alejandro", "Villarraga", "AlejandroVillarraga", 23, "Cuidados paliativos", 5 );
        Nurse n4  = new Nurse( "jairo.gonzalez@mail.escuelaing.edu.co", "1234", "Jairo", "Gonzalez", "JairoGonzalez", 23, "Cuidado de mujeres", 7 );


        Patient p1 = new Patient( "patient@mail.com", "1234", "Ernesto", "Sarmiento", "PacienteErnesto",40,13354841,165189 );
        Patient p2 =  new Patient( "javier.silva@mail.escuelaing.edu.co", "1234", "Javier", "Silva", "JavierSilva",23, 234542,1234 );
        Patient p3 = new Patient( "leonardo.castro@mail.escuelaing.edu.co", "1234", "Leonardo", "Castro", "LeonardoCastro" , 21, 2342,10);

        Date date = new Date("12/4/2018 10:30:00");

        requests.add(new Request(date, n3, p1, ns1, true,1, "Necesito cuidar de una enfermedad"));
        requests.add(new Request(date,n3,p2, ns1, false,2, "Necesito cuidar de una enfermedad"));
        requests.add(new Request(date,n2, p3, ns2, false,3 , "Necesito cuidar de una enfermedad"));
        requests.add(new Request(date,n4,p1, ns1, false, 4, "Necesito cuidar de una enfermedad"));
        requests.add(new Request(date,n2,p2, ns2, false, 5, "Necesito cuidar de una enfermedad"));
        requests.add(new Request(date, n1, p3, ns1, true, 6, "request"));
        requests.add(new Request(date,n1,p1, ns1, true, 7, "request"));
        requests.add(new Request(date,n2, p2, ns2, false, 8, "request"));
        requests.add(new Request(date,n1,p3, ns1, false, 9, "request"));
        requests.add(new Request(date,n2,p2, ns2, false, 10, "request"));

    }




    @Override
    public List<Request> getRequest(String username, Boolean pending) {
        List<Request> UserRequest = new ArrayList<>();
        for (int i = 0; i < requests.size() ; i++) {
            if(requests.get(i).getPatient().getUsername().equals(username) && requests.get(i).getAccepted().equals(pending)){
                UserRequest.add(requests.get(i));
            }
        }
        return UserRequest;
    }
}
