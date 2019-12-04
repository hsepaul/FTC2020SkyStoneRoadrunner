package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.commands.ArmAngleDown;
import org.firstinspires.ftc.teamcode.commands.ArmAngleUp;
import org.firstinspires.ftc.teamcode.commands.CalibrationSkystoneCommand;
import org.firstinspires.ftc.teamcode.commands.CommandGroup;
import org.firstinspires.ftc.teamcode.commands.DriveForwardHeadingandDistanceSensorSkyStone;
import org.firstinspires.ftc.teamcode.commands.DriveForwardSkyStone;
import org.firstinspires.ftc.teamcode.commands.DriveForwardSkyStoneOpenCV;
import org.firstinspires.ftc.teamcode.commands.DriveSidewaysSkyStoneMecanum;
import org.firstinspires.ftc.teamcode.commands.DriveSidewaysSkyStoneMecanumTensorFlow;
import org.firstinspires.ftc.teamcode.commands.DriveSidewaysSkyStoneOpenCV;
import org.firstinspires.ftc.teamcode.commands.GripperPincherClosed;
import org.firstinspires.ftc.teamcode.commands.GripperPincherOpen;
import org.firstinspires.ftc.teamcode.commands.GripperRotateParallel;
import org.firstinspires.ftc.teamcode.commands.ResetDriveEncoders;
import org.firstinspires.ftc.teamcode.commands.Rotate;
import org.firstinspires.ftc.teamcode.commands.WaitForTime;

/**
 * Created by David Austin on 11/10/2016.
 */

@Autonomous(name="Red Sky Stone Blocks OpenCV",group="Auton")
public class Red2AutonSkyStoneOpenCV extends RedAutonSkyStone {
    public void addFinalCommands() {

        CommandGroup group = new CommandGroup();
        group.addCommand(new DriveForwardSkyStone(5,DriveForwardSkyStone.XGREATERTHAN,.7,0, 3000));
        group.addCommand(new GripperRotateParallel(3000));
        group.addCommand(new ArmAngleUp(5000));
        commands.add(group);

        commands.add(new WaitForTime(250));
        commands.add(new ResetDriveEncoders());

        commands.add(new DriveSidewaysSkyStoneOpenCV(io.skystoneWidth,DriveForwardSkyStone.XGREATERTHAN,.5,0, 3000));

        commands.add(new WaitForTime(250));
        commands.add(new ResetDriveEncoders());



        commands.add(new DriveForwardHeadingandDistanceSensorSkyStone(io.approachDistance, DriveForwardHeadingandDistanceSensorSkyStone.LEFTLESSTHAN,.4,0, 5000));

        commands.add(new WaitForTime(250));
        commands.add(new ResetDriveEncoders());

        //GRAB SKYSTONE
        CommandGroup group1 = new CommandGroup();
        group1.addCommand(new GripperPincherClosed( 1500));
        group1.addCommand(new ArmAngleDown(5000));
        group1.addCommand(new DriveForwardSkyStone(-1,DriveForwardSkyStone.XLESSTHAN,-.4,0, 2000));
        commands.add(group1);

        commands.add(new WaitForTime(250));
        commands.add(new ResetDriveEncoders());

        CommandGroup group2 = new CommandGroup();
        group2.addCommand(new ArmAngleUp(5000));
        group2.addCommand(new DriveForwardSkyStone(-io.backupClearance,DriveForwardSkyStone.XLESSTHAN,-.5,0, 5000));
        commands.add(group2);


        commands.add(new WaitForTime(250));
        commands.add(new ResetDriveEncoders());

        commands.add(new Rotate(90, .5, .5, 10000));

        commands.add(new WaitForTime(250));
        commands.add(new ResetDriveEncoders());

        commands.add(new DriveForwardSkyStoneOpenCV((io.distanceToTape+io.distancePastTape),DriveForwardSkyStone.XGREATERTHAN,.65,90, 10000));


        //DROP SKYSTONE
        commands.add(new GripperPincherOpen( 1500));


        commands.add(new WaitForTime(250));
        commands.add(new ResetDriveEncoders());

        commands.add(new DriveForwardSkyStoneOpenCV(-(io.distancePastTape+io.distanceToTape+io.distanceBetweenSkystones),DriveForwardSkyStone.XLESSTHAN,-.65,90, 10000));

        commands.add(new WaitForTime(250));
        commands.add(new ResetDriveEncoders());

        commands.add(new Rotate(0, .5, .5, 10000));

        commands.add(new WaitForTime(250));
        commands.add(new ResetDriveEncoders());

        commands.add(new DriveForwardHeadingandDistanceSensorSkyStone(io.approachDistance, DriveForwardHeadingandDistanceSensorSkyStone.LEFTLESSTHAN,.4,0, 5000));

        commands.add(new WaitForTime(250));
        commands.add(new ResetDriveEncoders());

        //GRAB SKYSTONE
        CommandGroup group3 = new CommandGroup();
        group3.addCommand(new GripperPincherClosed( 1500));
        group3.addCommand(new ArmAngleDown(5000));
        group3.addCommand(new DriveForwardSkyStone(-1,DriveForwardSkyStone.XLESSTHAN,-.4,0, 2000));
        commands.add(group3);

        commands.add(new WaitForTime(250));
        commands.add(new ResetDriveEncoders());

        CommandGroup group4 = new CommandGroup();
        group4.addCommand(new ArmAngleUp(5000));
        group4.addCommand(new DriveForwardSkyStone(-io.backupClearance,DriveForwardSkyStone.XLESSTHAN,-.5,0, 5000));
        commands.add(group4);

        commands.add(new WaitForTime(250));
        commands.add(new ResetDriveEncoders());


        commands.add(new Rotate(90, .5, .5, 3000));

        commands.add(new WaitForTime(250));
        commands.add(new ResetDriveEncoders());

        commands.add(new DriveForwardSkyStoneOpenCV((io.distanceBetweenSkystones+io.distanceToTape+io.distancePastTape),DriveForwardSkyStone.XGREATERTHAN,.65,90, 10000));

        commands.add(new WaitForTime(250));
        commands.add(new ResetDriveEncoders());

        //DROP SKYSTONE
        commands.add(new GripperPincherOpen( 1500));


        commands.add(new DriveForwardSkyStone(-(io.distancePastTape),DriveForwardSkyStone.XLESSTHAN,-.65,90, 5000));


    }
}
