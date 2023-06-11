package com.soufang.soufang.dto;

public class HouseIndexMessage {
    private Long id;
    private Operation operation;

    public static HouseIndexMessage update(Long id) {
        HouseIndexMessage m = new HouseIndexMessage();
        m.setId(id);
        m.setOperation(Operation.INDEX);
        return m;
    }

    public static HouseIndexMessage remove(Long id) {
        HouseIndexMessage m = new HouseIndexMessage();
        m.setId(id);
        m.setOperation(Operation.REMOVE);
        return m;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public enum Operation {
        INDEX,
        REMOVE
    }
}
