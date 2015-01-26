package algorithmtest;

import static org.junit.Assert.assertEquals;
import model.*;

import org.junit.Before;
import org.junit.Test;

import algorithm.UndisputedSolver;

public class UndisputedSolverTest {
	
	private TopicComponent component;
	private Person[] peopleInputs;
	private Topic[] topicInputs;
	
	@Before
	public void init() {
		component = new TopicComponent();
		peopleInputs = new Person[5];
		peopleInputs[0] = new Person("Jim", "Bob", 3, component);
		peopleInputs[1] = new Person("Joe", "Bob", 1, component);
		peopleInputs[2] = new Person("Josh", "Bob", 1, component);
		peopleInputs[3] = new Person("Jake", "Bob", 1, component);
		peopleInputs[4] = new Person("James", "Bob", 1, component);
		
		topicInputs = new Topic[9];
		topicInputs[0] = new Topic("Rocketry", component);
		topicInputs[1] = new Topic("Rocketry1", component);
		topicInputs[2] = new Topic("Rocketry2", component);
		topicInputs[3] = new Topic("Nuclear Physics", component);
		topicInputs[4] = new Topic("Nuclear Physics1", component);
		topicInputs[5] = new Topic("Nuclear Physics2", component);
		topicInputs[6] = new Topic("Chemistry", component);
		topicInputs[7] = new Topic("Chemistry1", component);
		topicInputs[8] = new Topic("Chemistry2", component);
		
	}

	@Test
	public void noConflicts() {
		peopleInputs[0].claim(topicInputs[0], null, 1);
		peopleInputs[0].claim(topicInputs[1], null, 2);
		peopleInputs[0].claim(topicInputs[2], null, 3);
		peopleInputs[1].claim(topicInputs[3], null, 1);
		peopleInputs[1].claim(topicInputs[4], null, 2);
		peopleInputs[1].claim(topicInputs[5], null, 3);
		peopleInputs[2].claim(topicInputs[6], null, 1);
		peopleInputs[2].claim(topicInputs[7], null, 2);
		peopleInputs[2].claim(topicInputs[8], null, 3);
		
		UndisputedSolver test = new UndisputedSolver();
		test.solve(component);
		assertEquals(topicInputs[0], peopleInputs[0].getAssignment().getTopic());	
		assertEquals(topicInputs[3], peopleInputs[1].getAssignment().getTopic());	
		assertEquals(topicInputs[6], peopleInputs[2].getAssignment().getTopic());	
	}

	@Test
	public void noConflictsOutOfOrder() {
		peopleInputs[0].claim(topicInputs[0], null, 3);
		peopleInputs[0].claim(topicInputs[1], null, 2);
		peopleInputs[0].claim(topicInputs[2], null, 1);
		peopleInputs[1].claim(topicInputs[3], null, 2);
		peopleInputs[1].claim(topicInputs[4], null, 1);
		peopleInputs[1].claim(topicInputs[5], null, 3);
		peopleInputs[2].claim(topicInputs[6], null, 2);
		peopleInputs[2].claim(topicInputs[7], null, 3);
		peopleInputs[2].claim(topicInputs[8], null, 1);
		
		UndisputedSolver test = new UndisputedSolver();
		test.solve(component);
		assertEquals(topicInputs[2], peopleInputs[0].getAssignment().getTopic());	
		assertEquals(topicInputs[4], peopleInputs[1].getAssignment().getTopic());	
		assertEquals(topicInputs[8], peopleInputs[2].getAssignment().getTopic());	
	}

	@Test
	public void solvesBasicConflicts() {
		peopleInputs[0].claim(topicInputs[0], null, 1);
		peopleInputs[0].claim(topicInputs[1], null, 2);
		peopleInputs[0].claim(topicInputs[2], null, 3);
		peopleInputs[1].claim(topicInputs[2], null, 1);
		peopleInputs[1].claim(topicInputs[4], null, 2);
		peopleInputs[1].claim(topicInputs[5], null, 3);
		peopleInputs[2].claim(topicInputs[5], null, 1);
		peopleInputs[2].claim(topicInputs[7], null, 2);
		peopleInputs[2].claim(topicInputs[8], null, 3);
		
		UndisputedSolver test = new UndisputedSolver();
		test.solve(component);
		assertEquals(topicInputs[0], peopleInputs[0].getAssignment().getTopic());	
		assertEquals(topicInputs[2], peopleInputs[1].getAssignment().getTopic());	
		assertEquals(topicInputs[5], peopleInputs[2].getAssignment().getTopic());	
	}

	@Test
	public void solvesNestedConflicts() {
		peopleInputs[0].claim(topicInputs[0], null, 1);
		peopleInputs[0].claim(topicInputs[1], null, 2);
		peopleInputs[0].claim(topicInputs[2], null, 3);
		peopleInputs[1].claim(topicInputs[3], null, 1);
		peopleInputs[1].claim(topicInputs[0], null, 2);
		peopleInputs[1].claim(topicInputs[5], null, 3);
		peopleInputs[2].claim(topicInputs[3], null, 1);
		peopleInputs[2].claim(topicInputs[2], null, 2);
		peopleInputs[2].claim(topicInputs[0], null, 3);
		
		UndisputedSolver test = new UndisputedSolver();
		test.solve(component);
		assertEquals(topicInputs[1], peopleInputs[0].getAssignment().getTopic());	
		assertEquals(topicInputs[5], peopleInputs[1].getAssignment().getTopic());	
		assertEquals(topicInputs[3], peopleInputs[2].getAssignment().getTopic());	
	}

	@Test
	public void solvesExtremelyNestedConflicts() {
		peopleInputs[0].claim(topicInputs[0], null, 1);
		peopleInputs[0].claim(topicInputs[1], null, 2);
		peopleInputs[1].claim(topicInputs[0], null, 1);
		peopleInputs[1].claim(topicInputs[1], null, 2);
		peopleInputs[1].claim(topicInputs[2], null, 3);
		peopleInputs[2].claim(topicInputs[1], null, 1);
		peopleInputs[2].claim(topicInputs[2], null, 2);
		peopleInputs[2].claim(topicInputs[3], null, 3);
		peopleInputs[3].claim(topicInputs[2], null, 1);
		peopleInputs[3].claim(topicInputs[3], null, 2);
		peopleInputs[3].claim(topicInputs[4], null, 3);
		peopleInputs[4].claim(topicInputs[3], null, 1);
		peopleInputs[4].claim(topicInputs[4], null, 2);
		peopleInputs[4].claim(topicInputs[5], null, 3);
		
		UndisputedSolver test = new UndisputedSolver();
		test.solve(component);
		assertEquals(topicInputs[0], peopleInputs[0].getAssignment().getTopic());	
		assertEquals(topicInputs[2], peopleInputs[1].getAssignment().getTopic());	
		assertEquals(topicInputs[3], peopleInputs[2].getAssignment().getTopic());
		assertEquals(topicInputs[4], peopleInputs[3].getAssignment().getTopic());	
		assertEquals(topicInputs[5], peopleInputs[4].getAssignment().getTopic());	
	}
}
