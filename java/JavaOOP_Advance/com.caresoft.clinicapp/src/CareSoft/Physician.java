package CareSoft;

import java.util.ArrayList;
import java.util.Date;

import com.caresoft.clinicapp.HIPAACompliantUser;

public class Physician extends User implements HIPAACompliantUser {
	
	public Physician(Integer id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	private ArrayList<String> patientNotes;

	@Override
	public boolean assignPin(int pin) {
		if (pin >= 1000 || pin <= 9999 ) {
			super.setPin(pin);
			return true;
		}
		else {
		return false;}
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(super.getId() == confirmedAuthID) {
			return true;
		}
		else {
			return false;
		}
		
	}

	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
	
	 public void newPatientNotes(String notes, String patientName, Date date) {
	        String report = String.format(
	            "Datetime Submitted: %s \n", date);
	        report += String.format("Reported By ID: %s\n", this.id);
	        report += String.format("Patient Name: %s\n", patientName);
	        report += String.format("Notes: %s \n", notes);
	        this.patientNotes.add(report);
	    }
	
	
}
