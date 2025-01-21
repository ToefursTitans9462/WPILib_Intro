package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import java.util.function.DoubleSupplier;

public class TeleopDriveCommand extends Command {
  // Fields
  private Drivetrain m_drivetrain;
  // Inputs. These allow for lambdas to be passed into the constructor
  private DoubleSupplier m_speed;
  private DoubleSupplier m_turn;


  // This is supposed to be used as a command
  public TeleopDriveCommand (Drivetrain drivetrain, DoubleSupplier speed, DoubleSupplier turn) {
    m_drivetrain = drivetrain;
    // Add this drivetrain as a requirement for the command
    addRequirements(drivetrain);

    m_speed = speed;
    m_turn = turn;
  }

  @Override
  public void execute() {
    double exSpeed = m_speed.getAsDouble();
    double exTurn = m_turn.getAsDouble();


    // Get the values

    // Square or cube inputs for finer control

    // Limit inputs so that the motors aren't told to go from 0 to 100 in a fraction of a second. Should improve lifetime

    // Drive
    m_drivetrain.drive(exSpeed, exTurn);
  }
}
