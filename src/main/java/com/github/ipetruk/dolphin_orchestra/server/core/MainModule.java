package com.github.ipetruk.dolphin_orchestra.server.core;

import com.github.ipetruk.dolphin_orchestra.server.data.BerkeleyDBModule;
import com.github.ipetruk.dolphin_orchestra.server.rest.RestModule;
import com.google.inject.AbstractModule;

public class MainModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new BerkeleyDBModule());
        install(new RestModule());
    }
}
