package pl.altkom.asc.lab.micronaut.poc.command.bus;

import pl.altkom.asc.lab.micronaut.poc.command.bus.api.Command;
import pl.altkom.asc.lab.micronaut.poc.command.bus.api.Query;

public class MicronautCommandBus implements CommandBus {

    private final Registry registry;

    public MicronautCommandBus(Registry registry) {
        this.registry = registry;
    }

    @Override
    public <R, C extends Command<R>> R executeCommand(C command) {
        CommandHandler<R, C> commandHandler = (CommandHandler<R, C>) registry.getCmd(command.getClass());
        return commandHandler.handle(command);
    }

    @Override
    public <R, Q extends Query<R>> R executeQuery(Q query) {
        QueryHandler<R, Q> commandHandler = (QueryHandler<R, Q>) registry.getQuery(query.getClass());
        return commandHandler.handle(query);
    }
}
