// https://docs.wpilib.org/en/stable/docs/software/basic-programming/java-units.html

package frc.robot;


import static edu.wpi.first.units.Units.*;

import edu.wpi.first.units.AngleUnit;
import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.units.measure.LinearVelocity;
import edu.wpi.first.units.measure.Current;

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

  //FIXME These constants are not verified. They are placeholders!
  public static final class Electrics {
    public static Voltage currentBatteryVoltage = Volts.of(0); 
    public static final Voltage MAX_MOTOR_CONSUMPTION = Volts.of(4);
    public static final Voltage PASSIVE_CONSUMPTION = Volts.of(1);
    public static final Voltage BROWNOUT_LIMIT = Volts.of(6.8);

    public static final Voltage NOMINAL_BATTERY_VOLTAGE = Volts.of(12.5);
    public static final Voltage MINIMUM_BATTERY_VOLTAGE = Volts.of(7.5); // Prevent brownout
    public static final Voltage BATTERY_VOLTAGE_DROP = Volts.of(1.5); // Estimated under load
    public static final Voltage TOTAL_SYSTEM_VOLTAGE_LIMIT = Volts.of(42); // PDP breaker limit

    public static final Current TOTAL_SYSTEM_CURRENT_LIMIT = Amps.of(120); // PDP breaker limit

    public static final Current MAX_DRIVETRAIN_CURRENT = Amps.of(40); // Total current available for drivetrain motors
    public static final Current MAX_MECHANISM_CURRENT = Amps.of(30); // Total current available for mechanisms (e.g., arms, elevators)
    public static final Current MAX_PASSIVE_CURRENT = Amps.of(10); // Current used by passive electronics (e.g., sensors, communication devices)
    public static final Current BROWNOUT_CURRENT_LIMIT = Amps.of(100); // Current at which brownout protection starts
    public static final Current NOMINAL_OPERATING_CURRENT = Amps.of(80); // Typical total current during normal operation

    // Current per motor (assumes identical motor specs)
    public static final Current MOTOR_MAX_CURRENT = Amps.of(20); // Current draw per motor during high load
    public static final Current MOTOR_NOMINAL_CURRENT = Amps.of(10); // Average motor current draw during operation

    // Allowances for circuit breakers
    public static final Current PDP_PORT_BREAKER_LIMIT = Amps.of(40); // Breaker limit per PDP port
    public static final Current PCM_CURRENT_LIMIT = Amps.of(20); // Current limit for PCM (pneumatics control module)
    public static final Current VRM_CURRENT_LIMIT = Amps.of(10); // Current limit for VRM (voltage regulator module)

    // Reserved current for unexpected spikes
    public static final Current CURRENT_RESERVE_MARGIN = Amps.of(10);
  }

}