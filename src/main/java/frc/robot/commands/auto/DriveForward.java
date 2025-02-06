package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drive;

public class DriveForward extends Command {
    private Drive m_drive;
    private double m_duration;
    private double endTime;
    private double m_speed;

    public DriveForward(double duration, Drive drive) {
        m_drive = drive;
        m_duration = duration;
        m_speed = 0.75;

        addRequirements(m_drive);
    }

    public DriveForward(double duration, Drive drive, double speed) {
        m_drive = drive;
        m_duration = duration;
        m_speed = speed;

        addRequirements(m_drive);
    }


    @Override
    public void initialize() {
        endTime = Timer.getFPGATimestamp() + m_duration;
    }


    @Override
    public void execute() {
        m_drive.drive(m_speed, 0, 0);
    }


    @Override
    public void end(boolean interrupted) {
        m_drive.drive(0,0,0);
    }


    @Override
    public boolean isFinished() {
        return Timer.getFPGATimestamp() >= endTime;
    }
}
