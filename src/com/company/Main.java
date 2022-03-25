package com.company;

import com.company.model.Doctor;
import com.company.service.DoctorService;

public class Main {

    public static void main(String[] args) {
	Doctor newdoctor = new Doctor();
    newdoctor.setId(1);
    newdoctor.setFullname("Баланчаева Тукунчо Баланчаевна");
    newdoctor.setOpening_hours(2022-04-01:10:00.403 ); // синтаксис Time не разобрался!!!
    newdoctor.setPhonenumber("0553 345365");

        DoctorService doctorService = new DoctorService();
        doctorService.registerDoctor(newdoctor);

        }
    }

