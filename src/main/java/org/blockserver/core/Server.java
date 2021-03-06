/*
 * This file is part of BlockServer.
 *
 * BlockServer is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * BlockServer is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with BlockServer.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.blockserver.core;

import lombok.Getter;
import lombok.Setter;
import org.blockserver.core.event.EventManager;
import org.blockserver.core.events.modules.ModuleDisableEvent;
import org.blockserver.core.events.modules.ModuleEnableEvent;
import org.blockserver.core.module.EnableableImplementation;
import org.blockserver.core.module.ModuleLoader;
import org.blockserver.core.module.ServerModule;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents the core server implementation.
 *
 * @author BlockServer Team
 */
public class Server implements EnableableImplementation {
    //TODO Add YAML utils somewhere!!
    //Modules
    private final Map<Class<? extends ServerModule>, ServerModule> modules = new HashMap<>();
    @Getter @Setter private EventManager eventManager = new EventManager();

    public Server(ModuleLoader... moduleLoaders) {
        for (ModuleLoader moduleLoader : moduleLoaders) {
            moduleLoader.setModules(modules, this);
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends ServerModule> T getModule(Class<T> moduleClass) {
        return (T) modules.get(moduleClass);
    }

    public void addModule(ServerModule module) {
        modules.put(module.getClass(), module);
    }

    @Override
    public void enable() {
        modules.values().forEach((module) -> {
            if (module.isEnabled())
                return;
            eventManager.fire(new ModuleEnableEvent(this, module), event -> {
                if (!event.isCancelled())
                    module.enable();
            });
        });
        EnableableImplementation.super.enable();
    }

    @Override
    public void disable() {
        modules.values().forEach((module) -> {
            if (!module.isEnabled())
                return;
            eventManager.fire(new ModuleDisableEvent(this, module), event -> {
                if (!event.isCancelled())
                    module.disable();
            });
        });
        EnableableImplementation.super.disable();
    }

    public Map<Class<? extends ServerModule>, ServerModule> getModules() {
        return Collections.unmodifiableMap(modules);
    }
}