package com.tradedoubler.billing.platform.flowcontroller;

/** Defines configuration settings for the flow controller. */
public class FlowControllerSettings {

    // All values are assumed to be in ms.
    public long FLOW_CONTROLLER_DISTURBANCE_1 = 60000;
    public long FLOW_CONTROLLER_DISTURBANCE_2 = 600000;
    public long FLOW_CONTROLLER_DISTURBANCE_3 = 60000 * 60;
    public long FLOW_CONTROLLER_BUG_DISTURBANCE = 60000 * 60;

    public FlowControllerSettings() {
    }

    public void setFLOW_CONTROLLER_DISTURBANCE_1(long FLOW_CONTROLLER_DISTURBANCE_1) {
        this.FLOW_CONTROLLER_DISTURBANCE_1 = FLOW_CONTROLLER_DISTURBANCE_1;
    }

    public void setFLOW_CONTROLLER_DISTURBANCE_2(long FLOW_CONTROLLER_DISTURBANCE_2) {
        this.FLOW_CONTROLLER_DISTURBANCE_2 = FLOW_CONTROLLER_DISTURBANCE_2;
    }

    public void setFLOW_CONTROLLER_DISTURBANCE_3(long FLOW_CONTROLLER_DISTURBANCE_3) {
        this.FLOW_CONTROLLER_DISTURBANCE_3 = FLOW_CONTROLLER_DISTURBANCE_3;
    }

    public void setFLOW_CONTROLLER_BUG_DISTURBANCE(long FLOW_CONTROLLER_BUG_DISTURBANCE) {
        this.FLOW_CONTROLLER_BUG_DISTURBANCE = FLOW_CONTROLLER_BUG_DISTURBANCE;
    }
}
