package org.firstinspires.ftc.teamcode.commands;


/**
 * Created by HPaul on 10/22/2017.
 */

public class GripperPincherOpen extends BasicCommand {
    long timeOut;
    long wakeupTime;

    boolean gripperPincherOpen = false;


    public GripperPincherOpen(long timeOut){ this.timeOut = timeOut; }

    public void init() {
        wakeupTime = System.currentTimeMillis() + timeOut;
        //timeOut = System.currentTimeMillis() + 3000;
        gripperPincherOpen = false;
    }

    public void execute(){
        telemetry.addData("Mode:", "Gripper Pincher Open");
        io.gripperPincherOpen();
        gripperPincherOpen = true;
    }

    public boolean isFinished(){
        return gripperPincherOpen || System.currentTimeMillis() >= wakeupTime;
    }
    public void stop() {
        io.setDrivePower(0,0, 0, 0);
        //io.forkLiftMotor.setPower(0);
    }

}

