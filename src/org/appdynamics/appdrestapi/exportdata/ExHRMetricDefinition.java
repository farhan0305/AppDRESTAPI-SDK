/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.appdynamics.appdrestapi.exportdata;

import org.appdynamics.appdrestapi.resources.AppExportS;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author gilbert.solorzano
 * L4
 * 
 * 
                            <metric-definition>
                                <type>LOGICAL_METRIC</type>
                                <logical-metric-name>Average Response Time (ms)</logical-metric-name>
                            </metric-definition>
                            
 * 
 */
public class ExHRMetricDefinition {
    private String type;
    private String logicalMetricName;
    
    public ExHRMetricDefinition(){}

    @XmlElement(name=AppExportS.TYPE)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlElement(name=AppExportS.LOGICAL_METRIC_NAME)
    public String getLogicalMetricName() {
        return logicalMetricName;
    }

    public void setLogicalMetricName(String logicalMetricName) {
        this.logicalMetricName = logicalMetricName;
    }
    
    public String whatIsDifferent(ExHRMetricDefinition obj){
        if(this.equals(obj)) return AppExportS._;
        
        StringBuilder bud = new StringBuilder();
        bud.append(AppExportS.L4).append(AppExportS.METRIC_DEFINITION);
        
        if(!type.equals(obj.getType())){     
             bud.append(AppExportS.L4_1).append(AppExportS.TYPE);
             bud.append(AppExportS.L5).append(AppExportS.SRC).append(AppExportS.VE).append(type);
             bud.append(AppExportS.L5).append(AppExportS.DEST).append(AppExportS.VE).append(obj.getType());   
         }
        
        if(!logicalMetricName.equals(obj.getLogicalMetricName())){     
            bud.append(AppExportS.L4_1).append(AppExportS.LOGICAL_METRIC_NAME);
            bud.append(AppExportS.L5).append(AppExportS.SRC).append(AppExportS.VE).append(logicalMetricName);
            bud.append(AppExportS.L5).append(AppExportS.DEST).append(AppExportS.VE).append(obj.getLogicalMetricName());   
        }

        return bud.toString();
    }
    
    @Override
    public String toString(){
        StringBuilder bud = new StringBuilder();
        bud.append(AppExportS.L4).append(AppExportS.METRIC_DEFINITION);
        bud.append(AppExportS.L4_1).append(AppExportS.TYPE).append(AppExportS.VE).append(type);
        bud.append(AppExportS.L4_1).append(AppExportS.LOGICAL_METRIC_NAME).append(AppExportS.VE).append(logicalMetricName);
        return bud.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.type != null ? this.type.hashCode() : 0);
        hash = 41 * hash + (this.logicalMetricName != null ? this.logicalMetricName.hashCode() : 0);
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
        final ExHRMetricDefinition other = (ExHRMetricDefinition) obj;
        if ((this.type == null) ? (other.type != null) : !this.type.equals(other.type)) {
            return false;
        }
        if ((this.logicalMetricName == null) ? (other.logicalMetricName != null) : !this.logicalMetricName.equals(other.logicalMetricName)) {
            return false;
        }
        return true;
    }
    
    
}
