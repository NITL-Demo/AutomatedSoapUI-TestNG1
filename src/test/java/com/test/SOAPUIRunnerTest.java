package com.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.eviware.soapui.impl.wsdl.panels.support.MockTestRunner;
import java.util.*;
import com.eviware.soapui.impl.wsdl.WsdlProjectPro;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCaseRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.model.testsuite.TestStep;
import com.eviware.soapui.support.types.StringToObjectMap;
import com.eviware.soapui.model.testsuite.TestCaseRunContext;
import com.eviware.soapui.impl.wsdl.WsdlProject; 
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase; 
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCaseRunner; 
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestRunContext; 
import com.eviware.soapui.model.testsuite.LoadTest; 
import com.eviware.soapui.model.testsuite.TestCase; 
import com.eviware.soapui.model.testsuite.TestStep; 
import com.eviware.soapui.model.testsuite.TestStepResult; 
import com.eviware.soapui.model.testsuite.TestSuite; 


public class SOAPUIRunnerTest {


    
	
    @Test
    public void test() {
		
		  try { 
                        String projectFile = "/var/lib/jenkins/workspace/App_Exec_NFRTestNG/Pizzas-soapui-project.xml";
			WsdlProject project = new WsdlProject(projectFile); 
			for (TestSuite testSuite : project.getTestSuiteList()) { 

			System.out.println("TestSuiteProject size......" + project.getTestSuiteList().size()); 
			System.out.println("TestSuiteProject......" + testSuite.getName()); 

			for (TestCase testCase : testSuite.getTestCaseList()) { 

				System.out.println("TestCases........." + testCase.getName()); 




				StringToObjectMap properties = new StringToObjectMap(); 
				//properties.put("username", userName); 
				//properties.put("password", passWord); 
				//properties.put("localhost", localHost); 
				//properties.put("HttpDefaultPort", port); 
				List<TestStep> testSteps = testCase.getTestStepList(); 


				// TestRunner runner = testCase.run(properties, false); 
				WsdlTestCaseRunner wsdlTestCaseRunner = new WsdlTestCaseRunner((WsdlTestCase) testCase, properties); 
				WsdlTestRunContext wsdlTestRunContext = wsdlTestCaseRunner.createContext(properties); 
				wsdlTestCaseRunner.run(); 





									

				WsdlTestCase wsdlTestCase = wsdlTestCaseRunner.getTestRunnable(); 
				System.out.println("Functional test case " + wsdlTestCase); 
				List<TestStepResult> testStepResult = (List<TestStepResult>) wsdlTestCaseRunner.getResults(); 
				System.out.println("Test stepResults............." + testStepResult); 
				System.out.println("Test stepResultsn size ............." + testStepResult.size()); 
				// System.out.println("Test stepResultsn size ............." + testStepResult.); 
				Iterator<TestStepResult> testIterator = testStepResult.iterator(); 
				while (testIterator.hasNext()) { 
						TestStepResult tsestStepResult = testIterator.next(); 
						System.out.println("Test step next element ..... " + tsestStepResult.toString()); 
						//System.out.println("Test step size..... " + tsestStepResult.getSize()); 
						System.out.println("Test step Status..... " + tsestStepResult.getStatus()); 
				} 


			    /*
								List<LoadTest> loadtest = wsdlTestCase.getLoadTestList(); 
								System.out.println("Load test cases " + loadtest); 
								Iterator<LoadTest> loadIterator = loadtest.iterator(); 
								System.out.println("Load test size...." + loadtest.size()); 

								while (loadIterator.hasNext()) { 
										LoadTest loadTest = loadIterator.next(); 

										System.out.println("Load Test " + loadTest); 

								}
			    */
								//break; 
						} 

				    //System.exit(1); 
				} 

			  } catch (Exception e) { 
			         e.printStackTrace(); 
			  } 

	   } 
						
	}
	
	


