// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.math.controller.PIDController;
import frc.robot.Constants;

public class Telescope extends SubsystemBase {
  /** Creates a new Telescope. */
  CANSparkMax motor1;
  PIDController pid = new PIDController(Constants.kP, Constants.kI, Constants.kD);
  public Telescope() {
    motor1 = new CANSparkMax(68, MotorType.kBrushless);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }

  public void on(double speed) {
    motor1.set(speed);
  }

  public void off() {
    motor1.set(0);
  }
}
