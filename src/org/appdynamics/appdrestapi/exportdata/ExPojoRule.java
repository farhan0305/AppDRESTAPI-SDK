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
 * 
 * 
                        <pojo-rule>
                            <enabled>false</enabled>
                            <priority>0</priority>
                            <display-name>Cron4J</display-name>
                            <background>true</background>
                            <match-class type="inherits-from-class">
                                <name filter-type="EQUALS" filter-value="it.sauronsoftware.cron4j.Task"/>
                            </match-class>
                            <split-config type="4"/>
                            <match-method>
                                <name filter-type="EQUALS" filter-value="execute"/>
                            </match-method>
                        </pojo-rule>
 * 4
 */
@XmlSeeAlso({ExMatchClass.class,ExSplitConfig.class,ExMatchMethod.class,ExMatchClassName.class})
public class ExPojoRule {
    private boolean enabled;
    private int priority;
    private String displayName;
    private boolean background;
    private ExMatchClass matchClass;
    private ExSplitConfig splitConfig;
    private ExMatchMethod matchMethod;
    
    public ExPojoRule(){}
    

    @XmlElement(name=AppExportS.ENABLED)
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @XmlElement(name=AppExportS.PRIORITY)
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @XmlElement(name=AppExportS.DISPLAY_NAME)
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @XmlElement(name=AppExportS.BACKGROUND)
    public boolean isBackground() {
        return background;
    }

    public void setBackground(boolean background) {
        this.background = background;
    }

    @XmlElement(name=AppExportS.MATCH_CLASS)
    public ExMatchClass getMatchClass() {
        return matchClass;
    }

    public void setMatchClass(ExMatchClass matchClass) {
        this.matchClass = matchClass;
    }

    @XmlElement(name=AppExportS.SPLIT_CONFIG)
    public ExSplitConfig getSplitConfig() {
        return splitConfig;
    }

    public void setSplitConfig(ExSplitConfig splitConfig) {
        this.splitConfig = splitConfig;
    }

    @XmlElement(name=AppExportS.MATCH_METHOD)
    public ExMatchMethod getMatchMethod() {
        return matchMethod;
    }

    public void setMatchMethod(ExMatchMethod matchMethod) {
        this.matchMethod = matchMethod;
    }
    
    public String whatIsDifferent(ExPojoRule obj){
        if(this.equals(obj) || !displayName.equals(obj.getDisplayName())) return AppExportS._;
        
        StringBuilder bud = new StringBuilder();
        bud.append(AppExportS.L2_1).append(AppExportS.POJO_RULE);
        bud.append(AppExportS.L3).append(AppExportS.DISPLAY_NAME).append(AppExportS.VE).append(displayName);
        
        if(enabled!=obj.isEnabled()){
                bud.append(AppExportS.L3).append(AppExportS.ENABLED);
                bud.append(AppExportS.L3_1).append(AppExportS.SRC).append(AppExportS.VE).append(enabled);
                bud.append(AppExportS.L3_1).append(AppExportS.DEST).append(AppExportS.VE).append(obj.isEnabled());
        }
        
        if(priority != obj.getPriority()){
                bud.append(AppExportS.L3).append(AppExportS.PRIORITY);
                bud.append(AppExportS.L3_1).append(AppExportS.SRC).append(AppExportS.VE).append(priority);
                bud.append(AppExportS.L3_1).append(AppExportS.DEST).append(AppExportS.VE).append(obj.getPriority());
        }
        
        if(background != obj.isBackground()){
                bud.append(AppExportS.L3).append(AppExportS.BACKGROUND);
                bud.append(AppExportS.L3_1).append(AppExportS.SRC).append(AppExportS.VE).append(background);
                bud.append(AppExportS.L3_1).append(AppExportS.DEST).append(AppExportS.VE).append(obj.isBackground());
        }
        
        bud.append(matchClass.whatIsDifferent(obj.getMatchClass()));
        bud.append(splitConfig.whatIsDifferent(obj.getSplitConfig()));
        bud.append(matchMethod.whatIsDifferent(obj.getMatchMethod()));
        
        return bud.toString();
    }
    
    @Override
    public String toString(){
        StringBuilder bud = new StringBuilder();
        bud.append(AppExportS.L2_1).append(AppExportS.POJO_RULE);
        bud.append(AppExportS.L3).append(AppExportS.ENABLED).append(AppExportS.VE).append(enabled);
        bud.append(AppExportS.L3).append(AppExportS.PRIORITY).append(AppExportS.VE).append(priority);
        bud.append(AppExportS.L3).append(AppExportS.DISPLAY_NAME).append(AppExportS.VE).append(displayName);
        bud.append(AppExportS.L3).append(AppExportS.BACKGROUND).append(AppExportS.VE).append(background);
        bud.append(AppExportS.L3).append(AppExportS.MATCH_CLASS).append(matchClass);
        bud.append(AppExportS.L3).append(AppExportS.SPLIT_CONFIG).append(splitConfig);
        bud.append(AppExportS.L3).append(AppExportS.MATCH_METHOD).append(matchMethod);
        
        return bud.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.enabled ? 1 : 0);
        hash = 89 * hash + this.priority;
        hash = 89 * hash + (this.displayName != null ? this.displayName.hashCode() : 0);
        hash = 89 * hash + (this.background ? 1 : 0);
        hash = 89 * hash + (this.matchClass != null ? this.matchClass.hashCode() : 0);
        hash = 89 * hash + (this.splitConfig != null ? this.splitConfig.hashCode() : 0);
        hash = 89 * hash + (this.matchMethod != null ? this.matchMethod.hashCode() : 0);
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
        final ExPojoRule other = (ExPojoRule) obj;
        if (this.enabled != other.enabled) {
            return false;
        }
        if (this.priority != other.priority) {
            return false;
        }
        if ((this.displayName == null) ? (other.displayName != null) : !this.displayName.equals(other.displayName)) {
            return false;
        }
        if (this.background != other.background) {
            return false;
        }
        if (this.matchClass != other.matchClass && (this.matchClass == null || !this.matchClass.equals(other.matchClass))) {
            return false;
        }
        if (this.splitConfig != other.splitConfig && (this.splitConfig == null || !this.splitConfig.equals(other.splitConfig))) {
            return false;
        }
        if (this.matchMethod != other.matchMethod && (this.matchMethod == null || !this.matchMethod.equals(other.matchMethod))) {
            return false;
        }
        return true;
    }
    
    
    
}
