package net.revilo.ccwaterframes;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;


import dan200.computercraft.api.ComputerCraftAPI;
import net.revilo.ccwaterframes.computercraft.implementation.peripherals.*;

@Mod(CCWaterframes.MODID)
public class CCWaterframes {
    public static final String MODID = "ccwaterframes";
    private static final Logger LOGGER = LogUtils.getLogger();

    public CCWaterframes(IEventBus modEventBus) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Hello from CC: Waterframes!");

        ComputerCraftAPI.registerGenericSource(new BigTelevisionPeripheral());
        ComputerCraftAPI.registerGenericSource(new BoxTelevisionPeripheral());
        ComputerCraftAPI.registerGenericSource(new FramePeripheral());
        ComputerCraftAPI.registerGenericSource(new ProjectorPeripheral());
        ComputerCraftAPI.registerGenericSource(new TelevisionPeripheral());
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Server is starting!");
    }


}
