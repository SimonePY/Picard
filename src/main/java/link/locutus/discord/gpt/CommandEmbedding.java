package link.locutus.discord.gpt;

import link.locutus.discord.commands.manager.v2.binding.ValueStore;
import link.locutus.discord.commands.manager.v2.command.ParametricCallable;
import link.locutus.discord.commands.manager.v2.impl.pw.CommandManager2;

public class CommandEmbedding extends PWEmbedding<ParametricCallable> {

    public CommandEmbedding(ParametricCallable obj) {
        super(EmbeddingType.Command, obj.getFullPath(), obj, false);
    }

    @Override
    public String apply(String query, GptHandler handler) {
        return null;
    }

    @Override
    public String getContent() {
        return getObj().simpleDesc();
    }

    @Override
    public boolean hasPermission(ValueStore store, CommandManager2 manager) {
//        return getObj().hasPermission(store, manager.getPermisser());
        return true;
    }
}
