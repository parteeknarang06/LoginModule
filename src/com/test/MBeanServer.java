package com.test;

import java.lang.management.ManagementFactory;
import javax.management.*;

public class MBeanServer {
	private javax.management.MBeanServer mbs = null;
    public MBeanServer() {
        // Get the platform MBeanServer
        mbs = ManagementFactory.getPlatformMBeanServer();
        // Unique identification of MBeans
        Hello helloBean = new Hello();
        ObjectName helloName = null;
        try {
            // Uniquely identify the MBeans and register them with the platform MBeanServer 
            helloName = new ObjectName("FOO:name=HelloBean");
            mbs.registerMBean(helloBean, helloName);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // Utility method: so that the application continues to run
    private static void waitForEnterPressed() {
        try {
            System.out.println("Press  to continue...");
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String argv[]) {
    	MBeanServer agent = new MBeanServer();
        System.out.println("SimpleAgent is running...");
        MBeanServer.waitForEnterPressed();
     }
}
