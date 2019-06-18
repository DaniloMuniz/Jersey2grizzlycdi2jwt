/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.danilowrm.Jersey2grizzly.conf;

import br.com.danilowrm.Jersey2grizzly.service.ProductService;
import br.com.danilowrm.Jersey2grizzly.service.ProductServiceImpl;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
//import org.glassfish.hk2.utilities.binding.AbstractBinder;
//import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.jboss.weld.environment.se.Weld;

/**
 *
 * @author washington-muniz
 */
public class WebServiceBinderCDI {/*extends AbstractBinder {

    @Override
    protected void configure() {
        BeanManager bm = getBeanManager();
        bind(getBean(bm, ProductServiceImpl.class)).to(ProductService.class);
    }

    private BeanManager getBeanManager() {
        return new Weld().initialize().getBeanManager();
    }

    private <T> T getBean(BeanManager bm, Class<T> clazz) {
        Bean<T> bean = (Bean<T>) bm.getBeans(clazz).iterator().next();
        CreationalContext<T> ctx = bm.createCreationalContext(bean);
        return (T) bm.getReference(bean, clazz, ctx);
    }
*/
}
