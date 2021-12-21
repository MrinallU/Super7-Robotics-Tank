package org.firstinspires.ftc.teamcode.T4_2022;

import org.firstinspires.ftc.teamcode.Utils.Motor;

public class T3_Intake {
    Motor sweeper;

    double sweepPower = -1;

    public T3_Intake(Motor sweeper){
        this.sweeper = sweeper;
        setSweepPID();
    }

    public void setSweeperPower(double power){
        sweeper.setPower(power);
    }

    public void dump(){ sweeper.setPower(sweepPower * -1); }

    public void sweep(){ sweeper.setPower(sweepPower); }

    public void stop(){
        sweeper.setPower(0);
    }

    public void setSweepPID(){
//        double f = 32767.0/2986.0;
//        sweeper.retMotorEx().setVelocityPIDFCoefficients(f * 0.1, f * 0.1 * 0.1, 0, f);
    }
}