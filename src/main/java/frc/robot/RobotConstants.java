// https://docs.wpilib.org/en/stable/docs/software/basic-programming/java-units.html

package frc.robot;


import static edu.wpi.first.units.Units.*;

import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.units.measure.LinearVelocity;

public final class RobotConstants {

  // The purpose of the build. Development means all data is logged. Testing means "important" data is logged. Competition is for competition.
  public static enum BuildMode {
    DEVELOPMENT, TESTING, COMPETITION
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
  }
}
