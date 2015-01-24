package modeltest;

import static org.junit.Assert.*;
import model.*;

import org.junit.Test;

public class TopicComponenTest {
	
	@Test
	public void claimReferenceTest() {
		TopicComponent component = new TopicComponent();
		Person jim = new Person("Jim", "Bob", 3, component);
		Topic rocketry = new Topic("Rocketry", component);
		Focus explosions = new Focus("Explosions", rocketry, component);
		jim.claim(rocketry, explosions, 1);
		assertEquals(rocketry, jim.getClaims().get(0).getTopic());		
	}
	
	@Test
	public void assignmentReferenceTest() {
		TopicComponent component = new TopicComponent();
		Person jim = new Person("Jim", "Bob", 3, component);
		Topic rocketry = new Topic("Rocketry", component);
		Focus explosions = new Focus("Explosions", rocketry, component);
		jim.claim(rocketry, explosions, 1);
		jim.assign(jim.getClaims().get(0));
		assertEquals(rocketry, rocketry.getAssignment().getPerson().getClaims().get(0).getFocus().getTopic());		
	}
	
	@Test
	public void deactivatesClaims() {
		TopicComponent component = new TopicComponent();
		Person jim = new Person("Jim", "Bob", 3, component);
		Person joe = new Person("Joe", "Bob", 1, component);
		Topic rocketry = new Topic("Rocketry", component);
		Topic nuclearPhysics = new Topic("nuclearPhysics", component);
		Focus explosions = new Focus("Explosions", rocketry, component);
		jim.claim(rocketry, explosions, 1);
		joe.claim(nuclearPhysics, null, 2);
		jim.claim(nuclearPhysics, null, 2);
		jim.assign(jim.getClaims().get(0));
		assertEquals(1, nuclearPhysics.numActiveClaims());	
	}
	
	@Test
	public void deactivatesMultiplePersonsClaims() {
		TopicComponent component = new TopicComponent();
		Person jim = new Person("Jim", "Bob", 3, component);
		Person joe = new Person("Joe", "Bob", 1, component);
		Topic rocketry = new Topic("Rocketry", component);
		Topic chemistry = new Topic("Chemistry", component);
		Topic nuclearPhysics = new Topic("Nuclear Physics", component);
		Focus explosions = new Focus("Explosions", rocketry, component);
		jim.claim(rocketry, explosions, 1);
		joe.claim(nuclearPhysics, null, 2);
		joe.claim(chemistry, null, 3);
		jim.claim(nuclearPhysics, null, 2);
		jim.assign(jim.getClaims().get(0));
		joe.assign(jim.getClaims().get(1));
		assertEquals(0, nuclearPhysics.numActiveClaims());	
	}
	
	

}
