package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanIdConstants;

public class Intake extends SubsystemBase{
  private final WPI_TalonSRX m_intake = new WPI_TalonSRX(CanIdConstants.INTAKE_MASTER_ID);

  public Intake(){
    m_intake.configOpenloopRamp(0.5);
    m_intake.setInverted(false);
    m_intake.setNeutralMode(NeutralMode.Brake);
   } 
   
   public void setIntakeSpeed(double speed) {
    m_intake.set(ControlMode.PercentOutput, speed);
   } 
}
