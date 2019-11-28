package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.commands.CalibrationSkystoneCommand;
import org.firstinspires.ftc.teamcode.commands.DriveForwardHeavySkyStonewithSlideLeft;
import org.firstinspires.ftc.teamcode.commands.DriveForwardHeavySkyStonewithSlideRight;
import org.firstinspires.ftc.teamcode.commands.DriveForwardSkyStone;
import org.firstinspires.ftc.teamcode.commands.DriveSidewaysSkyStoneMecanumNoSkystones;
import org.firstinspires.ftc.teamcode.commands.GripperRotateParallel;
import org.firstinspires.ftc.teamcode.commands.HooksDown;
import org.firstinspires.ftc.teamcode.commands.HooksUp;
import org.firstinspires.ftc.teamcode.commands.ResetDriveEncoders;
import org.firstinspires.ftc.teamcode.commands.Rotate;
import org.firstinspires.ftc.teamcode.commands.WaitForTime;

/**
 * Created by David Austin on 11/10/2016.
 */

@Autonomous(name="Blue Sky Stone Turn Platform",group="Auton")
public class Blue1AutonSkyStoneTurnPlatform extends BlueAutonSkyStone {
    public void addFinalCommands() {
        commands.add(new DriveSidewaysSkyStoneMecanumNoSkystones(-12,DriveSidewaysSkyStoneMecanumNoSkystones.XLESSTHAN,-.85,0));
        commands.add(new WaitForTime(250));
        commands.add(new ResetDriveEncoders());
        commands.add(new WaitForTime(250));
        commands.add(new DriveForwardSkyStone(30,DriveForwardSkyStone.XGREATERTHAN,.5,0));
        commands.add(new ResetDriveEncoders());
        commands.add(new WaitForTime(500));
        commands.add(new HooksDown());
        commands.add(new WaitForTime(1500));
        commands.add(new DriveForwardHeavySkyStonewithSlideRight(-20, DriveForwardHeavySkyStonewithSlideRight.XLESSTHAN,-.75,0));
        commands.add(new ResetDriveEncoders());
        commands.add(new WaitForTime(500));

        //commands.add(new RotateSkyStonePlatformRed(90, .75, .75));
        commands.add(new Rotate(-90, .75, .75));
        commands.add(new ResetDriveEncoders());
        commands.add(new WaitForTime(500));

        //commands.add(new DriveSidewaysSkyStoneMecanum(30,DriveSidewaysSkyStoneMecanum.XGREATERTHAN,.85,90));
        //commands.add(new ResetDriveEncoders());
        //commands.add(new WaitForTime(500));

        commands.add(new HooksUp());
        commands.add(new ResetDriveEncoders());
        commands.add(new WaitForTime(1500));

        commands.add(new DriveForwardSkyStone(-20,DriveForwardSkyStone.XLESSTHAN,-.5,-90));
        commands.add(new ResetDriveEncoders());
        commands.add(new WaitForTime(500));

        commands.add(new GripperRotateParallel());
        commands.add(new ResetDriveEncoders());
        commands.add(new WaitForTime(500));

        commands.add(new DriveForwardSkyStone(-10,DriveForwardSkyStone.XLESSTHAN,-.5,-90));

        //commands.add(new DriveSidewaysSkyStoneMecanum(-50,DriveSidewaysSkyStoneMecanum.XLESSTHAN,-.85,0));
        commands.add( new CalibrationSkystoneCommand());
        //commands.add(new DriveForward(18,DriveForward.XGREATERTHAN,.8,0, false, true, true));
    }
}
