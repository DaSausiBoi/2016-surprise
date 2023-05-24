package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import frc.robot.Constants.UsbConstants;
import frc.robot.commands.IntakeInCommand;
import frc.robot.commands.IntakeOutCommand;
import frc.robot.commands.ShootCommand;
import frc.robot.commands.drivetrain.SetDrivetrain;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
public class RobotContainer {
    //subsystems
    private final Drivetrain m_drivetrain = new Drivetrain();
    private final Intake m_intake = new Intake();
    private final Shooter m_shooter = new Shooter();

    //commands
    private final IntakeInCommand intakeIn = new IntakeInCommand(m_intake);
    private final IntakeOutCommand intakeOut = new IntakeOutCommand(m_intake);
    private final ShootCommand shootCommand = new ShootCommand(m_shooter);

    private final CommandXboxController driverController = new CommandXboxController(UsbConstants.DRIVER_CONTROLLER_PORT);
    private final CommandXboxController driverController2 = new CommandXboxController(UsbConstants.AUXDRIVER_CONTROLLER_PORT);

    public void initializeSubsystems() {
      // add negative (-) to getLeftY to invert drive
      m_drivetrain.setDefaultCommand(
        new SetDrivetrain(
          m_drivetrain, 
          () -> driverController.getRightX(), 
          () -> -driverController.getLeftY()));
    }

    public RobotContainer() {
        configureButtonBindings();
        initializeSubsystems();
      }

    private void configureButtonBindings() {
      driverController2.a().whileTrue(intakeIn);
      driverController2.y().whileTrue(intakeOut);

      driverController.rightBumper().whileTrue(shootCommand);
    }
}
