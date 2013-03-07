package com.github.ipetruk.dolphin_orchestra.server.data;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.sleepycat.je.Database;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;

import javax.inject.Singleton;
import java.io.File;

public class BerkeleyDBModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(DatabaseFactory.class).in(Singleton.class);
    }

    @Provides
    @Singleton
    public Environment environment(){
        EnvironmentConfig envConfig = new EnvironmentConfig();
        envConfig.setAllowCreate(true);
        return new Environment(new File("./dbEnv"), envConfig);
    }
}
