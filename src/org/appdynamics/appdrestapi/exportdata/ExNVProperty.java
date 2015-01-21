/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.appdynamics.appdrestapi.exportdata;

import org.appdynamics.appdrestapi.resources.AppExportS;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author gilbert.solorzano
 * 
                                    <properties>
                                        <property name="uri-suffix-scheme" value="custom-expression"/>
                                        <property name="suffix-key" value="${}"/>
                                    </properties>
 * 
 */
public class ExNVProperty {
    private String name;
    private String value;
    
    public ExNVProperty(){}

    @XmlAttribute(name=AppExportS.NAME)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute(name=AppExportS.VALUE)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    public String whatIsDifferent(ExNVProperty obj){
        if(this.equals(obj) || !name.equals(obj.getName())) return AppExportS._;
        
        StringBuilder bud = new StringBuilder();
        
        bud.append(AppExportS.L3_1).append(AppExportS.PROPERTY);

        bud.append(AppExportS.L4).append(AppExportS.NAME).append(AppExportS.VE).append(name); 
        if(value != null){
                bud.append(AppExportS.L3_1).append(AppExportS.VALUE);
                bud.append(AppExportS.L4).append(AppExportS.SRC).append(AppExportS.VE).append(value);
                bud.append(AppExportS.L4).append(AppExportS.DEST).append(AppExportS.VE).append(obj.getValue());
        }else{
            if(obj.getValue()!= null){
                bud.append(AppExportS.L3_1).append(AppExportS.VALUE);
                bud.append(AppExportS.L3_1).append(AppExportS.DEST).append(AppExportS.VE).append(obj.getValue());
            }
        }
        
        return bud.toString();
    } 
    
    @Override
    public String toString(){
        StringBuilder bud = new StringBuilder();
        bud.append(AppExportS.L3_1).append(AppExportS.PROPERTY);
        bud.append(AppExportS.L4).append(AppExportS.NAME).append(AppExportS.VE).append(name);
        bud.append(AppExportS.L4).append(AppExportS.VALUE).append(AppExportS.VE).append(value);
        
        return bud.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 23 * hash + (this.value != null ? this.value.hashCode() : 0);
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
        final ExNVProperty other = (ExNVProperty) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.value == null) ? (other.value != null) : !this.value.equals(other.value)) {
            return false;
        }
        return true;
    }
    
    
}
