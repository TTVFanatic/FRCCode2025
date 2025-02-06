package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drive;

public class ChangeDriveSpeed extends Command {
    private final XboxController m_controller;
    private final Drive m_drive;

    public ChangeDriveSpeed(Drive drive, XboxController controller) {
        m_drive = drive;
        m_controller = controller;

        addRequirements(drive);
    }

    @Override
    public void initialize() {
        m_drive.speed = Math.round((m_drive.speed + (m_controller.getLeftBumper() ? -0.1 : 0.1)) * 10) / 10d;

        if(m_drive.speed > 1)
            m_drive.speed = 1;
        if(m_drive.speed < 0)
            m_drive.speed = 0;
    }

    public boolean isFinished() {
        return true;
    }
}
