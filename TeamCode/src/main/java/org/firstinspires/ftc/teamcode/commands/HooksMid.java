package org.firstinspires.ftc.teamcode.commands;


/**
 * Created by HPaul on 10/22/2017.
 */

public class HooksMid extends BasicCommand {
    long timeOut;

    boolean hooksMid = false;


    public HooksMid(){

    }

    public void init() {
        timeOut = System.currentTimeMillis() + 3000;
        hooksMid = false;
    }

    public void execute(){
        telemetry.addData("Mode:", "Hooks Mid");
        io.rightHookMid();
        io.leftHookMid();
        hooksMid = true;
    }

    public boolean isFinished(){
        return hooksMid || System.currentTimeMillis() >= timeOut;
    }
    public void stop() {
        io.setDrivePower(0,0, 0, 0);
        //io.forkLiftMotor.setPower(0);
    }

}

