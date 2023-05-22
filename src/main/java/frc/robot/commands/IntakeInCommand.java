package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Intake;

public class IntakeInCommand extends CommandBase{
    Intake Intake;

    public IntakeInCommand(Intake Intake) {
        this.Intake = Intake;
        addRequirements(Intake);
    }

    @Override
    public void execute() {
        Intake.setIntakeSpeed(0.35);
    }

    @Override
    public void end(boolean interrupted) {
        Intake.setIntakeSpeed(0);
    }
}
