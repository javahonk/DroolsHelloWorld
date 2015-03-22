package com.javahonk;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;

import com.javahonk.drools.Sample;

public class MultipleDroolsFile {

	public static void main(String[] args) throws DroolsParserException, IOException {
		
		MultipleDroolsFile multipleDroolsFile = new MultipleDroolsFile();
		multipleDroolsFile.executeHelloWorldRules();

	}

	public void executeHelloWorldRules() throws IOException, DroolsParserException {

		PackageBuilder packageBuilder = new PackageBuilder();
		
		String[] ruleFile = { "/com/javahonk/drools/Sample.drl",
				"/com/javahonk/drools/printPizzaPrice.drl" };
		for (String string : ruleFile) {
			// Convert rule file to InputStream
			InputStream resourceAsStream = getClass().getResourceAsStream(string);

			Reader reader = new InputStreamReader(resourceAsStream);
			packageBuilder.addPackageFromDrl(reader);
		}
		
		org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();		
		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(rulesPackage);
		
		//Create new WorkingMemory session for this RuleBase. By default the RuleBase retains a weak reference to returned WorkingMemory
		WorkingMemory workingMemory = ruleBase.newStatefulSession();

		Sample helloWorld = new Sample();
		helloWorld.setPrintMessage("Pizza Price");
		
		helloWorld.setPrice(12);		
		
		//Insert and fire all rules until its empty
		workingMemory.insert(helloWorld);
		workingMemory.fireAllRules();

	}

}
