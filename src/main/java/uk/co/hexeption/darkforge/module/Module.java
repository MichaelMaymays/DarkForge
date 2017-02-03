package uk.co.hexeption.darkforge.module;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Hexeption on 15/01/2017.
 */
public class Module {

    private String name = getClass().getAnnotation(ModInfo.class).name();

    private String description = getClass().getAnnotation(ModInfo.class).description();

    private Category category = getClass().getAnnotation(ModInfo.class).category();

    private int bind = getClass().getAnnotation(ModInfo.class).bind();

    private boolean state;

    public void onWorldTick() {

    }

    public void onWorldRender() {

    }

    public void onGuiRender() {

    }

    public void initializeLater() {

    }

    public enum Category {
        COMBAT(0x3ABDFF), MOVEMENET(0xF8FF1F), RENDER(0x48FF1F), WORLD(0xCF1FFF), MISC(0xFFC100), PLAYER(0x00FFEC), GUI(0);

        public int color;

        Category(int color) {

            this.color = color;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface ModInfo {

        String name();

        String description();

        Category category();

        int bind();
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public Category getCategory() {

        return category;
    }

    public void setCategory(Category category) {

        this.category = category;
    }

    public int getBind() {

        return bind;
    }

    public void setBind(int bind) {

        this.bind = bind;
    }

    public boolean getState() {

        return state;
    }

    public void setState(boolean state) {

        onToggle();
        if (state) {
            onEnable();
            this.state = true;
            //TODO: Event register
        } else {
            onDisable();
            this.state = false;
            //TODO: Event unregister
        }

        //TODO: File save

    }

    public void onEnable() {

    }

    public void onDisable() {

    }

    public void onToggle() {

    }

    public void toggle() {

        setState(!this.getState());
    }

    public final boolean isCategory(Category category) {

        if (category == this.category)
            return true;
        return false;
    }

    public String getKeyName() {

        return getBind() == -1 ? "-1" : Keyboard.getKeyName(getBind());
    }

    @SideOnly(Side.CLIENT)
    protected Minecraft getMinecraft() {

        return Minecraft.getMinecraft();
    }

    @SideOnly(Side.CLIENT)
    protected EntityPlayerSP getPlayer() {

        return getMinecraft().player;
    }

    @SideOnly(Side.CLIENT)
    protected WorldClient getWorld() {

        return getMinecraft().world;
    }

    @SideOnly(Side.CLIENT)
    protected GameSettings getGameSettings() {

        return getMinecraft().gameSettings;
    }

    @SideOnly(Side.CLIENT)
    protected RenderGlobal getRenderGlobal() {

        return getMinecraft().renderGlobal;
    }

    @SideOnly(Side.CLIENT)
    protected EntityRenderer getEntityRenderer() {

        return getMinecraft().entityRenderer;
    }

    @SideOnly(Side.CLIENT)
    protected FontRenderer getFontRenderer() {

        return getMinecraft().fontRendererObj;
    }
}