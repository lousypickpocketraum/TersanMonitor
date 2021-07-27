/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trs.bt.providers;

import java.awt.Component;
import java.awt.Rectangle;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JViewport;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import model.HostPrinter;
import org.openide.windows.TopComponent;

/**
 *
 * @author btstajyer
 */
public class ComponentTransporter {

    private static ComponentTransporter componentTransporter = null;

    private TopComponent topComponentExplorerTreeMonitor;
    private TopComponent topComponentEditorMonitor;
    private List<HostPrinter> ipList;

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
    public List<HostPrinter> getIpList() {
        return ipList;
    }

    /**
     * @param ipList the ipList to set
     */
    public void setIpList(List<HostPrinter> ipList) {
        this.ipList = ipList;
    }

    public void fillTree() {
        topComponentExplorerTreeMonitor.getComponents();
        for (Component component : topComponentExplorerTreeMonitor.getComponents()) {
            if (component instanceof JPanel) {
                System.out.println("Component JPanel: " + component.getName() + " : " + component.getClass());
                JPanel jPanel = (JPanel) component;
                for (Component component2 : jPanel.getComponents()) {
                    System.out.println("Component2 JScrollPane " + component2.getName() + " : " + component2.getClass());
                    JScrollPane jScrollPane = (JScrollPane) component2;
                    for (Component component3 : jScrollPane.getComponents()) {
                        System.out.println("Component3 JViewPort: " + component3.getName() + " " + component3.getClass());
                        JViewport jViewPort = (JViewport) component3;
                        for (Component component4 : jViewPort.getComponents()) {
                            if (component4 instanceof JTree) {
                                JTree jTree = (JTree) component4;
                                jTree.removeAll();
                                System.out.println("component4 JTree: " + jTree.getName() + " " + component4.getClass());
                                DefaultMutableTreeNode treeNodeRoot = new DefaultMutableTreeNode("Printer Listesi");
                                DefaultMutableTreeNode defaultMutableTreeNode;
                                for (HostPrinter hp : ipList) {
                                    System.out.println("tree dolduruyoruz : " + hp.getIpAddress());
                                    defaultMutableTreeNode = new DefaultMutableTreeNode(hp.getIpAddress());
                                    treeNodeRoot.add(defaultMutableTreeNode);
                                }
                                DefaultTreeModel defaultTreeModel = new DefaultTreeModel(treeNodeRoot);
                                jTree.setModel(defaultTreeModel);
                                return;
                            }
                        }
                    }
                }
            } else {
                System.out.println("Unknown: " + component.getName() + " : " + component.getClass());
            }
        }
    }

}
