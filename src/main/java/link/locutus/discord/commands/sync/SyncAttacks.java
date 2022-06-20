package link.locutus.discord.commands.sync;

import link.locutus.discord.Locutus;
import link.locutus.discord.commands.manager.Command;
import link.locutus.discord.commands.manager.CommandCategory;
import link.locutus.discord.db.entities.DBNation;
import link.locutus.discord.user.Roles;
import link.locutus.discord.util.update.WarUpdateProcessor;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

public class SyncAttacks extends Command {
    public SyncAttacks() {
        super("syncattacks", CommandCategory.DEBUG, CommandCategory.LOCUTUS_ADMIN);
    }
    @Override
    public String help() {
        return "syncattacks";
    }

    @Override
    public String desc() {
        return "debug";
    }

    @Override
    public boolean checkPermission(Guild server, User user) {
        return super.checkPermission(server, user) && Roles.ADMIN.hasOnRoot(user);
    }

    @Override
    public synchronized String onCommand(MessageReceivedEvent event, List<String> args) throws Exception {
        WarUpdateProcessor.checkActiveConflicts();
        if (args.size() == 0) {
            Locutus.imp().getWarDb().updateAttacks();
            for (DBNation value : Locutus.imp().getNationDB().getNations().values()) {
                if (value.isBeige()) {
                    value.getBeigeTurns(true);
                }
            }
        } else if (args.size() == 1) {
            Locutus.imp().getWarDb().updateAttacks(Integer.parseInt(args.get(0)), false);
        } else {
            return usage();
        }

        return "Done!";
    }
}