package org.firstinspires.ftc.teamcode.commands;


/**
 * Created by HPaul on 10/22/2017.
 */

public class GripperPincherOpen extends BasicCommand {
    long timeOut;

    boolean gripperPincherOpen = false;


    public GripperPincherOpen(){

    }

    public void init() {
        timeOut = System.currentTimeMillis() + 3000;
        gripperPincherOpen = false;
    }

    public void execute(){
        telemetry.addData("Mode:", "Gripper Pincher Closedl");
        io.gripperPincherOpen();
        gripperPincherOpen = true;
    }

    public boolean isFinished(){
        return gripperPincherOpen || System.currentTimeMillis() >= timeOut;
    }
    public void stop() {
        io.setDrivePower(0,0, 0, 0);
        //io.forkLiftMotor.setPower(0);
    }

}

