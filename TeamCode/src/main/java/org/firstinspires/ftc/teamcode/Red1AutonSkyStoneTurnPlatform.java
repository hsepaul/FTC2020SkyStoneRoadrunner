package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.commands.CalibrationSkystoneCommand;
import org.firstinspires.ftc.teamcode.commands.DriveForwardHeavySkyStonewithSlideLeft;
import org.firstinspires.ftc.teamcode.commands.DriveForwardHeavySkyStonewithSlideRight;
import org.firstinspires.ftc.teamcode.commands.DriveForwardSkyStone;
import org.firstinspires.ftc.teamcode.commands.DriveSidewaysSkyStoneMecanum;
import org.firstinspires.ftc.teamcode.commands.DriveSidewaysSkyStoneMecanumNoSkystones;
import org.firstinspires.ftc.teamcode.commands.GripperRotateParallel;
import org.firstinspires.ftc.teamcode.commands.HooksDown;
import org.firstinspires.ftc.teamcode.commands.HooksUp;
import org.firstinspires.ftc.teamcode.commands.ResetDriveEncoders;
import org.firstinspires.ftc.teamcode.commands.Rotate;
import org.firstinspires.ftc.teamcode.commands.RotateHeavy;
import org.firstinspires.ftc.teamcode.commands.RotateSkyStonePlatformRed;
import org.firstinspires.ftc.teamcode.commands.WaitForTime;

/**
 * Created by David Austin on 11/10/2016.
 */

@Autonomous(name="Red Sky Stone Turn Platform",group="Auton")
public class Red1AutonSkyStoneTurnPlatform extends RedAutonSkyStone {
    public void addFinalCommands() {
        commands.add(new DriveSidewaysSkyStoneMecanumNoSkystones(8,DriveSidewaysSkyStoneMecanumNoSkystones.XGREATERTHAN,.85,0, 30000));
        commands.add(new WaitForTime(250));
        commands.add(new ResetDriveEncoders());
        commands.add(new WaitForTime(250));
        commands.add(new DriveForwardSkyStone(30,DriveForwardSkyStone.XGREATERTHAN,.5,0, 5000));
        commands.add(new ResetDriveEncoders());
        commands.add(new WaitForTime(500));
        commands.add(new HooksDown(3000));
        commands.add(new WaitForTime(1500));
        commands.add(new DriveForwardHeavySkyStonewithSlideLeft(-20, DriveForwardHeavySkyStonewithSlideLeft.XLESSTHAN,-.75,0, 5000));
        commands.add(new ResetDriveEncoders());
        commands.add(new WaitForTime(500));

        //commands.add(new RotateSkyStonePlatformRed(90, .75, .75));
        commands.add(new RotateHeavy(90, .75, .75, 4000));
        commands.add(new ResetDriveEncoders());
        commands.add(new WaitForTime(500));

        //commands.add(new DriveSidewaysSkyStoneMecanum(30,DriveSidewaysSkyStoneMecanum.XGREATERTHAN,.85,90));
        //commands.add(new ResetDriveEncoders());
        //commands.add(new WaitForTime(500));

        commands.add(new HooksUp(3000));
        commands.add(new ResetDriveEncoders());
        commands.add(new WaitForTime(1500));

        commands.add(new DriveForwardSkyStone(-20,DriveForwardSkyStone.XLESSTHAN,-.5,90, 5000));
        commands.add(new ResetDriveEncoders());
        commands.add(new WaitForTime(500));

        commands.add(new GripperRotateParallel(3000));
        commands.add(new ResetDriveEncoders());
        commands.add(new WaitForTime(500));

        commands.add(new DriveForwardSkyStone(-10,DriveForwardSkyStone.XLESSTHAN,-.5,90, 5000));

        //commands.add(new DriveSidewaysSkyStoneMecanum(-50,DriveSidewaysSkyStoneMecanum.XLESSTHAN,-.85,0));
        commands.add( new CalibrationSkystoneCommand(8000));
        //commands.add(new DriveForward(18,DriveForward.XGREATERTHAN,.8,0, false, true, true));
    }
}
