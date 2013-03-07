package com.github.ipetruk.dolphin_orchestra.server;

import com.github.ipetruk.dolphin_orchestra.server.boilerplate.GuiceIntegration;
import com.github.ipetruk.dolphin_orchestra.server.core.MainModule;
import com.google.inject.*;
import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;

import java.security.NoSuchAlgorithmException;

public class Runner {

    public static void main( String[] args ) throws NoSuchAlgorithmException
    {
        Injector injector = Guice.createInjector(new MainModule());

        ResteasyDeployment deployment = new ResteasyDeployment();
        GuiceIntegration.registerGuiceInjection(injector, deployment);

        final NettyJaxrsServer server = new NettyJaxrsServer();
        server.setDeployment(deployment);

        int port = 3000;
        server.setPort(port);
        server.start();
        System.out.println("Server listening on port "+port);
    }

}
