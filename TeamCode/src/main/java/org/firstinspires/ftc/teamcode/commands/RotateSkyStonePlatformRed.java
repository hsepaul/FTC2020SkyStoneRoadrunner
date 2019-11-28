package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.utilities.PID;

/**
 * Created by David Austin on 10/27/2016.
 */

public class RotateSkyStonePlatformRed extends BasicCommand {
    double heading,leftSpd,rightSpd;
    PID headingPID;
    long timeOut;
    boolean rotatetodepot = false;
    boolean rotateafterhook = false;

    public RotateSkyStonePlatformRed(double heading, double leftSpd, double rightSpd){
        this.heading = heading;
        this.leftSpd = leftSpd;
        this.rightSpd = rightSpd;
        headingPID = new PID(0.07,0,0); //was 0.05
        headingPID.setTarget(heading);
    }

    public RotateSkyStonePlatformRed(double heading, double leftSpd, double rightSpd, boolean rotatetodepot){
        this(heading, leftSpd, rightSpd);
        this.rotatetodepot = rotatetodepot;
    }

    public RotateSkyStonePlatformRed(double heading, double leftSpd, double rightSpd, boolean rotatetodepot, boolean rotateafterhook){
        this(heading, leftSpd, rightSpd);
        this.rotateafterhook = rotateafterhook;
    }

    public void init() {

        timeOut = System.currentTimeMillis() + 4000;

        if (rotatetodepot){
            if (io.isGoldTheCenterMineral) {
                headingPID.setTarget(io.headingOfGold);
                heading = io.headingOfGold;
            }
            if (io.isGoldTheLeftMineral || io.isGoldTheRightMineral) {
                if (io.headingOfGold > 0) {
                    headingPID.setTarget(-45);
                    heading = -45;
                } else {
                    headingPID.setTarget(60);
                    heading = 60;
                }
                //headingPID.setTarget(-io.headingOfGold);
            }
        }

        if (!rotatetodepot && rotateafterhook) {
            headingPID.setTarget(io.headingOfGold);
            heading = io.headingOfGold;
        }
    }

    public void execute(){
        //double correction = headingPID.getCorrection(io.getHeading());
        double correction = headingPID.getCorrection(Math.toDegrees(io.heading));
        correction = Range.clip(correction,-1,1);
        //correction = Range.clip(correction,0,1);




        double frontleftSpeed = (-correction*leftSpd) + .25;
        double frontrightSpeed = (correction*rightSpd) - .25;
        double backleftSpeed = (-correction*leftSpd)  - .25;
        double backrightSpeed = (correction*rightSpd) + .25;



        frontleftSpeed = Range.clip(frontleftSpeed, -1, 1);
        backleftSpeed = Range.clip(backleftSpeed, -1, 1);
        frontrightSpeed = Range.clip(frontrightSpeed, -1, 1);
        backrightSpeed = Range.clip(backrightSpeed, -1, 1);



        io.setDrivePower(frontleftSpeed,frontrightSpeed,backleftSpeed,backrightSpeed);



        //io.setDrivePower(-correction*leftSpd,(correction*rightSpd)+.35, (-correction*leftSpd)+.35,correction*rightSpd);
        telemetry.addData("Target Heading:", heading);
        //telemetry.addData("Heading: ", io.getHeading());
        telemetry.addData("Heading: ", Math.toDegrees(io.heading));
        telemetry.addData("Correction: ", correction);
        telemetry.addData("Left Speed: ", leftSpd);
        telemetry.addData("Right Speed: ", rightSpd);
        //telemetry.addData("VuMark from IdentifyVuMark from IO", io.getVuMark());
        telemetry.addData("isGoldTheCenterMineralh: ", io.isGoldTheCenterMineral );
        telemetry.addData("isGoldTheLeftMineralh: ", io.isGoldTheLeftMineral );
        telemetry.addData("isGoldTheRightMineralh: ", io.isGoldTheRightMineral );

        telemetry.addData("Mode:", "Rotate");
    }

    public boolean isFinished(){
        telemetry.addData("Target Heading:", heading);
        //telemetry.addData("Heading: ", io.getHeading());
        telemetry.addData("Heading: ", Math.toDegrees(io.heading));
        telemetry.addData("x: ",io.getX());
        telemetry.addData("y: ",io.getY());
        telemetry.addData("Correction: ", headingPID.getCorrection(Math.toDegrees(io.heading)));
        telemetry.addData("Left Speed: ", leftSpd);
        telemetry.addData("Right Speed: ", rightSpd);
        telemetry.addData("isGoldTheCenterMineralh: ", io.isGoldTheCenterMineral );
        telemetry.addData("isGoldTheLeftMineralh: ", io.isGoldTheLeftMineral );
        telemetry.addData("isGoldTheRightMineralh: ", io.isGoldTheRightMineral );
        //telemetry.addData("VuMark from IdentifyVuMark from IO", io.getVuMark());
        //return Math.abs(io.getHeading() - heading) <=2 || System.currentTimeMillis() >= timeOut;
        return Math.abs(Math.toDegrees(io.heading) - heading) <=2.75 || System.currentTimeMillis() >= timeOut;
        //return System.currentTimeMillis() >= timeOut;
    }
    public void stop() {
        io.setDrivePower(0,0, 0, 0);
    }

}
