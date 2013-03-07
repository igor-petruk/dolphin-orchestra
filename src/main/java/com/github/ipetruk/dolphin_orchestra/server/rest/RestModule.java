package com.github.ipetruk.dolphin_orchestra.server.rest;

import com.google.inject.AbstractModule;

public class RestModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(RestService.class);
    }
}
