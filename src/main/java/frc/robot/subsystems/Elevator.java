package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;


public class Elevator extends SubsystemBase {
    private final SparkMax m_elevatorSpark;

    public Elevator(int elevatorCanId){
        m_elevatorSpark = new SparkMax(elevatorCanId, MotorType.kBrushless);
    }

    public void setElevatorSpeed (double speed) {
        m_elevatorSpark.set(speed);
    }
}
