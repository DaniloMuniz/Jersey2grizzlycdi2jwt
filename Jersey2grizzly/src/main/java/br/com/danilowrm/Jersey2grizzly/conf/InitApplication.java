/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.conf;

import br.com.danilowrm.Jersey2grizzly.resource.ProductResourceImpl;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author washington-muniz
 */
@Deprecated
@ApplicationPath("/*")
public class InitApplication extends Application {

    private Set<Class<?>> resouces;

    @Override
    public Set<Class<?>> getClasses() {
        this.resouces.add(ProductResourceImpl.class);
        return this.resouces;
    }

    public InitApplication() {
        super();
        this.resouces = new HashSet<>();
    }

}
