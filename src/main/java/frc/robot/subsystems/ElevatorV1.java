package frc.robot.subsystems;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkAbsoluteEncoder;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorV1 extends SubsystemBase {

    public ElevatorV1(int elevatorCanId){
    }

    public void setElevatorSpeed (double speed) {
    }

    public void setElevatorDistance (/* Double or an int for specific heights */) {
        
    }
}
