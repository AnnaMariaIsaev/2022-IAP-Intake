// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Intake extends SubsystemBase 
{
  private final WPI_TalonSRX rightFlyWheelTalon;
  private final WPI_TalonSRX leftFlyWheelTalon;

  public Intake() 
  {
    rightFlyWheelTalon = new WPI_TalonSRX(Constants.IntakePorts.rightFlyhweel);
    leftFlyWheelTalon = new WPI_TalonSRX(Constants.IntakePorts.leftFlywheel);

    rightFlyWheelTalon.setInverted(true); 
    leftFlyWheelTalon.setInverted(false);

    leftFlyWheelTalon.configFactoryDefault();
    rightFlyWheelTalon.configFactoryDefault();
  }

  public void setFlywheelPower(double speed) 
  {
    leftFlyWheelTalon.set(ControlMode.PercentOutput, speed);
    rightFlyWheelTalon.set(ControlMode.PercentOutput, speed);
  }
  
  public double getCurrent()
  {
    return leftFlyWheelTalon.getStatorCurrent();
  }
       
  @Override
  public void periodic() 
  {

  }
}

