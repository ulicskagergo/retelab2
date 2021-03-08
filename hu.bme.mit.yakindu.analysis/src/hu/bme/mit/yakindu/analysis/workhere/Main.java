package hu.bme.mit.yakindu.analysis.workhere;

import java.util.List;
import java.util.Random;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.junit.Test;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.base.types.Event;
import org.yakindu.base.types.Property;
import org.yakindu.sct.model.sgraph.Scope;

import hu.bme.mit.model2gml.Model2GML;
import hu.bme.mit.yakindu.analysis.example.IExampleStatemachine;
import hu.bme.mit.yakindu.analysis.modelmanager.ModelManager;

public class Main {
	@Test
	public void test() {
		main(new String[0]);
	}
	
	public static void main(String[] args) {
		ModelManager manager = new ModelManager();
		Model2GML model2gml = new Model2GML();
		
		// Loading model
		EObject root = manager.loadModel("model_input/example.sct");
		
		// Reading model
		/*Statechart s = (Statechart) root;
		TreeIterator<EObject> iterator = s.eAllContents();
		while (iterator.hasNext()) {
			EObject content = iterator.next();
			if(content instanceof State) {
				State state = (State) content;
				System.out.println(state.getName());
				if(state.getOutgoingTransitions().isEmpty())
					System.out.println("Trap: " + state.getName());
				if(state.getName().length() == 0) {
					Random rand = new Random();
					String name = Integer.toString(rand.nextInt());
					System.out.println("State has no name. Maybe " + name + "?");
				}
			}
			else if(content instanceof Transition) {
				Transition trans = (Transition) content;
				System.out.println(trans.getSource().getName() + " -> " + trans.getTarget().getName());
			}			
		}*/
		
		System.out.println("import java.io.IOException;\r\n" + 
				"import java.util.Scanner;\r\n" + 
				"\r\n" + 
				"import hu.bme.mit.yakindu.analysis.RuntimeService;\r\n" + 
				"import hu.bme.mit.yakindu.analysis.TimerService;\r\n" + 
				"import hu.bme.mit.yakindu.analysis.example.ExampleStatemachine;\r\n" + 
				"import hu.bme.mit.yakindu.analysis.example.IExampleStatemachine;\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"public class RunStatechart {\r\n" + 
				"	\r\n" + 
				"	public static void main(String[] args) throws IOException {\r\n" + 
				"		\r\n" + 
				"		ExampleStatemachine s = new ExampleStatemachine();\r\n" + 
				"		s.setTimer(new TimerService());\r\n" + 
				"		RuntimeService.getInstance().registerStatemachine(s, 200);\r\n" + 
				"		s.init();\r\n" + 
				"		s.enter();\r\n" + 
				"		s.runCycle();\r\n" + 
				"		\r\n" + 
				"		Scanner scanner = new Scanner(System.in);\r\n" + 
				"		String readed = \"\";\n" +
				"		while(true) {\r\n" + 
				"			readed = scanner.nextLine();\r\n" + 
				"			switch(readed) {\n" +
				"			case \"exit\":\r\n" + 
				"				System.exit(0);");
		Statechart s = (Statechart) root;
		for(Scope scope : s.getScopes()){
			for(Event event : scope.getEvents()) {
					String tmp = event.getName().substring(0,1).toUpperCase() + event.getName().substring(1);
					System.out.println("\t\t\tcase \"" + event.getName() + "\":\n\t\t\t\ts.raise" + tmp + "();");
				}
			}
		System.out.println("			}\r\n" + 
				"			s.runCycle();\r\n" + 
				"			print(s);\r\n" + 
				"		}\r\n" + 
				"	}\n" +
				"	public static void print(IExampleStatemachine s) {");
		for(Scope scope : s.getScopes()){
			for(Property property : scope.getVariables()) {
				String tmp = property.getName().substring(0,1).toUpperCase() + property.getName().substring(1);
				System.out.println("\t\tSystem.out.println(\"" + tmp.charAt(0) + " = \" + s.getSCInterface().get" + tmp + "());");
			}
		}
		System.out.println("	}\r\n" + 
				"}");
		
		// Transforming the model into a graph representation
		String content = model2gml.transform(root);
		// and saving it
		manager.saveFile("model_output/graph.gml", content);
	}
}
