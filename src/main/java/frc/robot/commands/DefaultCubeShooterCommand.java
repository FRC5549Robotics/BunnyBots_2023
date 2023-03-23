// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CubeShooter;
<<<<<<< HEAD
import frc.robot.subsystems.Tower;
=======
import edu.wpi.first.math.controller.PIDController;
>>>>>>> 8738d93b0f8a8854db25c8ebcb9b039ea95fe3db

public class DefaultCubeShooterCommand extends CommandBase {
  /** Creates a new DefaultCubeShooterCommand. */
  private XboxController m_controller;
  private CubeShooter m_CubeShooter;
<<<<<<< HEAD
  private 

=======
  double TowerEncoderValue;
  double HingeEncoderValue;
  PIDController controller = new PIDController(0.01, 0, 0);
>>>>>>> 8738d93b0f8a8854db25c8ebcb9b039ea95fe3db

  public DefaultCubeShooterCommand(CubeShooter cubeShooter, XboxController m_Controller, Tower tower) {
    m_controller = m_Controller;
    m_CubeShooter = cubeShooter;
    addRequirements(cubeShooter);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    TowerEncoderValue = m_CubeShooter.getTowerEncoderValue();
    HingeEncoderValue = m_CubeShooter.GetEncoderValue();
    
    //Intake the cube speed: -0.125
    if(m_controller.getRawButton(5))
    {
      m_CubeShooter.setSpeed(-0.125);
      System.out.println("yes");
    }

    //Outtake speed High
    else if(m_controller.getRawButton(2) && m_controller.getRawAxis(3) > 0.1)
    {
      m_CubeShooter.setSpeed(1);
    }

    //Outtake speed Mid.
    else if(m_controller.getRawButton(1) && m_controller.getRawAxis(3) > 0.1)
    {
      m_CubeShooter.setSpeed(0.7);
    }


    else
    {
      m_CubeShooter.setSpeed(0);
    }



    if(m_controller.getRawAxis(2) > 0.1)
    { 
      m_CubeShooter.RunHinge(m_controller.getRawAxis(2)/5);
    }
    else if(m_controller.getRawAxis(3) > 0.1)
    {
      m_CubeShooter.RunHinge(-m_controller.getRawAxis(3)/5);
    } else {
        m_CubeShooter.HingeOff();
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_CubeShooter.HingeOff();
    m_CubeShooter.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
