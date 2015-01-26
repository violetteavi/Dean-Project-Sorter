package algorithm;

import java.util.List;

import model.*;

public class UndisputedSolver {
	
	public void solve(TopicComponent component) {
		int previousUnassigned = -1;
		int numUnassigned = numUnassigned(component.getPersons());
		while(numUnassigned!=previousUnassigned) {
			previousUnassigned = numUnassigned;
			for(Person p: component.getPersons()) {
				if(p.getAssignment()==null) {
					for(Claim claim: p.getClaims()) {
						//claims are sorted by priority
						if(p.getAssignment()==null&&claim.getTopic().numActiveClaims()==1) {
							p.assign(claim);
						}
					}
				}
			}
			numUnassigned = numUnassigned(component.getPersons());
		}
	}

	private int numUnassigned(List<Person> persons) {
		int numUnassigned = 0;
		for(Person person: persons) {
			if(person.getAssignment()==null) {
				numUnassigned++;
			}
		}
		return numUnassigned;
	}

}
