/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trs.bt.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import model.HostPrinter;

/**
 *
 * @author btstajyer
 */
public class PrinterController {

    public static List<HostPrinter> sendPingRequest(String ipAddress) {
        List<HostPrinter> listHostPrinter = new ArrayList<>();
        try {
            for (int i = 0; i <= 2; i++) {
                InetAddress inetAddressResult = InetAddress.getByName(ipAddress + "." + i);
                if (inetAddressResult.isReachable(3000)) {
                    System.out.println("Printerc Controller : " + inetAddressResult.getHostAddress());
                    HostPrinter hp = new HostPrinter(inetAddressResult.getHostAddress());
                    hp.setHostName(inetAddressResult.getHostName());
                    hp.setIpAddress(inetAddressResult.getHostAddress());
                    listHostPrinter.add(hp);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return listHostPrinter;
    }
}
