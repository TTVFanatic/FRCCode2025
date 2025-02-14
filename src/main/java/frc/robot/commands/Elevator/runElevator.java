package frc.robot.commands.Elevator;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator;

public class runElevator extends Command {
    private final Elevator m_elevator;

    public runElevator(Elevator elevator) {
        m_elevator = elevator;

        addRequirements(m_elevator);
    }

    @Override
    public void initialize() {
        m_elevator.setElevatorSpeed(1);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
