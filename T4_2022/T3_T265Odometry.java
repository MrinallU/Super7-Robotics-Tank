package org.firstinspires.ftc.teamcode.T4_2022;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Utils.Point;

public class T3_T265Odometry {
    // Motors
    public String outStr = "";


    // Variables
    private double xPos, yPos, angle;
    private HardwareMap hardwareMap;

    private double cX = 0, cY = 0, cAng = 0;
    private double xAdj = 0, yAdj = 0, angAdj = 0;
    private boolean positionAdjusted = false;

//    private T265Camera.CameraUpdate update;
//    private static T265Camera slamara;

    public T3_T265Odometry(double xPos, double yPos, double angle, HardwareMap hardwareMap) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.angle = angle;
        this.hardwareMap = hardwareMap;
    }

    public T3_T265Odometry(double angle, HardwareMap hardwareMap) {
        this.xPos = 0;
        this.yPos = 0;
        this.angle = angle;
        this.hardwareMap = hardwareMap;
    }

    public T3_T265Odometry(HardwareMap hardwareMap) {
        this(0, hardwareMap);
    }

    public void setAdjustments(){
        xAdj = -cX + xPos;
        yAdj = -cY + yPos;
        angAdj = -cAng + angle;
    }

    private void setCurrents(){
//        Translation2d translation = new Translation2d(update.pose.getTranslation().getX() / 0.0254, update.pose.getTranslation().getY() / 0.0254);
//
//        cX = translation.getX();
//        cY = translation.getY();
//        cAng = update.pose.getRotation().getDegrees();
    }

    public void initializeT265(){
//        String logMessage = "Failure";
//        int attempts = Integer.MAX_VALUE;
//
//        while(attempts > 0) {
//            if (slamara == null) {
//                slamara = new T265Camera(new Transform2d(), 1, hardwareMap.appContext);
//            }
//
//            try {
//                slamara.start();
//            } catch (Exception e) {
//                if (e.getMessage().toString().equals("Camera is already started")) {
//                    logMessage = "Success!";
//                    break;
//                } else {
//                    throw new RuntimeException(e.getMessage());
//                }
//            }
//
//            --attempts;
//        }
//
//        Pose2d startPos = new Pose2d(new Translation2d(xPos * 0.0254, yPos * 0.0254), new Rotation2d(0));
//        slamara.setPose(startPos);
    }
//
//    public void startT265(){
//        slamara.start();
//    }
//
//    public void stopT265(){
//        slamara.stop();
////        slamara.free();
//    }

    public void updatePosition() {
//        update = slamara.getLastReceivedCameraUpdate();
//
//        if(update != null){
//            setCurrents();
//
//            if(!positionAdjusted){
//                positionAdjusted = true;
//                setAdjustments();
//            }
//
//            xPos = cX + xAdj;
//            yPos = cY + yAdj;
//            angle = normalizeAngle(cAng + angAdj);
//
//            // Set string so values can be passed to telemetry
//            outStr = "xPos: " + format(xPos) + "\nyPos: " + format(yPos) + "\nAngle: " + format(angle);
//        }
    }

    public double normalizeAngle(double rawAngle) {
        double scaledAngle = rawAngle % 360;
        if ( scaledAngle < 0 ) {
            scaledAngle += 360;
        }

        if ( scaledAngle > 180 ) {
            scaledAngle -= 360;
        }

        return scaledAngle;
    }

    public String displayPositions() {
        return outStr;
    }

    public double getAngle() {
        return angle;
    }

    public double getX() {
        return xPos;
    }

    public double getY() {
        return yPos;
    }

    public void resetOdometry(){
        resetOdometry(0, 0, 0);
    }

    public void resetOdometry(Point p){
        resetOdometry(p.xP, p.yP, p.ang);
    }

    public void resetOdometry(double xPos, double yPos, double angle){
        this.xPos = xPos;
        this.yPos = yPos;
        this.angle = angle;
    }

    public void setAngle(double angle){
        this.angle = angle;
    }

    private String format(double num){
        return String.format("%.3f", num);
    }
}