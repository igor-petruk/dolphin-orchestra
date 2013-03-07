package com.github.ipetruk.dolphin_orchestra.server.data;

import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.Environment;

import javax.inject.Inject;

public class DatabaseFactory {
    private Environment environment;

    @Inject
    public DatabaseFactory(Environment environment) {
        this.environment = environment;
    }

    public Database provideDatabase(String name){
        DatabaseConfig databaseConfig = new DatabaseConfig();
        databaseConfig.setAllowCreate(true);
        return environment.openDatabase(null, name, databaseConfig);
    }
}
