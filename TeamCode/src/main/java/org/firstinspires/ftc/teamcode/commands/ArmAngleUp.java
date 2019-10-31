package org.firstinspires.ftc.teamcode.commands;


/**
 * Created by HPaul on 10/22/2017.
 */

public class ArmAngleUp extends BasicCommand {
    long timeOut;


    public ArmAngleUp(){

    }

    public void init() {
        timeOut = System.currentTimeMillis() + 5000;
        io.resetDriveEncoders();
    }

    public void execute(){
        telemetry.addData("Mode:", "Arm Angle Up");
        io.armAngleMotor.setPower(-.6);
    }

    public boolean isFinished(){
        return io.getArmAngleEncoder() <= -1500 || System.currentTimeMillis() >= timeOut;
    }
    public void stop() {
        io.setDrivePower(0,0, 0,0);
        io.armAngleMotor.setPower(0);
    }

}

