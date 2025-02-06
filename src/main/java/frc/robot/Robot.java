// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private RobotContainer m_robotContainer;

  private Command autoCommand;


  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();
  }


  @Override
  public void robotPeriodic() {
    m_robotContainer.tick();
  }



  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }


  @Override
  public void autonomousInit() {
    autoCommand = m_robotContainer.getAutonomousCommand();


    if(autoCommand != null) {
      autoCommand.schedule();
    }
  }


  @Override
  public void autonomousPeriodic() {
    CommandScheduler.getInstance().run();
  }


  @Override
  public void teleopInit() {
    if(autoCommand != null) {
      autoCommand.cancel();
    }
  }


  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
  }


  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }


  @Override
  public void testPeriodic() {}


  @Override
  public void simulationInit() {}


  @Override
  public void simulationPeriodic() {}
}
