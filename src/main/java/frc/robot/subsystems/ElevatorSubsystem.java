// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ElevatorConstants;

public class ElevatorSubsystem extends SubsystemBase {

  private final CANSparkMax m_motorElevatorLeft = new CANSparkMax(ElevatorConstants.leftMotorID, MotorType.kBrushless);
  private final CANSparkMax m_motorElevatorRight = new CANSparkMax(ElevatorConstants.rightMotorID, MotorType.kBrushless);
  private final DigitalInput leftUpLimitSwitch = new DigitalInput(ElevatorConstants.leftUpChannel);
  private final DigitalInput leftDownLimitSwitch = new DigitalInput(ElevatorConstants.leftDownChannel);
  private final DigitalInput rightUpLimitSwitch = new DigitalInput(ElevatorConstants.rightUpChannel);
  private final DigitalInput rightDownLimitSwitch = new DigitalInput(ElevatorConstants.rightDownChannel);

  /** Creates a new ElevatorSubsystem. */
  public ElevatorSubsystem() {
    m_motorElevatorLeft.setInverted(false);
    m_motorElevatorRight.follow(m_motorElevatorLeft);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void elevatorRun(double speed){
    m_motorElevatorLeft.set(speed);
  }
  
  public void elevatorstop(){
    m_motorElevatorLeft.set(0);
  }

  public boolean getLeftUpLimit(){
    return leftUpLimitSwitch.get();
  }

  public boolean getLeftDownLimit(){
    return leftDownLimitSwitch.get();
  }

  public boolean getRightUpLimit(){
    return rightUpLimitSwitch.get();
  }

  public boolean getRightDownLimit(){
    return rightDownLimitSwitch.get();
  }
}
