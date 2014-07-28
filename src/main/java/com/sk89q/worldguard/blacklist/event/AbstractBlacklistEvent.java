/*
 * WorldGuard, a suite of tools for Minecraft
 * Copyright (C) sk89q <http://www.sk89q.com>
 * Copyright (C) WorldGuard team and contributors
 *
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.sk89q.worldguard.blacklist.event;

import com.sk89q.worldedit.Vector;
import com.sk89q.worldguard.LocalPlayer;

import javax.annotation.Nullable;

import static com.google.common.base.Preconditions.checkNotNull;

abstract class AbstractBlacklistEvent implements BlacklistEvent {

    @Nullable
    private LocalPlayer player;
    private Vector position;
    private int type;
    
    /**
     * Construct the object.
     * 
     * @param player The player associated with this event
     * @param position The position the event occurred at
     * @param type The type of item used
     */
    AbstractBlacklistEvent(@Nullable LocalPlayer player, Vector position, int type) {
        checkNotNull(position);
        this.player = player;
        this.position = position;
        this.type = type;
    }

    @Nullable
    @Override
    public LocalPlayer getPlayer() {
        return player;
    }

    @Override
    public String getCauseName() {
        return player != null ? player.getName() : position.toString();
    }

    @Override
    public Vector getPosition() {
        return position;
    }
    
    @Override
    public int getType() {
        return type;
    }

    protected String getPlayerName() {
        return player == null ? "(unknown)" : player.getName();
    }

}