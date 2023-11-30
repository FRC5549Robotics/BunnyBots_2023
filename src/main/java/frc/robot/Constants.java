// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform2d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;
//DONT ENABLE
/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    /**
     * The left-to-right distance between the drivetrain wheels
     *
     * Should be measured from center to center.
     */
    public static final double DRIVETRAIN_TRACKWIDTH_METERS = 0.56515;
    /**
     * The front-to-back distance between the drivetrain wheels.
     *
     * Should be measured from center to center.
     */
    public static final double DRIVETRAIN_WHEELBASE_METERS = 0.56515;

    public static final int FRONT_LEFT_MODULE_DRIVE_MOTOR = 4;
    public static final int FRONT_LEFT_MODULE_STEER_MOTOR = 3;
    public static final int FRONT_LEFT_MODULE_STEER_ENCODER = 9;
    public static final double FRONT_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(182.20);//-Math.toRadians(2.64);

    public static final int FRONT_RIGHT_MODULE_DRIVE_MOTOR = 6;
    public static final int FRONT_RIGHT_MODULE_STEER_MOTOR = 5;
    public static final int FRONT_RIGHT_MODULE_STEER_ENCODER = 11;
    public static final double FRONT_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(293.47);//-Math.toRadians(204.08);

    public static final int BACK_LEFT_MODULE_DRIVE_MOTOR = 2;
    public static final int BACK_LEFT_MODULE_STEER_MOTOR = 1;
    public static final int BACK_LEFT_MODULE_STEER_ENCODER = 10;
    public static final double BACK_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(308.94);//-Math.toRadians(309.64);

    public static final int BACK_RIGHT_MODULE_DRIVE_MOTOR = 8;
    public static final int BACK_RIGHT_MODULE_STEER_MOTOR = 7;
    public static final int BACK_RIGHT_MODULE_STEER_ENCODER = 12;
    public static final double BACK_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(103.80);//-Math.toRadians(13.97);


    public static double INITIAL_HEADING;
    public static double POLE_DISTANCE = 39.75;

    // Indexer
    public static final int INDEXER_MOTOR = 11;
    //TBD
    public static final int INDEXER_SPEED = 1;
    public static final int INDEXER_BUTTON = 1;

    //Shintake
    public static final int SHINTAKE_MOTOR = 12;
    public static final double kP = 0.46416;
    public static final double kI = 0;
    public static final double kD = 0;
    public static final double kS = 0.020963;
    public static final double kV = 0.18825;
    public static final double kA = 0.013596;
    public static final double tP = 1/27;

    //Shooter Solenoids
    public static final int RIGHT_SHOOTER_SOLENOID_FORWARD = 1;
    public static final int LEFT_SHOOTER_SOLENOID_FORWARD = 6;
    public static final int RIGHT_SHOOTER_SOLENOID_REVERSE = 0;
    public static final int LEFT_SHOOTER_SOLENOID_REVERSE = 7;
    //TBD
    public static final int SHINTAKE_SPEED = 1;
}