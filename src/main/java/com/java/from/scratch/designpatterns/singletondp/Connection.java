package com.java.from.scratch.designpatterns.singletondp;

// Simple Connection class for demonstration
class Connection {
    private boolean inUse = false;

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public void executeQuery(String query) {
        System.out.println("Executing query: " + query);
    }
}