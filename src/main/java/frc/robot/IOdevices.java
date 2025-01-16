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
    autoSelector.setDefaultOption(Autos.frontTesting, Autos.frontTesting);
    autoSelector.addOption(Autos.backTesting, Autos.backTesting);
    autoSelector.addOption(Autos.controllerTesting, Autos.controllerTesting);
    autoSelector.addOption(Autos.doubleTesting, Autos.doubleTesting);
    SmartDashboard.putData("Auto choices", autoSelector);


    // Invert the the motors so they move in the correct direction when "positive" voltate is applied.
    frontRightMotor.setInverted(true);
    backRightMotor.setInverted(true);

    // Group the motors on each side
    frontLeftMotor.addFollower(backLeftMotor);
    frontRightMotor.addFollower(backRightMotor);

    
  }
  
  // Drive motors
  public final PWMVictorSPX frontRightMotor = new PWMVictorSPX(1);
  public final PWMVictorSPX frontLeftMotor = new PWMVictorSPX(0);
  public final PWMVictorSPX backRightMotor = new PWMVictorSPX(2);
  public final PWMVictorSPX backLeftMotor = new PWMVictorSPX(3);

  // Human Input
  public final XboxController controller1 = new XboxController(0);

  public final SendableChooser<String> autoSelector = new SendableChooser<>();
  
  public final DifferentialDrive drive = new DifferentialDrive(frontLeftMotor, frontRightMotor);

}
