/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author btstajyer
 */
public class HostPrinter {

    private String ipAddress;
    private String hostName;
    private String percentCartridge;

    public HostPrinter(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * @return the ipAddress
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * @param ipAddress the ipAddress to set
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * @return the hostName
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * @param hostName the hostName to set
     */
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    /**
     * @return the percentCartridge
     */
    public String getPercentCartridge() {
        return percentCartridge;
    }

    /**
     * @param percentCartridge the percentCartridge to set
     */
    public void setPercentCartridge(String percentCartridge) {
        this.percentCartridge = percentCartridge;
    }

}
