package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.utilities.PID;

/**
 * Created by David Austin on 10/27/2016.
 */

public class ArmAngleMovement extends BasicCommand {
    public double targetPosition;
    double armAngleSpeed;
    public PID armAnglePID;
    public static final int INCREASINGDIRECTION = 0;
    public static final int DECREASINGDIRECTION = 1;
    int test;
    long endTime;
    boolean coast = false;
    public ArmAngleMovement(double targetPosition, int test, double spd){
        //headingPID = new PID(0.05,0,0);
        //headingPID = new PID(0.02, 0.02, 0);
        //headingPID = new PID(0.05, 0, 0);
        //headingPID.setTarget(targetHeading);
        //dom1PID = new PID(.01,0,0);
        armAnglePID = new PID(.025,0,0);
        //distancePID = new PID(.2,0,0);
        armAnglePID.setTarget(targetPosition);
        this.targetPosition = targetPosition;
        this.test = test;
        armAngleSpeed = spd;
        //this.targetHeading = targetHeading;
    }
    public ArmAngleMovement(double targetPosition, int test, double spd, boolean coast){
        this(targetPosition,test,spd);
        this.coast=coast;
    }

    public void init(){
        endTime = System.currentTimeMillis() + 150000;
    }

    public void execute(){
        //double heading = io.getHeading();
        //double heading = Math.toDegrees(io.heading);
        //double correction = dom1PID.getCorrection(io.getDOM1MotorEncoder());
        double correction = armAnglePID.getCorrection(io.getArmAnglePotDegrees());
        //double distanceCorrection;
/*        switch(test) {
            case XGREATERTHAN:
            case XLESSTHAN:
                distanceCorrection = distancePID.getCorrection(io.getX());
                break;
            case YGREATERTHAN:
            case YLESSTHAN:
            default:
                distanceCorrection = distancePID.getCorrection(io.getY());
                break;
        }*/
        //distanceCorrection = Range.clip(Math.abs(distanceCorrection),0,1);
        correction = Range.clip(correction,-1,1);
/*        double leftSpeed = (driveSpeed * distanceCorrection) + correction;
        double rightSpeed = (driveSpeed * distanceCorrection) - correction;
        if (driveSpeed > 0) {
            leftSpeed = Range.clip(leftSpeed, 0, 1);
            rightSpeed = Range.clip(rightSpeed, 0, 1);
        } else {
            leftSpeed = Range.clip(leftSpeed, -1, 0);
            rightSpeed = Range.clip(rightSpeed, -1, 0);
        }*/

        io.armAngleMotor.setPower(armAngleSpeed * correction);

        //telemetry.addData("x: ",io.getX());
        //telemetry.addData("y: ",io.getY());
        //telemetry.addData("Target Heading:", targetHeading);
        //telemetry.addData("Heading:", heading);
        //telemetry.addData("Heading Correction: ", correction);
/*        telemetry.addData("RPU1 Correction: ", correction);
        telemetry.addData("RPU1 Speed Requested: ", rpu1Speed);
        telemetry.addData("RPU1 Speed Actual with Correction: ", rpu1Speed * correction);
        //telemetry.addData("Right Speed: ", rightSpeed);
        telemetry.addData("Jewel Color is Unknown, Red, Blue: ", io.getJewelColor());
        telemetry.addData("Alliance Color is Unknown, Red, Blue: ", io.getAllianceColor());
        telemetry.addData("VuMark from IdentifyVuMark from IO", io.getVuMark());
        telemetry.addData("VuMark from IdentifyVuMark from IO", "%s visible", io.vuMark);
        telemetry.addData("Mode:", "RPU1 Movement");*/
    }

    public boolean isFinished(){
        return System.currentTimeMillis() >= endTime;
        //if (System.currentTimeMillis() >= endTime) return true;
        //telemetry.addData("x: ",io.getX());
        //telemetry.addData("y: ",io.getY());
        //telemetry.addData("Target Heading:", targetHeading);
        //telemetry.addData("Heading:", io.getHeading());
        //telemetry.addData("Heading Correction: ", headingPID.getCorrection(io.getHeading()));
        //telemetry.addData("Distance Correction: ", distancePID.getCorrection(io.getY()));
        //telemetry.addData("Drive Speed: ", driveSpeed);
        //telemetry.addData("Left Speed: ", (driveSpeed * distancePID.getCorrection(io.getY())) - headingPID.getCorrection(io.getHeading()));
        //telemetry.addData("Right Speed: ", (driveSpeed * distancePID.getCorrection(io.getY())) + headingPID.getCorrection(io.getHeading()));
        /*switch(test) {
            case INCREASINGDIRECTION:
                return io.getDOM1MotorEncoder() > targetPosition;
            case DECREASINGDIRECTION:
                return io.getDOM1MotorEncoder() < targetPosition;
            default:
                return io.getDOM1MotorEncoder() > targetPosition;
        }*/
    }

    public void stop(){
        execute();
    }

}
