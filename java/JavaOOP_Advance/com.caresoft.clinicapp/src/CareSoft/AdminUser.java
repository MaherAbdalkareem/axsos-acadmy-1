package CareSoft;

import java.util.ArrayList;
import java.util.Date;

import com.caresoft.clinicapp.HIPAACompliantAdmin;
import com.caresoft.clinicapp.HIPAACompliantUser;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	
	 	private Integer employeeID;
	 	private String role;
	    private ArrayList<String> securityIncidents;
	    
	    
	    public AdminUser(Integer id, String role) {
			super(id);
			this.role = role;
		}

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
		return securityIncidents;
	}

	@Override
	public boolean assignPin(int pin) {
		if (pin >=100000 ) {
			super.setPin(pin);
			return true;
		}
		return false;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (super.getId() == confirmedAuthID) {
			return true;
		}
		else {
		authIncident();
		return false;
		}
	}
	
	public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes);
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER");
        securityIncidents.add(report);
    }
}
