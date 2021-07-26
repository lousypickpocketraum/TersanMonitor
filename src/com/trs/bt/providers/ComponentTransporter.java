/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trs.bt.providers;

import java.util.List;
import org.openide.windows.TopComponent;

/**
 *
 * @author btstajyer
 */
public class ComponentTransporter {

    private static ComponentTransporter componentTransporter = null;

    private TopComponent topComponentExplorerTreeMonitor;
    private TopComponent topComponentEditorMonitor;
    private List<String> ipList;
    private ComponentTransporter() {
    }
    
    public static ComponentTransporter getComponentTransporter() {
        if (componentTransporter == null) {
            componentTransporter = new ComponentTransporter();
        }
        return componentTransporter;
    }

    public TopComponent getTopComponentExplorerTreeMonitor() {
        return topComponentExplorerTreeMonitor;
    }

    public void setTopComponentExplorerTreeMonitor(TopComponent topComponentExplorerTreeMonitor) {
        this.topComponentExplorerTreeMonitor = topComponentExplorerTreeMonitor;
    }

    

    public TopComponent getTopComponentEditorMonitor() {
        return topComponentEditorMonitor;
    }

    public void setTopComponentEditorMonitor(TopComponent topComponentEditorMonitor) {
        this.topComponentEditorMonitor = topComponentEditorMonitor;
    }

    /**
     * @return the ipList
     */
    public List<String> getIpList() {
        return ipList;
    }

    /**
     * @param ipList the ipList to set
     */
    public void setIpList(List<String> ipList) {
        this.ipList = ipList;
    }
    
    public void fillTree(){
        topComponentExplorerTreeMonitor.getComponents();
        for (String string : ipList) {
            
        }
    }
}
