package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drive;

public class Move extends Command {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })

    private Drive m_drive;
    private XboxController m_controller;


    public Move(Drive drive, XboxController controller) {
        m_drive = drive;
        m_controller = controller;

        addRequirements(m_drive);
    }


    @Override
    public void initialize() {
    }


    @Override
    public void execute() {
        m_drive.drive(-m_controller.getLeftY(), m_controller.getLeftX(), m_controller.getRightX(), true);
    }


    @Override
    public void end(boolean interrupted) {
        m_drive.drive(0,0,0);
    }


    @Override
    public boolean isFinished() {
        return false;
    }
}
