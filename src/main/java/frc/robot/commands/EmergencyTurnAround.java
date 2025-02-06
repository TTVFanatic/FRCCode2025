package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.OldDrive;

public class EmergencyTurnAround extends Command {
    private final OldDrive m_drive;
    private double endTime;

    public EmergencyTurnAround(OldDrive drive) {
        m_drive = drive;

        addRequirements(m_drive);
    }


    @Override
    public void initialize() {
        endTime = Timer.getFPGATimestamp() + 0.5;
    }


    @Override
    public void execute() {
        m_drive.driveCartesian(0, 0, 1);
    }


    @Override
    public boolean isFinished() {
        return Timer.getFPGATimestamp() >= endTime;
    }
}
