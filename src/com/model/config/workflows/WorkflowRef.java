package com.model.config.workflows;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import javax.servlet.ServletContextEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.model.common.NameTagParam;
import com.model.common.RowColStore;
import com.model.common.Vars;

public class WorkflowRef {
	private static HashMap<String, Workflow> workflows = null;
	private static Logger logger;

	static {
		logger = Logger.getLogger(WorkflowRef.class);
		workflows = new HashMap<String, Workflow>();
	}

	public static void loadWorkflows(ServletContextEvent event) {
		String appBasePath=null;
		String workflowsRelativePath=null;
		
		appBasePath=event.getServletContext().getInitParameter(Vars.APPBASE_PATH);
		workflowsRelativePath=event.getServletContext().getInitParameter(Vars.WORKFLOWS_RELATIVE_PATH);
		for (File workflowXML : new File(appBasePath.concat(workflowsRelativePath)).listFiles()) {
			try {
				load(new FileInputStream(workflowXML));
			} catch (FileNotFoundException e) {
				logger.error("FileNotFoundException Occurred during loading workflows:" + e.getMessage(), e);
			}
		}
	}

	private static void load(InputStream workflowXML) {
		DocumentBuilder builder = null;
		DocumentBuilderFactory factory = null;
		Document document = null;
		NodeList workflowsXML = null;

		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			document = builder.parse(workflowXML);
			document.getDocumentElement().normalize();
			workflowsXML = document.getDocumentElement().getChildNodes(); // WORKFLOW tags
			for (int index = 0; index < workflowsXML.getLength(); index++) {
				switch (workflowsXML.item(index).getNodeType()) {
					case Node.ELEMENT_NODE:
						load((Element) workflowsXML.item(index));
						break;
				}
			}
		} catch (ParserConfigurationException e) {
			logger.error("ParserConfigurationException Occurred during loading workflows:" + e.getMessage(), e);
		} catch (ClassNotFoundException e) {
			logger.error("ClassNotFoundException Occurred during loading workflows:" + e.getMessage(), e);
		} catch (SAXException e) {
			logger.error("SAXException Occurred during loading workflows:" + e.getMessage(), e);
		} catch (IOException e) {
			logger.error("IOException Occurred during loading workflows:" + e.getMessage(), e);
		} catch (NoSuchMethodException e) {
			logger.error("NoSuchMethodException Occurred during loading workflows:" + e.getMessage(), e);
		} catch (SecurityException e) {
			logger.error("SecurityException Occurred during loading workflows:" + e.getMessage(), e);
		} 
	}

	private static void load(Element workflowXML) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		Workflow workflow = null;
		Actions workflowActions = null;
		NodeList pagesNodes = null;
		NodeList actionsNodes = null;
		HashMap<String, String> pagesList = null;
		HashMap<String, Actions> actionsList = null;
		Element pageElement = null;
		Element actionElement = null;
		
		pagesList = new HashMap<String, String>();
		actionsList = new HashMap<String, Actions>();
		workflow = new WorkflowRepresentation(workflowXML.getAttribute("name"));
		workflow.setActions(actionsList);
		workflow.setPagesList(pagesList);
		workflow.setHandlerClass(Class.forName(workflowXML.getAttribute("class")));
		pagesNodes = workflowXML.getElementsByTagName("PAGE");
		
		for (int index = 0; index < pagesNodes.getLength(); index++) {
			pageElement = (Element) pagesNodes.item(index);
			switch (pageElement.getNodeType()) {
				case Node.ELEMENT_NODE:
					pagesList.put(pageElement.getAttribute("name"), pageElement.getAttribute("jsp"));
					break;
			}
		}

		actionsNodes = workflowXML.getElementsByTagName("ACTION");
		for (int index = 0; index < actionsNodes.getLength(); index++) {
			actionElement = (Element) actionsNodes.item(index);
			switch (actionElement.getNodeType()) {
				case Node.ELEMENT_NODE:
					workflowActions=getWorkflowAction(actionElement);
					workflowActions.setWorkflow(new WeakReference<Workflow>(workflow));
					workflowActions.setMethod(workflow.getHandlerClass().getMethod(actionElement.getAttribute("method"), getParamters()));
					actionsList.put(actionElement.getAttribute("name"),workflowActions);
					break;
			}
		}
		
		workflows.put(workflowXML.getAttribute("name"), workflow);
	}
	
	private static Actions getWorkflowAction(Element actionElement) {
		Actions workflowActions = null;
		HashMap<String,Results> resultsList=null;
		NodeList resultsNodes = null;
		Element resultElement = null;
		
		resultsNodes=actionElement.getElementsByTagName("RESULT");
		resultsList=new HashMap<String,Results>();
		for(int index=0; index<resultsNodes.getLength(); index++) {
			resultElement=(Element)resultsNodes.item(index);
			switch (resultElement.getNodeType()) {
				case Node.ELEMENT_NODE:
					putWorkflowResult(resultsList,resultElement);
					break;
			}
		}
		workflowActions = new WorkflowActions();
		workflowActions.setResultsList(resultsList);
		return workflowActions;
	}
	
	private static void putWorkflowResult(HashMap<String,Results> resultsList, Element resultElement) {
		Element navigationElement=null;
		NodeList navigationList=null;
		Results workflowResults=null;
		
		workflowResults=new WorkflowResults();
		workflowResults.setResultName(resultElement.getAttribute("name"));
		workflowResults.setDestName(resultElement.getAttribute("dest"));
		navigationList=resultElement.getElementsByTagName("NAVIGATION");
		for(int index=0; index<navigationList.getLength(); index++) {
			navigationElement=(Element)navigationList.item(index);
			switch (navigationElement.getNodeType()) {
				case Node.ELEMENT_NODE:
					workflowResults.setNavigation(navigationElement.getTextContent().trim());
					break;
			}
		}
		resultsList.put(resultElement.getAttribute("name"), workflowResults);
	}
	
	private static Class<?>[] getParamters() throws ClassNotFoundException {
		return new Class<?>[] { 
			Class.forName("javax.servlet.http.HttpServletRequest"),
			Class.forName("javax.servlet.http.HttpServletResponse"),
			Class.forName("com.model.common.RowColStore"),
			Class.forName("com.model.common.NameTagParam") 
		};
	}
	
	public static Object[] getArgument(HttpServletRequest request, HttpServletResponse response,RowColStore rcs,NameTagParam ntp) {
		return new Object[] {request,response,rcs,ntp};
		
	}
	public static HashMap<String, Workflow> getWorkflows() {
		return workflows;
	}
	
}
