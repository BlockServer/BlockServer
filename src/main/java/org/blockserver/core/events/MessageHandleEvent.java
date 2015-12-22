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
package org.blockserver.core.events;

import lombok.Getter;
import lombok.Setter;
import org.blockserver.core.event.CancellableImplementation;
import org.blockserver.core.message.Message;

/**
 * Written by Exerosis!
 */
public class MessageHandleEvent<T extends Message> implements CancellableImplementation {
    @Getter @Setter private Message message;

    public MessageHandleEvent(Message message) {
        this.message = message;
    }
}