package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Autos;

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

  }
  
  // Drive motors
  public final PWMVictorSPX frontRightMotor = new PWMVictorSPX(1);
  public final PWMVictorSPX frontLeftMotor = new PWMVictorSPX(0);
  public final PWMVictorSPX backRightMotor = new PWMVictorSPX(2);
  public final PWMVictorSPX backLeftMotor = new PWMVictorSPX(3);

  // Human Input
  public final XboxController controleler1 = new XboxController(0);

  public final SendableChooser<String> autoSelector = new SendableChooser<>();

}
