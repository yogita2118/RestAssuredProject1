package com.thetestingacademy.ex_25062024.Listeners;

import org.testng.IAlterSuiteListener;
import org.testng.IExecutionListener;

public class CustomeListener implements IExecutionListener, IAlterSuiteListener {

    @Override
    public void onExecutionStart() {
        System.out.println("onExecutionStart");
        long startTime = System.currentTimeMillis();
        System.out.println(" ****   *** Started execution at - " + startTime + "****   *** ");
    }

    @Override
    public void onExecutionFinish() {
        long endTime = System.currentTimeMillis();
        System.out.println("****   *** Finished execution at- " + endTime + "****   *** ");
        System.out.println("onExecutionFinish");


        // Send email to the QA lead
        // Write Java code to write the Email to QA lead

    }
}
