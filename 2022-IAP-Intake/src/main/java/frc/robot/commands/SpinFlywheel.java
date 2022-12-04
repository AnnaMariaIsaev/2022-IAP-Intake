// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Intake;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SpinFlywheel extends CommandBase {
  /** Creates a new SpinFlywheel. */
  private final Intake intake;
  private final Joystick joy;

  private int numSpikes;
  
  public SpinFlywheel(Intake intake, Joystick joy)
  {
    // Use addRequirements() here to declare subsystem dependencies
    this.intake = intake;
    this.joy = joy;
    numSpikes = 0;
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    if(RobotContainer.getJoy().getRawButtonPressed(10))
    {
      intake.setFlywheelPower(-1);
    }
    if(RobotContainer.getJoy().getRawButtonPressed(11))
    {
      intake.setFlywheelPower(1);
    }
    if(RobotContainer.getJoy().getRawButtonPressed(12))
    {
      intake.setFlywheelPower(0);
    }
    
    //telemetry
    SmartDashboard.putNumber("Intake Flywheel Current", intake.getCurrent());

    if(intake.getCurrent() > 3.0) numSpikes++;
    
    SmartDashboard.putNumber("Has Ball: ", numSpikes%2); //1 is has ball
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
