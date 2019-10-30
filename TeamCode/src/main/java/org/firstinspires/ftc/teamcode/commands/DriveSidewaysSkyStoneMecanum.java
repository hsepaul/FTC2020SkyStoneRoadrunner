package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.utilities.PID;

/**
 * Created by David Austin on 10/27/2016.
 */

public class DriveSidewaysSkyStoneMecanum extends BasicCommand {
    double targetPosition;
    double endDistance;
    double driveSpeed;
    PID distancePID;
    PID headingPID;
    public static final int YGREATERTHAN = 0;
    public static final int XGREATERTHAN = 1;
    public static final int YLESSTHAN = 2;
    public static final int XLESSTHAN = 3;
    int test;
    long endTime;
    double targetHeading;
    boolean coast = false;
    public DriveSidewaysSkyStoneMecanum(double targetPosition, int test, double spd, double targetHeading){
        headingPID = new PID(0.08,0,0);
        //headingPID = new PID(0.02, 0.02, 0);
        //headingPID = new PID(0.05, 0, 0);
        headingPID.setTarget(targetHeading);
        distancePID = new PID(.3,0,0);
        //distancePID = new PID(.2,0,0);
        distancePID.setTarget(targetPosition);
        this.targetPosition = targetPosition;
        this.test = test;
        driveSpeed = spd;
        this.targetHeading = targetHeading;
    }
    public DriveSidewaysSkyStoneMecanum(double targetPosition, int test, double spd, double targetHeading, boolean coast){
        this(targetPosition,test,spd,targetHeading);
        this.coast=coast;
    }

    public DriveSidewaysSkyStoneMecanum(double dist) {
        this(dist, YGREATERTHAN, 0.5, 0.0);
    }

    public void init(){
        endTime = System.currentTimeMillis() + 15000;

        /*if (usebutton){
            this.proximitybutton = io.proximityArmButtonPushed;
        }*/
    }

    public void execute(){
        //double heading = io.getHeading();
        double heading = Math.toDegrees(io.heading);
        double correction = headingPID.getCorrection(heading);
        double distanceCorrection;
        switch(test) {
            case XGREATERTHAN:
            case XLESSTHAN:
                distanceCorrection = distancePID.getCorrection(io.getSidewaysDistance());
                break;
            default:
                distanceCorrection = distancePID.getCorrection(io.getSidewaysDistance());
                break;
        }

/*#REMOVE
        double cosA = Math.cos(Math.toRadians(0.0));
        double sinA = Math.sin(Math.toRadians(0.0));
        double x1 = -gamepad1.left_stick_x*cosA - gamepad1.left_stick_y*sinA;
        double y1 = -gamepad1.left_stick_x*sinA + gamepad1.left_stick_y*cosA;
        double rotation = -gamepad1.right_stick_x;


        double[] wheelPowers = new double[4];
        wheelPowers[0] = x1 + y1 + rotation;   //FL
        wheelPowers[1] = -x1 + y1 - rotation;  //FR
        wheelPowers[2] = -x1 + y1 + rotation;  //BL
        wheelPowers[3] = x1 + y1 - rotation;   //BR
        // #REMOVE*/




        distanceCorrection = Range.clip(Math.abs(distanceCorrection),0,1);
        correction = Range.clip(correction,-1,1);
        double frontleftSpeed = (-driveSpeed * distanceCorrection) - correction;
        double frontrightSpeed = (driveSpeed * distanceCorrection) + correction;
        double backleftSpeed = (driveSpeed * distanceCorrection) - correction;
        double backrightSpeed = (-driveSpeed * distanceCorrection) + correction;
        if (driveSpeed > 0) {
            frontleftSpeed = Range.clip(frontleftSpeed, -1, 0);
            frontrightSpeed = Range.clip(frontrightSpeed, 0, 1);
            backleftSpeed = Range.clip(backleftSpeed, 0, 1);
            backrightSpeed = Range.clip(backrightSpeed, -1, 0);
        } else {
            frontleftSpeed = Range.clip(frontleftSpeed, 0, 1);
            frontrightSpeed = Range.clip(frontrightSpeed, -1, 0);
            backleftSpeed = Range.clip(backleftSpeed, -1, 0);
            backrightSpeed = Range.clip(backrightSpeed, 0, 1);
        }

        io.setDrivePower(frontleftSpeed,frontrightSpeed,backleftSpeed,backrightSpeed);
        telemetry.addData("x: ",io.getX());
        telemetry.addData("y: ",io.getY());
        telemetry.addData("sideways: ",io.getSidewaysDistance());
        telemetry.addData("Target Heading:", targetHeading);
        telemetry.addData("Heading:", heading);
        telemetry.addData("Heading Correction: ", correction);
        telemetry.addData("Distance Correction: ", distanceCorrection);
        telemetry.addData("Drive Speed: ", driveSpeed);
        telemetry.addData("Front Left Speed: ", frontleftSpeed);
        telemetry.addData("Front Right Speed: ", frontrightSpeed);
        telemetry.addData("Back Left Speed: ", backleftSpeed);
        telemetry.addData("Back Right Speed: ", backrightSpeed);
        //telemetry.addData("Jewel Color is Unknown, Red, Blue: ", io.getJewelColor());
        telemetry.addData("Alliance Color is Unknown, Red, Blue: ", io.getAllianceColor());
        //telemetry.addData("VuMark from IdentifyVuMark from IO", io.getVuMark());
        //telemetry.addData("VuMark from IdentifyVuMark from IO", "%s visible", io.vuMark);
        telemetry.addData("Mode:", "Drive Sideways");
    }

    public boolean isFinished(){
        if (System.currentTimeMillis() >= endTime) return true;
        /*if ((io.touchProximity.getState() == false) && (usebutton == false)){
            io.proximityArmButtonPushed = true;
            return true;
        }*/
        //if ((usebutton == true) && (proximitybutton == false)) return true;
        //telemetry.addData("x: ",io.getX());
        //telemetry.addData("y: ",io.getY());
        //telemetry.addData("Target Heading:", targetHeading);
        //telemetry.addData("Heading:", io.getHeading());
        //telemetry.addData("Heading Correction: ", headingPID.getCorrection(io.getHeading()));
        //telemetry.addData("Distance Correction: ", distancePID.getCorrection(io.getY()));
        //telemetry.addData("Drive Speed: ", driveSpeed);
        //telemetry.addData("Left Speed: ", (driveSpeed * distancePID.getCorrection(io.getY())) - headingPID.getCorrection(io.getHeading()));
        //telemetry.addData("Right Speed: ", (driveSpeed * distancePID.getCorrection(io.getY())) + headingPID.getCorrection(io.getHeading()));
        switch(test) {
            case XGREATERTHAN:
                return io.getSidewaysDistance() > targetPosition;
            case XLESSTHAN:
                return io.getSidewaysDistance() < targetPosition;
            default:
                return io.getSidewaysDistance() < targetPosition;
        }
    }

    public void stop(){
        if (!coast) io.setDrivePower(0.0,0.0, 0.0, 0.0);
    }

}
