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

package uk.co.hexeption.darkforge.gui.gui.theme.themes.darkforge;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.hexeption.darkforge.gui.gui.base.Component;
import uk.co.hexeption.darkforge.gui.gui.base.ComponentRenderer;
import uk.co.hexeption.darkforge.gui.gui.base.ComponentType;
import uk.co.hexeption.darkforge.gui.gui.elements.Button;
import uk.co.hexeption.darkforge.gui.gui.theme.Theme;
import uk.co.hexeption.darkforge.utils.render.GLUtils;

import java.awt.*;

/**
 * Created by Hexeption on 27/02/2017.
 */
@SideOnly(Side.CLIENT)
public class DarkForgeButton extends ComponentRenderer {

    public DarkForgeButton(Theme theme) {

        super(ComponentType.BUTTON, theme);
    }

    @Override
    public void drawComponent(Component component, int mouseX, int mouseY) {

        Button button = (Button) component;
        String text = button.getText();
        Color color = new Color(31, 31, 31, 20);

        if (GLUtils.isHovered(button.getxPos(), button.getyPos(), button.getDimension().width, button.getDimension().height, mouseX, mouseY)) {
            color = new Color(31, 31, 31, 120);
        }

        drawRect(button.getxPos(), button.getyPos(), button.getxPos() + button.getDimension().width - 1, button.getyPos() + button.getDimension().height, color);

        if (button.isEnabled()) {
            theme.fontRenderer.drawString(text, button.getxPos() + (button.getDimension().width / 2 - theme.fontRenderer.getStringWidth(text) / 2), button.getyPos() + (button.getDimension().height / 2 - theme.fontRenderer.getHeight() / 2), Color.green.hashCode());
        } else {
            theme.fontRenderer.drawString(text, button.getxPos() + (button.getDimension().width / 2 - theme.fontRenderer.getStringWidth(text) / 2), button.getyPos() + (button.getDimension().height / 2 - theme.fontRenderer.getHeight() / 2), Color.white.hashCode());
        }

    }
}
