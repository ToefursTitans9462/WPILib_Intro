package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Autos;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class IOdevices {
  
  IOdevices() {

    // Add the autos to the chooser
    autoSelector.setDefaultOption(Autos.frontTestingAuto, Autos.frontTestingAuto);
    autoSelector.addOption(Autos.backTestingAuto, Autos.backTestingAuto);
    autoSelector.addOption(Autos.doNothingAuto, Autos.doNothingAuto);
    autoSelector.addOption(Autos.doubleTestingAuto, Autos.doubleTestingAuto);
    SmartDashboard.putData("Auto choices", autoSelector);


    // Invert the the motors so they move in the correct direction when "positive" voltate is applied.
    frontRightMotor.setInverted(true);
    backRightMotor.setInverted(true);

    // Group the motors on each side
    frontLeftMotor.addFollower(backLeftMotor);
    frontRightMotor.addFollower(backRightMotor);

    
  }
  
  // Drive motors
  public static final PWMVictorSPX frontRightMotor = new PWMVictorSPX(1);
  public static final PWMVictorSPX frontLeftMotor = new PWMVictorSPX(0);
  public static final PWMVictorSPX backRightMotor = new PWMVictorSPX(2);
  public static final PWMVictorSPX backLeftMotor = new PWMVictorSPX(3);

  // Human Input
  public static final XboxController controller1 = new XboxController(0);

  public static final SendableChooser<String> autoSelector = new SendableChooser<>();
  
  public static final DifferentialDrive drive = new DifferentialDrive(frontLeftMotor, frontRightMotor);

}
