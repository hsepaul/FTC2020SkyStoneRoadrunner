package org.firstinspires.ftc.teamcode.commands;


/**
 * Created by HPaul on 10/22/2017.
 */

public class GripperRotateParallel extends BasicCommand {
    long timeOut;

    boolean gripperParallel = false;


    public GripperRotateParallel(){

    }

    public void init() {
        timeOut = System.currentTimeMillis() + 3000;
        gripperParallel = false;
    }

    public void execute(){
        telemetry.addData("Mode:", "Gripper Parallel");
        io.gripperRotateParallel();
        gripperParallel = true;
    }

    public boolean isFinished(){
        return gripperParallel || System.currentTimeMillis() >= timeOut;
    }
    public void stop() {
        io.setDrivePower(0,0, 0, 0);
        //io.forkLiftMotor.setPower(0);
    }

}

