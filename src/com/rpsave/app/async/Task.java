package com.rpsave.app.async;

import com.rpsave.app.utils.Disposable;

import java.util.Collection;
import java.util.LinkedList;

/**
 */
public abstract class Task<T extends Task<?>> implements Runnable, Disposable {
    private Collection<Throwable> errors;

    protected Task() {
        this.errors = new LinkedList<Throwable>();
    }

    public void initialize(T next) {
        errors.clear();
    }

    protected void addError(Throwable t) {
        errors.add(t);
    }

    public Collection<Throwable> getErrors() { return errors; }

    public void dispose() {
        errors.clear();
    }

    public final void run() {
        try {
            execute();
        } catch (Throwable t) {
            addError(t);
        }
    }

    abstract void execute();
}
