package algorithm;

import model.TopicComponent;

public class AlgorithmComponent {
	
	UndisputedSolver undisputed;
	
	public AlgorithmComponent() {
		undisputed = new UndisputedSolver();
	}
	
	public void solveUndisputed(TopicComponent tComponent) {
		undisputed.solve(tComponent);
	}

}
