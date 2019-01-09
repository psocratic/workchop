package com.psocratic.workchop.examples.embeddedjetty;

class BasicConfiguration implements Configuration {
    private final Integer port;
    private final String path;

    BasicConfiguration(String path, Integer port) {
        this.path = path;
        this.port = port;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public int getPort() {
        return port;
    }
}
