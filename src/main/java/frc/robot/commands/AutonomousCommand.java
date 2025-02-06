package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.auto.DriveForward;
import frc.robot.subsystems.Drive;

public class AutonomousCommand {
    public static class GoStraight extends SequentialCommandGroup {
        public GoStraight(Drive drive) {
            addCommands(new DriveForward(1.3, drive));
            addRequirements(drive);
        }
    }
}
