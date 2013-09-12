package study.pattern.eaa.datasource.datamapper;

import study.pattern.eaa.base.layersupertype.DomainObject;

public class Person extends DomainObject {
    private String lastName;
    private String firstName;
    private int    numberOfDependents;

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getNumberOfDependents() {
        return numberOfDependents;
    }


    public Person(Long id, String lastNameArg, String firstNameArg, int numDependentsArg) {
        // TODO Auto-generated constructor stub
    }
}
