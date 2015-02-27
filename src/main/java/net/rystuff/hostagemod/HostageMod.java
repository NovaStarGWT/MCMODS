package net.rystuff.hostagemod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.rystuff.hostagemod.event.EventGag;
import net.rystuff.hostagemod.event.EventHandcuff;
import net.rystuff.hostagemod.items.ItemGag;
import net.rystuff.hostagemod.items.ItemHandcuff;
import net.rystuff.hostagemod.proxy.ServerProxy;

@Mod(modid = "hostagemod", name = "Hostage Mod", version = "1.0")
public class HostageMod
{
    @SidedProxy(clientSide = "net.rystuff.hostagemod.proxy.ClientProxy", serverSide = "net.rystuff.hostagemod.proxy.ServerProxy")
    public static ServerProxy proxy;
    @Mod.Instance("hostagemod")
    public static HostageMod instance;
    
    public static Item gag = new ItemGag();
    public static Item handcuffs = new ItemHandcuff();
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        // MinecraftForge.EVENT_BUS.register(new EventHandler());
        MinecraftForge.EVENT_BUS.register(new EventGag());
        MinecraftForge.EVENT_BUS.register(new EventHandcuff());
        GameRegistry.registerItem(gag, "Gag");
        GameRegistry.registerItem(handcuffs, "Handcuffs");
    }
}
