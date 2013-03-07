package com.github.ipetruk.dolphin_orchestra.server.boilerplate;

import com.google.inject.Binding;
import com.google.inject.Injector;
import com.sun.deploy.security.DeployAuthenticator;
import org.jboss.resteasy.plugins.guice.GuiceResourceFactory;
import org.jboss.resteasy.spi.ResourceFactory;
import org.jboss.resteasy.spi.ResteasyDeployment;
import org.jboss.resteasy.util.GetRestful;

import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GuiceIntegration {
    private static Logger logger = Logger.getLogger(GuiceIntegration.class.getName());

    public static void registerGuiceInjection(Injector injector, ResteasyDeployment deployment){
        for (final Binding<?> binding : injector.getBindings().values()) {
            final Type type = binding.getKey().getTypeLiteral().getType();
            if (type instanceof Class) {
                final Class<?> beanClass = (Class) type;
                if (GetRestful.isRootResource(beanClass)) {
                    final ResourceFactory resourceFactory = new GuiceResourceFactory(binding.getProvider(), beanClass);
                    logger.log(Level.INFO,"registering factory for {0}", beanClass.getName());
                    deployment.getResourceFactories().add(resourceFactory);
                }
                if (beanClass.isAnnotationPresent(javax.ws.rs.ext.Provider.class)) {
                    logger.log(Level.INFO,"registering provider instance for {0}", beanClass.getName());
                    deployment.getProviderFactory().registerProviderInstance(binding.getProvider().get());
                }
            }
        }

    }
}
