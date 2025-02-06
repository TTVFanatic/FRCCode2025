package frc.robot;

import com.studica.frc.AHRS;

public class TobyAHRS extends AHRS {
    public TobyAHRS(NavXComType comType) {
        super(comType);
    }


    public double getAngle() {
        return super.getYaw() / -1;
    }
}
