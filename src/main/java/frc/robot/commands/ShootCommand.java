package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Shooter;

public class ShootCommand extends CommandBase{
    Shooter Shooter;

    public ShootCommand(Shooter Shooter) {
        this.Shooter = Shooter;
        addRequirements(Shooter);
    }
    
    @Override
    public void execute() {
        Shooter.setShooterSpeed(-1);
    }

    @Override
    public void end(boolean interrupted) {
        Shooter.setShooterSpeed(0);
    }
}
