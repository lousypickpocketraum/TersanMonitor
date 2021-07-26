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

/**
 *
 * @author btstajyer
 */
public class PrinterController {

    public static List<String> sendPingRequest(String ipAddress)
            throws UnknownHostException, IOException {
        List<String> listReachableIPS = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            InetAddress result = InetAddress.getByName(ipAddress + "." + i);
            if (result.isReachable(3000)) {
                listReachableIPS.add("Host address: " + result.getHostAddress() + " Host name: " + result.getHostName());

            }
        }
        return listReachableIPS;
    }
}
