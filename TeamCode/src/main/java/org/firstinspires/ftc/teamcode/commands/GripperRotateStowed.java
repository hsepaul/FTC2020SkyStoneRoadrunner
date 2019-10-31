package org.firstinspires.ftc.teamcode.commands;


/**
 * Created by HPaul on 10/22/2017.
 */

public class GripperRotateStowed extends BasicCommand {
    long timeOut;

    boolean gripperRotateStowed = false;


    public GripperRotateStowed(){

    }

    public void init() {
        timeOut = System.currentTimeMillis() + 3000;
        gripperRotateStowed = false;
    }

    public void execute(){
        telemetry.addData("Mode:", "Gripper Pincher Closedl");
        io.gripperRotateStowed();
        gripperRotateStowed = true;
    }

    public boolean isFinished(){
        return gripperRotateStowed || System.currentTimeMillis() >= timeOut;
    }
    public void stop() {
        io.setDrivePower(0,0, 0, 0);
        //io.forkLiftMotor.setPower(0);
    }

}

