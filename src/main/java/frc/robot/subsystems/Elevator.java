package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

// import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
// import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkFlex;
// import com.revrobotics.spark.SparkBase.ControlType;
// import com.revrobotics.spark.SparkBase.PersistMode;
// import com.revrobotics.spark.SparkBase.ResetMode;
// import com.revrobotics.spark.config.SparkMaxConfig;
// import com.revrobotics.spark.ClosedLoopSlot;
// import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;

import frc.robot.Constants.ElevatorConstants;

public class Elevator extends SubsystemBase {
    SparkFlex m_elevatorFlex;

    public Elevator() {
        m_elevatorFlex = new SparkFlex(ElevatorConstants.elevatorCanId, MotorType.kBrushless);
    }
}