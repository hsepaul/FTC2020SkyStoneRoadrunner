package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.commands.ArmAngleDown;
import org.firstinspires.ftc.teamcode.commands.ArmAngleUp;
import org.firstinspires.ftc.teamcode.commands.DriveForwardHeadingandDistanceSensorSkyStone;
import org.firstinspires.ftc.teamcode.commands.DriveSidewaysSkyStoneMecanum;
import org.firstinspires.ftc.teamcode.commands.DriveSidewaysSkyStoneMecanumTensorFlow;
import org.firstinspires.ftc.teamcode.commands.GripperPincherClosed;
import org.firstinspires.ftc.teamcode.commands.GripperPincherOpen;
import org.firstinspires.ftc.teamcode.commands.GripperRotateParallel;
import org.firstinspires.ftc.teamcode.commands.GripperRotateStowed;
import org.firstinspires.ftc.teamcode.commands.ResetDriveEncoders;
import org.firstinspires.ftc.teamcode.commands.WaitForTime;

/**
 * Created by David Austin on 11/10/2016.
 */

@Autonomous(name="Red Sky Stone Blocks TEST",group="Auton")
public class Red2AutonSkyStoneTEST extends RedAutonSkyStone {
    public void addFinalCommands() {
        commands.add(new DriveSidewaysSkyStoneMecanumTensorFlow(0,-.4,0));
        commands.add(new WaitForTime(10000));
        commands.add(new DriveSidewaysSkyStoneMecanumTensorFlow(0,-.4,0));
    }
}
