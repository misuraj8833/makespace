package com.example.makespace.makespace.person;

public class CheckPersonImpl implements CheckPerson
{
    /**
     *
     * Check for the Number of Persons. [2,20]
     */

    @Override
    public boolean checkPerson(int persons) {
        if((persons<2)||(persons>20)) {
            return false;
        }
        else
            return true;
    }
}
