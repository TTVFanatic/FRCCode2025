package frc.robot.commands.processor;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ScoreAlgae;

public class TurnOffScoring extends Command {
    private final ScoreAlgae m_scoreAlgae;

    public TurnOffScoring(ScoreAlgae scoreAlgae) {
        m_scoreAlgae = scoreAlgae;
        
        addRequirements(m_scoreAlgae);
    }


    @Override
    public void initialize() {
        m_scoreAlgae.shootAlgae(0);
    }


    @Override
    public boolean isFinished() {
        return true;
    }
}
