/*******************************************************************************
 *     DarkForge a Forge Hacked Client
 *     Copyright (C) 2017  Hexeption (Keir Davis)
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/

package uk.co.hexeption.darkforge.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.stats.StatisticsManager;
import net.minecraft.world.World;
import uk.co.hexeption.darkforge.DarkForge;

/**
 * Created by Hexeption on 13/03/2017.
 */
public class DarkForgeEntityPlayer extends EntityPlayerSP {

    public DarkForgeEntityPlayer(Minecraft mcIn, World worldIn, NetHandlerPlayClient netHandler, StatisticsManager statFile) {

        super(mcIn, worldIn, netHandler, statFile);
    }

    @Override
    public void sendChatMessage(String message) {

        if (message.startsWith(DarkForge.INSTANCE.commandPrefix)) {
            DarkForge.INSTANCE.commandManager.executeCommand(message.substring(DarkForge.INSTANCE.commandPrefix.length()));
        } else {
            super.sendChatMessage(message);
        }
    }
}
