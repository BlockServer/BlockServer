package org.blockserver.core.modules.network;

import lombok.Getter;
import org.blockserver.core.Server;
import org.blockserver.core.module.Module;

public class Provider extends Module {
    @Getter private final NetworkHandler handler;

    public Provider(NetworkHandler handler, Server server) {
        super(server);
        this.handler = handler;
    }

    public void provide(RawPacket packet) {
        handler.provide(packet);
    }
}