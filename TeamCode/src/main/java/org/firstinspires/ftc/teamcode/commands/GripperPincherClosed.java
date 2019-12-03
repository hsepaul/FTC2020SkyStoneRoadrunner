package org.firstinspires.ftc.teamcode.commands;


/**
 * Created by HPaul on 10/22/2017.
 */

public class GripperPincherClosed extends BasicCommand {
    long timeOut;
    long wakeupTime;

    boolean gripperPincherClosed = false;


    public GripperPincherClosed(long timeOut){ this.timeOut = timeOut; }

    public void init() {
        wakeupTime = System.currentTimeMillis() + timeOut;
        //timeOut = System.currentTimeMillis() + 3000;
        gripperPincherClosed = false;
    }

    public void execute(){
        telemetry.addData("Mode:", "Gripper Pincher Closed");
        io.gripperPincherClosed();
        gripperPincherClosed = true;
    }

    public boolean isFinished(){
        return gripperPincherClosed || System.currentTimeMillis() >= wakeupTime;
    }
    public void stop() {
        io.setDrivePower(0,0, 0, 0);
        //io.forkLiftMotor.setPower(0);
    }

}

