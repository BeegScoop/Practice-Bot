// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.DriveCom;
import frc.robot.subsystems.DriveTrainSub;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import java.util.function.Supplier;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  
  private final DriveTrainSub m_DriveTrainSub = new DriveTrainSub();

  private final Joystick stick = new Joystick(0);
  private final SendableChooser<String> m_chooser;

  public static final String defaultAutoTxt = "Default Auto";

  
  public RobotContainer() {
    m_chooser = new SendableChooser<>();
    m_chooser.addOption(defaultAutoTxt, defaultAutoTxt);

    SmartDashboard.putData("Auto Choices", m_chooser);

    m_DriveTrainSub.setDefaultCommand(new DriveCom(m_DriveTrainSub, ()-> driveStick.getRawAxis(1)*0.25, ()-> stick.getRawAxis(2)*0.25));

    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    

    // m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

 
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    
    switch(m_chooser.getSelected()){
      case "Default Auto":
        return Autos.defaultAuto(m_DriveTrainSub);
    default:
       return Autos.defaultAuto(m_DriveTrainSub);

  }
}
}