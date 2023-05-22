package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanIdConstants;

public class Shooter extends SubsystemBase{
  private final WPI_TalonSRX m_shooter = new WPI_TalonSRX(CanIdConstants.SHOOTER_MASTER_ID);

  public Shooter() {
    m_shooter.configOpenloopRamp(0.5);
    m_shooter.setInverted(false);
    m_shooter.setNeutralMode(NeutralMode.Brake);
  }
   
  public void setShooterSpeed(double speed) {
    m_shooter.set(ControlMode.PercentOutput, speed);
  }
}
