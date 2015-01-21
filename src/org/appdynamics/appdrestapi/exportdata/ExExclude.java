/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.appdynamics.appdrestapi.exportdata;

import org.appdynamics.appdrestapi.resources.AppExportS;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author gilbert.solorzano
 * 
 * 
                            <exclude name="CometD Servlet">
                                <servlet-rule>
                                    <enabled>true</enabled>
                                    <priority>0</priority>
                                    <class-name filter-type="EQUALS" filter-value="org.cometd.server.CometdServlet"/>
                                </servlet-rule>
                            </exclude>
                            * 
                            * <exclude name="ASP.NET WCF Activation Handler">
                                <asp-dotnet-rule>
                                    <enabled>true</enabled>
                                    <priority>0</priority>
                                    <class-name filter-type="EQUALS" filter-value="System.ServiceModel.Activation.HttpHandler"/>
                                </asp-dotnet-rule>
                            </exclude>
 * 
 */

@XmlSeeAlso({ExServletRule.class,ExClassName.class,ExAspDotNetRule.class})
public class ExExclude {
    private String name;
    private ExServletRule servletRule;
    private ExAspDotNetRule aspDotNetRule;
    
    public ExExclude(){}

    @XmlAttribute(name=AppExportS.NAME)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name=AppExportS.SERVLET_RULE)
    public ExServletRule getServletRule() {
        return servletRule;
    }

    public void setServletRule(ExServletRule servletRule) {
        this.servletRule = servletRule;
    }

    @XmlElement(name=AppExportS.ASP_DOTNET_RULE)
    public ExAspDotNetRule getAspDotNetRule() {
        return aspDotNetRule;
    }

    public void setAspDotNetRule(ExAspDotNetRule aspDotNetRule) {
        this.aspDotNetRule = aspDotNetRule;
    }
    
    public String whatIsDifferent(ExExclude obj){
        if(this.equals(obj)) return AppExportS._;
        
        StringBuilder bud = new StringBuilder();
        bud.append(AppExportS.L3).append(AppExportS.EXCLUDE);
        bud.append(AppExportS.L3_1).append(AppExportS.NAME).append(AppExportS.VE).append(name);
        
        if(servletRule != null){ bud.append(servletRule.whatIsDifferent(obj.getServletRule()));}
        else{
            if(obj.getServletRule() != null){
                bud.append(AppExportS.L4).append(AppExportS.DEST).append(obj.getServletRule());
            }
        }
        if(aspDotNetRule != null){ bud.append(aspDotNetRule.whatIsDifferent(obj.getAspDotNetRule()));}
        else{
            if(obj.getAspDotNetRule() != null) bud.append(AppExportS.L4).append(AppExportS.DEST).append(obj.getAspDotNetRule());
        }
        
        return bud.toString();
    }
    
    @Override
    public String toString(){
        StringBuilder bud = new StringBuilder();
        bud.append(AppExportS.L3).append(AppExportS.EXCLUDE);
        bud.append(AppExportS.L4).append(AppExportS.NAME).append(AppExportS.VE).append(name);
        if(servletRule != null) bud.append(servletRule);
        if(aspDotNetRule != null) bud.append(aspDotNetRule);
        return bud.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 61 * hash + (this.servletRule != null ? this.servletRule.hashCode() : 0);
        hash = 61 * hash + (this.aspDotNetRule != null ? this.aspDotNetRule.hashCode() : 0);
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
        final ExExclude other = (ExExclude) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if (this.servletRule != other.servletRule && (this.servletRule == null || !this.servletRule.equals(other.servletRule))) {
            return false;
        }
        if (this.aspDotNetRule != other.aspDotNetRule && (this.aspDotNetRule == null || !this.aspDotNetRule.equals(other.aspDotNetRule))) {
            return false;
        }
        return true;
    }
    
    
    
}
