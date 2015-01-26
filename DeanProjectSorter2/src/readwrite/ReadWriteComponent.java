package readwrite;

import java.io.File;
import java.io.IOException;

import model.TopicComponent;

public class ReadWriteComponent {
	
	CSVReader reader;
	CSVTranslator translator;
	CSVWriter writer;

	public ReadWriteComponent() {
		reader = new CSVReader();
		translator = new CSVTranslator();
		writer = new CSVWriter();
	}
	
	public void populateTopicComponent(TopicComponent tComponent, String inputPath) throws IOException {
		translator.populateTopicComponent(reader.parse(new File(inputPath)), tComponent);
	}
	
	public void outputSolutions(TopicComponent tComponent, String outputPath) throws IOException {
		writer.outputSolutions(tComponent, outputPath);
	}
}
