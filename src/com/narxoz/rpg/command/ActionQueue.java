package com.narxoz.rpg.command;

import java.util.ArrayList;
import java.util.List;

public class ActionQueue {
    private final List<ActionCommand> queue = new ArrayList<>();

    public void enqueue(ActionCommand cmd) {
        queue.add(cmd);
    }

    public void undoLast() {
        if (!queue.isEmpty()) {
            queue.remove(queue.size() - 1);
        }
    }

    public void executeAll() {
        if (queue.isEmpty()) return;
        for (ActionCommand cmd : queue) {
            cmd.execute();
        }
        queue.clear();
    }

    public List<String> getCommandDescriptions() {
        List<String> snapshot = new ArrayList<>();
        for (ActionCommand cmd : queue) {
            snapshot.add(cmd.getDescription());
        }
        return snapshot;
    }
}
