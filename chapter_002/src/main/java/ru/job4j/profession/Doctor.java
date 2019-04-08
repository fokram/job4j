package ru.job4j.profession;

import java.util.Date;

class Doctor extends Profession {
    public class Diagnose {
        private String description;
        private String recomendation;
        private String name;

        public Diagnose(String name) {
            this.name = name;
            this.description = "some desc";
            this.recomendation = "some recomendation";
        }
    }

    public class Pacient {
        private String firstName;
        private String lastName;
        private Date birthDate;

        public Pacient(String firstName, String lastName, Date birthDate) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthDate = birthDate;
        }
    }

    public Diagnose heal(Pacient pacient) {
        Diagnose diag = new Diagnose("Viruses");
        return diag;
    }
} 