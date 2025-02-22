package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;

public class Constants {
    public static final class DriveConstants {
        public static final double kMaxSpeedMetersPerSecond = 4.8;
        public static final double kMaxAngularSpeed = 2 * Math.PI;
        public static final double kMaxAccelerationMetersPerSecondSquared = 0.5;

        public static final double kTrackWidth = Units.inchesToMeters(23.45);
        public static final double kWheelBase = Units.inchesToMeters(28.45);
        
        public static final SwerveDriveKinematics kDriveKinematics = new SwerveDriveKinematics(
            new Translation2d(kWheelBase / 2, kTrackWidth / 2),
            new Translation2d(kWheelBase / 2, -kTrackWidth / 2),
            new Translation2d(-kWheelBase / 2, kTrackWidth / 2),
            new Translation2d(-kWheelBase / 2, -kTrackWidth / 2)
        );

        public static final double kFrontLeftChassisAngularOffset = -Math.PI / 2;
        public static final double kFrontRightChassisAngularOffset = 0;
        public static final double kBackLeftChassisAngularOffset = Math.PI;
        public static final double kBackRightChassisAngularOffset = Math.PI / 2;

        public static final int kFrontLeftDrivingCanId = 6;
        public static final int kFrontRightDrivingCanId = 4;
        public static final int kRearLeftDrivingCanId = 8;
        public static final int kRearRightDrivingCanId = 2;

        public static final int kFrontLeftTurningCanId = 7;
        public static final int kFrontRightTurningCanId = 5;
        public static final int kRearLeftTurningCanId = 9;
        public static final int kRearRightTurningCanId = 3;

        public static final boolean kGyroReversed = false;
    }

    public static final class ModuleConstants {
        public static final int kDrivingMotorPinionTeeth = 14;

        public static final double kDrivingMotorFreeSpeedRps = NeoMotorConstants.kFreeSpeedRpm / 60;
        public static final double kWheelDiameterMeters = 0.0762;
        public static final double kWheelCircumferenceMeters = kWheelDiameterMeters * Math.PI;

        public static final double kDrivingMotorReduction = (45.0 * 22) / (kDrivingMotorPinionTeeth * 15);
        public static final double kDriveWheelFreeSpeedRps = (kDrivingMotorFreeSpeedRps * kWheelCircumferenceMeters)
            / kDrivingMotorReduction;
    }

    public static final class OperatorConstants {
        public static final int driverControllerPort = 0;
        public static final int shooterControllerPort = 1;
        public static final double driveDeadband = 0.05;
    }

    public static final class NeoMotorConstants {
        public static final double kFreeSpeedRpm = 5676;
    }

    public static final class AlgaeScoringConstants {
        public static final int VictorSPXAlgaeCanId = 10;
        public static final int VictorSPXCimAlgaeCanId = 1;
    }

    public static final class ElevatorConstants {
        // Creating the variables for the elevator subsystem
        // The CAN ID for the elevators motor controller
        public static final int elevatorCanId = 11;
        // Setting the elevator start height (0)
        public static final int elevatorStartHeight = 0; // start height of elevator to the robot
        // Creating and setting the number of rotations it takes to get to each extension
        // level with a 15:1 gear box ratio
        public static final int reefLevelOneHeightRotations = 0 / 15; // "0" is a placeholder
        public static final int reefLevelTwoHeightRotations = 0 / 15; // "0" is a placeholder
        public static final int reefLevelThreeHeightRotations = 0 / 15; // "0" is a placeholder
        public static final int reefLevelFourHeightRotations = 0 / 15; // "0" is a placeholder
        
        public static final int kPositionConversionFactor = 1;
        public static final int kVelocityConversionFactor = 1;
    }

    public static final class LiftConstants {
        // Setting the CAN ID's for the winch and the hook for the hanging mechanism
        public static final int winchSPXCanId = 12; // "0" is a placeholder
        public static final int HookMAXCanId = 13; // "0" is a placeholder
    }
}
