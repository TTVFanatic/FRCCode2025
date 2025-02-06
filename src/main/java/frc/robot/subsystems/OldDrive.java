package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class OldDrive extends SubsystemBase {
    private MecanumDrive m_drive;
    private ADXRS450_Gyro m_gyro;

    public OldDrive(MotorController frontLeftMotor, MotorController rearLeftMotor, MotorController frontRightMotor,
            MotorController rearRightMotor) {
        m_drive = new MecanumDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
        m_gyro = null;

        frontRightMotor.setInverted(true);
        rearRightMotor.setInverted(true);
    }

    public OldDrive(MotorController frontLeftMotor, MotorController rearLeftMotor, MotorController frontRightMotor,
            MotorController rearRightMotor, ADXRS450_Gyro gyro) {
        m_drive = new MecanumDrive(frontLeftMotor,rearLeftMotor, frontRightMotor, rearRightMotor);
        m_gyro = gyro;

        frontRightMotor.setInverted(true);
        rearRightMotor.setInverted(true);
    }

    public double speed = 1;

    public void driveCartesian(double xSpeed, double ySpeed, double zRotation) {
        if(m_gyro != null)
            m_drive.driveCartesian(xSpeed * speed, ySpeed * speed, zRotation * speed, m_gyro.getRotation2d());
        else
            m_drive.driveCartesian(xSpeed * speed, ySpeed * speed, zRotation * speed);
    }
}
