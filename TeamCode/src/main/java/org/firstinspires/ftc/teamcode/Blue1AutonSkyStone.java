package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.commands.DriveForward;
import org.firstinspires.ftc.teamcode.commands.DriveForwardHeadingandDistanceSensor;
import org.firstinspires.ftc.teamcode.commands.DriveForwardHeavySkyStone;
import org.firstinspires.ftc.teamcode.commands.DriveForwardHeavySkyStoneBlue;
import org.firstinspires.ftc.teamcode.commands.DriveForwardSkyStone;
import org.firstinspires.ftc.teamcode.commands.DriveSidewaysSkyStoneMecanum;
import org.firstinspires.ftc.teamcode.commands.HooksDown;
import org.firstinspires.ftc.teamcode.commands.HooksUp;
import org.firstinspires.ftc.teamcode.commands.MarkerboxDown;
import org.firstinspires.ftc.teamcode.commands.ResetDriveEncoders;
import org.firstinspires.ftc.teamcode.commands.Rotate;
import org.firstinspires.ftc.teamcode.commands.SetIMUOffset;
import org.firstinspires.ftc.teamcode.commands.WaitForTime;

/**
 * Created by David Austin on 11/10/2016.
 */

@Autonomous(name="Blue Sky Stone Platform",group="Auton")
public class Blue1AutonSkyStone extends BlueAutonSkyStone {
    public void addFinalCommands() {
        commands.add(new DriveSidewaysSkyStoneMecanum(-12,DriveSidewaysSkyStoneMecanum.XLESSTHAN,-.85,0));
        commands.add(new WaitForTime(250));
        commands.add(new ResetDriveEncoders());
        commands.add(new WaitForTime(250));
        commands.add(new DriveForwardSkyStone(30,DriveForwardSkyStone.XGREATERTHAN,.5,0));
        commands.add(new ResetDriveEncoders());
        commands.add(new WaitForTime(500));
        commands.add(new HooksDown());
        commands.add(new WaitForTime(1000));
        commands.add(new DriveForwardHeavySkyStoneBlue(-30,DriveForwardHeavySkyStoneBlue.XLESSTHAN,-.75,0));
        commands.add(new WaitForTime(500));
        commands.add(new HooksUp());
        commands.add(new WaitForTime(1000));
        commands.add(new ResetDriveEncoders());
        commands.add(new WaitForTime(250));
        commands.add(new DriveSidewaysSkyStoneMecanum(38,DriveSidewaysSkyStoneMecanum.XGREATERTHAN,.85,0));
        //commands.add(new DriveForward(18,DriveForward.XGREATERTHAN,.8,0, false, true, true));
    }
}
