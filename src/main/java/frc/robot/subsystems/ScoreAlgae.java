package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;

public class ScoreAlgae extends SubsystemBase {
    private final VictorSPX m_algaeMotor;

    public ScoreAlgae(VictorSPX algaeMotor) {
        m_algaeMotor = algaeMotor;
    }

    public void shootAlgae(double speed) {
        if(m_algaeMotor != null)
            m_algaeMotor.set(VictorSPXControlMode.PercentOutput, speed);
    }
}
