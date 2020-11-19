package tech.dttp.block.logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.util.ActionResult;
import tech.dttp.block.logger.save.sql.DbConn;
import tech.dttp.block.logger.util.InspectorUtils;
import tech.dttp.block.logger.util.PlayerUtils;
import tech.dttp.block.logger.command.Commands;

public class BlockLogger implements ModInitializer {
    public static DbConn db;
    @Override
    public void onInitialize() {

        // Register commands
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            Commands commands = new Commands();
            commands.register(dispatcher);
        });
        // Connect to database when server is started
        ServerLifecycleEvents.SERVER_STARTED.register((server) -> {
            db = new DbConn();
            db.connect(server);
            DbConn.server = server;
        });
        // Close DB connection when server is closed
        ServerLifecycleEvents.SERVER_STOPPED.register((server) -> {
            db.close();
        });

        //Setup inspect mode
        InspectModeHandler.init();

        // When completed
        System.out.println("[BL] Initialisation completed");
    }

}