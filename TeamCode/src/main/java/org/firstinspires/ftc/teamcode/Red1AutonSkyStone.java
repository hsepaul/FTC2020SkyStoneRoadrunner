package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.commands.CalibrationSkystoneCommand;
import org.firstinspires.ftc.teamcode.commands.DriveForward;
import org.firstinspires.ftc.teamcode.commands.DriveForwardHeavySkyStone;
import org.firstinspires.ftc.teamcode.commands.DriveForwardHeavySkyStoneRed;
import org.firstinspires.ftc.teamcode.commands.DriveForwardSkyStone;
import org.firstinspires.ftc.teamcode.commands.DriveSidewaysSkyStoneMecanum;
import org.firstinspires.ftc.teamcode.commands.HooksDown;
import org.firstinspires.ftc.teamcode.commands.HooksUp;
import org.firstinspires.ftc.teamcode.commands.ResetDriveEncoders;
import org.firstinspires.ftc.teamcode.commands.WaitForTime;

/**
 * Created by David Austin on 11/10/2016.
 */

@Autonomous(name="Red Sky Stone Platform",group="Auton")
public class Red1AutonSkyStone extends RedAutonSkyStone {
    public void addFinalCommands() {
        commands.add(new DriveSidewaysSkyStoneMecanum(12,DriveSidewaysSkyStoneMecanum.XGREATERTHAN,.85,0));
        commands.add(new WaitForTime(250));
        commands.add(new ResetDriveEncoders());
        commands.add(new WaitForTime(250));
        commands.add(new DriveForwardSkyStone(30,DriveForwardSkyStone.XGREATERTHAN,.5,0));
        commands.add(new ResetDriveEncoders());
        commands.add(new WaitForTime(500));
        commands.add(new HooksDown());
        commands.add(new WaitForTime(1000));
        commands.add(new DriveForwardHeavySkyStoneRed(-30,DriveForwardHeavySkyStoneRed.XLESSTHAN,-.75,0));
        commands.add(new WaitForTime(500));
        commands.add(new HooksUp());
        commands.add(new WaitForTime(1000));
        commands.add(new ResetDriveEncoders());
        commands.add(new WaitForTime(250));
        commands.add(new DriveSidewaysSkyStoneMecanum(-50,DriveSidewaysSkyStoneMecanum.XLESSTHAN,-.85,0));
        commands.add( new CalibrationSkystoneCommand());
        //commands.add(new DriveForward(18,DriveForward.XGREATERTHAN,.8,0, false, true, true));
    }
}
