package runner;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import model.TopicComponent;

import org.apache.commons.csv.CSVRecord;

import algorithm.AlgorithmComponent;

import readwrite.*;

public class Runner {
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Welcome to the research project assignment solver.");
		System.out.println("What file would you like to read from?");
		String inputPath = kb.nextLine(); //"C:\\Users\\family\\git\\Dean-Project-Sorter\\TestFile1.csv";
		System.out.println("What file would you like to write to?");
		String outputPath = kb.nextLine(); //"C:\\Users\\family\\git\\Dean-Project-Sorter\\TestFileOutput1.csv";
		ReadWriteComponent io = new ReadWriteComponent();
		TopicComponent tComponent = new TopicComponent();
		AlgorithmComponent solver = new AlgorithmComponent();
		try {
			io.populateTopicComponent(tComponent, inputPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		solver.solveUndisputed(tComponent);
		try {
			io.outputSolutions(tComponent, outputPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done!");
	}

}
