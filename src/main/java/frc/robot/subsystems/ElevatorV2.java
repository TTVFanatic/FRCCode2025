package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.ClosedLoopSlot;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;

import frc.robot.Constants.ElevatorConstants;

public class ElevatorV2 extends SubsystemBase {
    private SparkMax m_elevatorSpark;
    private SparkMaxConfig m_motorConfig;
    private SparkClosedLoopController m_closedLoopController;
    private RelativeEncoder m_encoder;

    public ElevatorV2() {
        m_elevatorSpark = new SparkMax(ElevatorConstants.elevatorCanId, MotorType.kBrushless);
        m_closedLoopController = m_elevatorSpark.getClosedLoopController();
        m_encoder = m_elevatorSpark.getEncoder();


        m_motorConfig = new SparkMaxConfig();


        m_motorConfig.encoder
            .positionConversionFactor(ElevatorConstants.kPositionConversionFactor)
            .velocityConversionFactor(ElevatorConstants.kVelocityConversionFactor);


        m_motorConfig.closedLoop
            .feedbackSensor(FeedbackSensor.kPrimaryEncoder)
            .p(0.4)
            .i(0)
            .d(0)
            .outputRange(-1,1)

            .p(0.0001, ClosedLoopSlot.kSlot1)
            .i(0, ClosedLoopSlot.kSlot1)
            .d(0, ClosedLoopSlot.kSlot1)
            .velocityFF(1.0 / 5767, ClosedLoopSlot.kSlot1)
            .outputRange(-1, 1, ClosedLoopSlot.kSlot1);


        m_motorConfig.closedLoop.maxMotion
            .maxVelocity(1000)
            .maxAcceleration(1000)
            .allowedClosedLoopError(1)


            .maxAcceleration(500, ClosedLoopSlot.kSlot1)
            .maxVelocity(6000, ClosedLoopSlot.kSlot1)
            .allowedClosedLoopError(1, ClosedLoopSlot.kSlot1);




        m_elevatorSpark.configure(m_motorConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);


        SmartDashboard.setDefaultNumber("Target Position", 0);

        SmartDashboard.setDefaultBoolean("Reset Encoder", false);
    }


    public void teleopPeriodic() {
        double targetPosition = SmartDashboard.getNumber("Target Position", 0);
        m_closedLoopController.setReference(targetPosition, ControlType.kMAXMotionPositionControl,
            ClosedLoopSlot.kSlot0);
    }


    public void robotPeriodic() {
        SmartDashboard.putNumber("Actual Position", m_encoder.getPosition());


        if(SmartDashboard.getBoolean("Reset Encoder", false)) {
            SmartDashboard.putBoolean("Reset Boolean", false);

            m_encoder.setPosition(0);
        }
    }
}
