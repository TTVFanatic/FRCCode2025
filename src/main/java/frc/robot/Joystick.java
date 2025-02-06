package frc.robot;

public class Joystick extends edu.wpi.first.wpilibj.Joystick {
    public Joystick(int port) {
        super(port);
    }

    public static double leftDeadZone = 0.1;
    public static double rightDeadZone = 0.1;

    public double getXAxis() {
        return applyDeadzone(super.getX(), leftDeadZone);
    }

    public double getYAxis() {
        return applyDeadzone(super.getY(), leftDeadZone);
    }

    public static double applyDeadzone(double value, double deadzone) {
        if(value < deadzone && value > -deadzone)
            value = 0.0;
        return value;
    }

    public double getBetterThrottle() {
        return (super.getThrottle() * -1 + 1) / 2;
    }
}
