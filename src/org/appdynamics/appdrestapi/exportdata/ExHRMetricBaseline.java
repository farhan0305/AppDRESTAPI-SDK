/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.appdynamics.appdrestapi.exportdata;

import org.appdynamics.appdrestapi.resources.AppExportS;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author gilbert.solorzano
 * 
 * 
<metric-baseline>
    <name>All data - Last 15 days</name>
</metric-baseline>
 * 
 */
public class ExHRMetricBaseline {
    private String name;
    
    public ExHRMetricBaseline(){}

    @XmlElement(name=AppExportS.NAME)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String whatIsDifferent(ExHRMetricBaseline obj){
        if(this.equals(obj)) return AppExportS._;
        
        StringBuilder bud = new StringBuilder();
        bud.append(AppExportS.L3).append(AppExportS.METRIC_BASELINE);
        bud.append(AppExportS.L3_1).append(AppExportS.NAME).append(AppExportS.VE).append(name);
        bud.append(AppExportS.L3_1).append(AppExportS.SRC).append(AppExportS.VE).append(name);
             bud.append(AppExportS.L3_1).append(AppExportS.DEST).append(AppExportS.VE).append(obj.getName()); 
        return bud.toString();
    }
    
    @Override
    public String toString(){
        StringBuilder bud = new StringBuilder();
        bud.append(AppExportS.L3).append(AppExportS.METRIC_BASELINE);
        bud.append(AppExportS.L3_1).append(AppExportS.NAME).append(AppExportS.VE).append(name);
        return bud.toString();
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExHRMetricBaseline other = (ExHRMetricBaseline) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }
    
    
}
