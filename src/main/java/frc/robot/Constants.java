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

    public static final int FRONT_LEFT_MODULE_DRIVE_MOTOR = 8; 
    public static final int FRONT_LEFT_MODULE_STEER_MOTOR = 7;
    public static final int FRONT_LEFT_MODULE_STEER_ENCODER = 10; 
    public static final double FRONT_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(103.01);//-Math.toRadians(58.89); 

    public static final int FRONT_RIGHT_MODULE_DRIVE_MOTOR = 6; 
    public static final int FRONT_RIGHT_MODULE_STEER_MOTOR = 5;
    public static final int FRONT_RIGHT_MODULE_STEER_ENCODER = 11; 
    public static final double FRONT_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(293.99);//-Math.toRadians(249.17); 

    public static final int BACK_LEFT_MODULE_DRIVE_MOTOR = 2; 
    public static final int BACK_LEFT_MODULE_STEER_MOTOR = 1; 
    public static final int BACK_LEFT_MODULE_STEER_ENCODER = 12; 
    public static final double BACK_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(100);//-Math.toRadians(264.11); 

    public static final int BACK_RIGHT_MODULE_DRIVE_MOTOR = 4; 
    public static final int BACK_RIGHT_MODULE_STEER_MOTOR = 3; 
    public static final int BACK_RIGHT_MODULE_STEER_ENCODER = 13; 
    public static final double BACK_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(200);//-Math.toRadians(137.55); 

    public static double INITIAL_HEADING;   
    public static double POLE_DISTANCE = 39.75;

    // Indexer
    public static final int INDEXER_MOTOR = 20;
    //TBD
    public static final int INDEXER_SPEED = 1;
    public static final int INDEXER_BUTTON = 2;

    //Shintake
    public static final int SHINTAKE_MOTOR = 21;
    public static final double kP = 0.46416;
    public static final double kI = 0;
    public static final double kD = 0;
    public static final double kS = 0.020963;
    public static final double kV = 0.18825;
    public static final double kA = 0.013596;
    public static final double tP = 1/27;
    public static final int SHOOT_TRIGGER = 2;
    public static final int INTAKE_BUTTON = 3;
    public static final int SHOOT_BUTTON = 4;
    public static final int INDEX_OUT = 1;

    //Shooter Solenoids
    public static final int SHOOTER_SOLENOID_FORWARD = 6;
    public static final int SHOOTER_SOLENOID_REVERSE = 7;
    public static final int PNEUMATIC_BUTTON  = 8;

    //ultrasonic ports
    public static final int ULTRASONIC_PING = 1;
    public static final int ULTRASONIC_ECHO = 0;

    //LED 
    public static final int LED_PORT = 1;
    //TBD
    public static final double SHINTAKE_SPEED = 0.75;
}