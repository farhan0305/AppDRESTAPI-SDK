/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.appdynamics.appdrestapi.exportdata;
import org.appdynamics.appdrestapi.resources.AppExportS;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author gilbert.solorzano
 * 
 *                          <match-class type="inherits-from-class">
                                <name filter-type="EQUALS" filter-value="it.sauronsoftware.cron4j.Task"/>
                            </match-class>5
                            * 5
 */
@XmlSeeAlso(ExMatchClassName.class)
public class ExMatchClass {
    private String type;
    private ExMatchClassName matchClassName;
    
    public ExMatchClass(){}

    @XmlAttribute(name=AppExportS.TYPE)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlElement(name=AppExportS.NAME)
    public ExMatchClassName getMatchClassName() {
        return matchClassName;
    }

    public void setMatchClassName(ExMatchClassName matchClassName) {
        this.matchClassName = matchClassName;
    }
    
    public String whatIsDifferent(ExMatchClass obj){
        if(this.equals(obj) || !type.equals(obj.getType())) return AppExportS._;
        
        StringBuilder bud = new StringBuilder();
        
        bud.append(AppExportS.L4).append(AppExportS.TYPE).append(AppExportS.VE).append(type);
    
        bud.append(matchClassName.whatIsDifferent(obj.getMatchClassName()));
        
        return bud.toString();
    }
    
    
    @Override
    public String toString(){
        StringBuilder bud = new StringBuilder();
        bud.append(AppExportS.L3_1).append(AppExportS.MATCH_CLASS);
        bud.append(AppExportS.L4).append(AppExportS.TYPE).append(AppExportS.VE).append(type);
        bud.append(matchClassName);
        return bud.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.type != null ? this.type.hashCode() : 0);
        hash = 83 * hash + (this.matchClassName != null ? this.matchClassName.hashCode() : 0);
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
        final ExMatchClass other = (ExMatchClass) obj;
        if ((this.type == null) ? (other.type != null) : !this.type.equals(other.type)) {
            return false;
        }
        if (this.matchClassName != other.matchClassName && (this.matchClassName == null || !this.matchClassName.equals(other.matchClassName))) {
            return false;
        }
        return true;
    }
    
    
    
}
