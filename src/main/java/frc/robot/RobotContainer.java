// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
//import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.AlgaeScoringConstants;
import frc.robot.Constants.ElevatorConstants;
import frc.robot.commands.AutonomousCommand;
//import frc.robot.commands.ChangeDriveSpeed;
import frc.robot.commands.processor.*;
import frc.robot.commands.Elevator.*;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.ScoreAlgae;
//import frc.robot.subsystems.Elevator;

@SuppressWarnings("resource")

public class RobotContainer {
  public RobotContainer() {
    configureBindings();

    m_drive.setDefaultCommand(
      new RunCommand(
        () -> m_drive.drive(
          -MathUtil.applyDeadband(m_driveController.getLeftY(), OperatorConstants.driveDeadband),
          -MathUtil.applyDeadband(m_driveController.getLeftX(), OperatorConstants.driveDeadband),
          -MathUtil.applyDeadband(m_driveController.getRightX(), OperatorConstants.driveDeadband),
          true),
        m_drive));
  }

  private Drive m_drive = new Drive();

  private final XboxController m_driveController = new XboxController(
    OperatorConstants.driverControllerPort);

  private final XboxController m_shooterController = new XboxController(
    OperatorConstants.shooterControllerPort);

  private final Joystick m_joystick = new Joystick(
    OperatorConstants.driverControllerPort);

  private final ScoreAlgae m_scoreAlgae = new ScoreAlgae(
    new VictorSPX(AlgaeScoringConstants.VictorSPXAlgaeCanId));

    private final Elevator m_elevator = new Elevator(
      ElevatorConstants.elevatorCanId);


  private void configureBindings() {
    
    new Trigger(() -> m_driveController.getRightTriggerAxis() > 0.1)
      .whileTrue(new RunCommand(() -> m_drive.setX(), m_drive));


    new Trigger(() -> m_joystick.getRawButton(3) || m_joystick.getRawButton(4))
      .whileTrue(new RunCommand(() -> m_drive.setX(), m_drive));


    new Trigger(() -> m_shooterController.getLeftTriggerAxis() > 0.0)
      .onTrue(new TurnOnScoring(m_scoreAlgae, m_shooterController));


    new Trigger(() -> m_shooterController.getXButtonPressed())
      .onTrue(new TurnOffScoring(m_scoreAlgae));


    new Trigger(() -> m_shooterController.getAButtonPressed())
      .onTrue(new AlgaeFullPower(m_scoreAlgae));

    new Trigger(() -> m_shooterController.getBButtonPressed())
      .whileTrue(new runElevator(m_elevator));
  }




  public void tick() {}

  public Command getAutonomousCommand() {
    return new AutonomousCommand.GoStraight(m_drive);
  }
}
