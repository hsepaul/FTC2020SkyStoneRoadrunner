package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.commands.ArmAngleDown;
import org.firstinspires.ftc.teamcode.commands.ArmAngleUp;
import org.firstinspires.ftc.teamcode.commands.DriveForwardHeadingandDistanceSensorSkyStone;
import org.firstinspires.ftc.teamcode.commands.DriveSidewaysSkyStoneMecanum;
import org.firstinspires.ftc.teamcode.commands.GripperPincherOpen;
import org.firstinspires.ftc.teamcode.commands.GripperRotateParallel;
import org.firstinspires.ftc.teamcode.commands.GripperPincherClosed;
import org.firstinspires.ftc.teamcode.commands.GripperRotateStowed;
import org.firstinspires.ftc.teamcode.commands.ResetDriveEncoders;
import org.firstinspires.ftc.teamcode.commands.WaitForTime;

/**
 * Created by David Austin on 11/10/2016.
 */

@Autonomous(name="Blue Sky Stone Blocks",group="Auton")
public class Blue2AutonSkyStone extends BlueAutonSkyStone {
    public void addFinalCommands() {
        commands.add(new GripperRotateParallel());
        commands.add(new WaitForTime(500));
        commands.add(new GripperPincherOpen());
        commands.add(new WaitForTime(250));
        commands.add((new ArmAngleUp()));
        commands.add(new WaitForTime(500));
        commands.add(new DriveForwardHeadingandDistanceSensorSkyStone(3.5, DriveForwardHeadingandDistanceSensorSkyStone.LEFTLESSTHAN,.4,0));
        commands.add(new WaitForTime(500));
        commands.add((new ArmAngleDown()));
        commands.add(new WaitForTime(500));
        commands.add(new GripperPincherClosed());
        commands.add(new WaitForTime(500));
        commands.add(new GripperRotateStowed());
        commands.add(new WaitForTime(250));
        commands.add(new ResetDriveEncoders());
        commands.add(new DriveSidewaysSkyStoneMecanum(-12,DriveSidewaysSkyStoneMecanum.XLESSTHAN,-.85,0));
        commands.add(new WaitForTime(250));
        commands.add(new ResetDriveEncoders());
        commands.add(new GripperRotateParallel());
        commands.add(new WaitForTime(500));
        commands.add(new GripperPincherOpen());
        commands.add(new WaitForTime(250));
        commands.add(new GripperRotateStowed());
        commands.add(new WaitForTime(250));
        //commands.add(new DriveForward(18,DriveForward.XGREATERTHAN,.8,0, false, true, true));
    }
}
