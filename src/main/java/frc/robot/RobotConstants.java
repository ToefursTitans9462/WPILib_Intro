// https://docs.wpilib.org/en/stable/docs/software/basic-programming/java-units.html

package frc.robot;


import static edu.wpi.first.units.Units.*;

import edu.wpi.first.units.AngleUnit;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.units.measure.LinearVelocity;

public final class RobotConstants {

  // This not not a singleton because typing lots of "static"s here is better than typing "RobotConstants.instance().SUBCLASS.CONSTANT" every time everywhere else.

  public enum BuildMode {
    TESTING, COMPETITION
  }

  /** Contains the physical dimensions of the robot. NOT YET VERIFIED */
  public static final class Sizes {

    public static final Distance WHEEL_DIAMETER = Inches.of(5); 
    public static final Distance WHEEL_CIRCUMFERANCE = WHEEL_DIAMETER.times(Math.PI);
    public static final Distance DRIVEBASE_WIDTH = Inches.of(20);
    public static final Distance DRIVEBASE_LENGTH = Inches.of(20);

    public static final Distance BUMPER_WIDTH = Inches.of(25);
    public static final Distance BUMPER_LENGTH = Inches.of(27);
  }

  public static final class Drivetrain {

    public static final LinearVelocity MAX_VELOCITY = Meters.of(1).per(Second);
    /** The maximum motor-power percentage */
    public static final float MAX_MOTOR_VOLTAGE = 1.0f;

    public static final AngularVelocity MAX_ANGULAR_VELOCITY = Degrees.of(10).per(Second);
    /** How sensitive the turning is */
    public static final float TURN_SENSITIVITY = 0.6f;

    public static final float GEAR_RATIO = 0.5f;

    /** This is the distance the robot will move per degree of motor rotation */
    public static final Distance DISTANCE_PER_DEGREE = Sizes.WHEEL_CIRCUMFERANCE.times(GEAR_RATIO).div(360f);

    // The maximum speed of the motors 
    public static final AngularVelocity MAX_MOTOR_RPS = RotationsPerSecond.of(2);

    // public static final LinearVelocity MAX_ROBOT_VELOCITY = Sizes.WHEEL_CIRCUMFERANCE.div(Seconds.of(1)).times(MAX_MOTOR_RPS)

  }
}