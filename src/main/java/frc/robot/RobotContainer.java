// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.DefaultDriveCommand;
import frc.robot.commands.AutoAlign;
import frc.robot.commands.AutoStable;
import frc.robot.commands.RunIntake;
import frc.robot.commands.AutonCommands.TwoConeAuto;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Telescope;
import frc.robot.subsystems.Tower;

import com.pathplanner.lib.PathConstraints;
import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathPlannerTrajectory;

import frc.robot.subsystems.Limelight;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DrivetrainSubsystem m_drivetrainSubsystem = new DrivetrainSubsystem();
  private final Limelight m_Limelight = new Limelight();
  private final Intake m_Intake = new Intake();
  private final Telescope m_telescope = new Telescope();
  private final Tower m_tower = new Tower();

  private final XboxController m_controller = new XboxController(0);
  PathPlannerTrajectory TopToCone = PathPlanner.loadPath("TopToCone", new PathConstraints(4, 3));
  PathPlannerTrajectory TopBackToCone = PathPlanner.loadPath("TopBackToCone", new PathConstraints(4, 3));
  PathPlannerTrajectory MidToCone = PathPlanner.loadPath("MidToCone", new PathConstraints(4, 3));
  PathPlannerTrajectory MidBackToCone = PathPlanner.loadPath("MidBackToCone", new PathConstraints(4, 3));
  PathPlannerTrajectory BotToCone = PathPlanner.loadPath("BotToCone", new PathConstraints(4, 3));
  PathPlannerTrajectory BotBackToCone = PathPlanner.loadPath("BotBackToCone", new PathConstraints(4, 3));
  JoystickButton autoAlignButton = new JoystickButton(m_controller, 1);
  JoystickButton autoStableButton = new JoystickButton(m_controller, 2);
  JoystickButton runIntake = new JoystickButton(m_controller, 3);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Set up the default command for the drivetrain.
    // The controls are for field-oriented driving:
    // Left stick Y axis -> forward and backwards movement
    // Left stick X axis -> left and right movement
    // Right stick X axis -> rotation
    m_drivetrainSubsystem.setDefaultCommand(new DefaultDriveCommand(
            m_drivetrainSubsystem,
            () -> -modifyAxis(m_controller.getLeftY()) * DrivetrainSubsystem.MAX_VELOCITY_METERS_PER_SECOND,
            () -> -modifyAxis(m_controller.getLeftX()) * DrivetrainSubsystem.MAX_VELOCITY_METERS_PER_SECOND,
            () -> -modifyAxis(m_controller.getRightX() * 0.75) * DrivetrainSubsystem.MAX_ANGULAR_VELOCITY_RADIANS_PER_SECOND
    ));

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Back button zeros the gyroscope
    new Trigger(m_controller::getBackButton)
            // No requirements because we don't need to interrupt anything
            .onTrue(new RunCommand(m_drivetrainSubsystem::zeroGyroscope));
    autoAlignButton.onTrue(new AutoAlign(m_Limelight, m_drivetrainSubsystem));
    autoStableButton.onTrue(new AutoStable(m_drivetrainSubsystem));
    runIntake.onTrue(new RunIntake(m_Intake));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new TwoConeAuto(m_drivetrainSubsystem, m_Intake, m_telescope, m_tower, m_Limelight, TopToCone, TopBackToCone, MidToCone, MidBackToCone, BotToCone, BotBackToCone, 1);
  }

  private static double deadband(double value, double deadband) {
    if (Math.abs(value) > deadband) {
      if (value > 0.0) {
        return (value - deadband) / (1.0 - deadband);
      } else {
        return (value + deadband) / (1.0 - deadband);
      }
    } else {
      return 0.0;
    }
  }

  private static double modifyAxis(double value) {
    // Deadband
    value = deadband(value, 0.08);

    // Square the axis
    value = Math.copySign(value * value, value);

    return value;
  }
}
