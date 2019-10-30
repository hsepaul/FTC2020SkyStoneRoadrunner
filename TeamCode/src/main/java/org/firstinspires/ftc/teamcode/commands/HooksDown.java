package org.firstinspires.ftc.teamcode.commands;


/**
 * Created by HPaul on 10/22/2017.
 */

public class HooksDown extends BasicCommand {
    long timeOut;

    boolean hooksDown = false;


    public HooksDown(){

    }

    public void init() {
        timeOut = System.currentTimeMillis() + 3000;
        hooksDown = false;
    }

    public void execute(){
        telemetry.addData("Mode:", "Hooks Down");
        io.rightHookDown();
        io.leftHookDown();
        hooksDown = true;
    }

    public boolean isFinished(){
        return hooksDown || System.currentTimeMillis() >= timeOut;
    }
    public void stop() {
        io.setDrivePower(0,0, 0, 0);
        //io.forkLiftMotor.setPower(0);
    }

}

