// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Telescope;
import frc.robot.Constants;

public class ExtendMedium extends CommandBase {
  /** Creates a new ExtendFar. */

  double startTime;
  Telescope m_Telescope;
  boolean finished = false;
  public ExtendMedium(Telescope Telescope) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_Telescope = Telescope;
    addRequirements(Telescope);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = System.currentTimeMillis();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    while (System.currentTimeMillis() - startTime < 4000) {
      m_Telescope.on(Constants.armSpeed);
    }
    finished = true;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Telescope.off();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
