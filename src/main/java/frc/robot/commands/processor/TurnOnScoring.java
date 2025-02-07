package frc.robot.commands.processor;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.ScoreAlgae;

public class TurnOnScoring extends Command {
    private final ScoreAlgae m_scoreAlgae;
    private final XboxController m_controller;

    public TurnOnScoring(ScoreAlgae scoreAlgae, XboxController controller) {
        m_scoreAlgae = scoreAlgae;
        m_controller = controller;

        addRequirements(m_scoreAlgae);
    }


    @Override
    public void initialize() {
        m_scoreAlgae.shootAlgae(m_controller.getLeftTriggerAxis());
    }


    @Override
    public void execute() {
        m_scoreAlgae.shootAlgae(m_controller.getLeftTriggerAxis());
    }

    public boolean isFinished() {
        return false;
    }
}
