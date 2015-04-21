/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab18;

/**
 *
 * @author Dominic
 */
public class Employee {
    private String _name, _SSN, _bDay, _diversity;
    
    public Employee(String name, String SSN, String bDay, String diversity) {
        _name = name;
        _SSN = SSN;
        _bDay = bDay;
        _diversity = diversity;
    }
    
    public String getKey() {
        return _SSN + _diversity;
    }
    
    public String getBDay() {
        return _bDay;
    }
}
