package org.firstinspires.ftc.teamcode.T3_2022.Autonomous;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.T2_2022.Modules.T2_Camera;
import org.firstinspires.ftc.teamcode.T3_2022.Modules.T3_Camera;
import org.firstinspires.ftc.teamcode.T3_2022.T3_Base;

@Autonomous(name="T3_Primary_Blue_Autonomous", group = "Autonomous")
public class T3_Primary_Blue_Autonomous extends T3_Base{
    int pos = 0;
    String elementDiagram = "";

    @Override
    public void runOpMode() throws InterruptedException {
        init(0);
        initServosAuto();
        T3_Camera camera = new T3_Camera(hardwareMap);
        sleep(1000);
        initOdometry();

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();


        odometry.updatePosition();

        pos = camera.readBarcode("bluePrimary");


        if (pos == 0) {
            telemetry.addData("Wobble Level: ", "Bottom");
            telemetry.addData("Shipping Element Placement: ", "☒ ☐ ☐");
            elementDiagram = "☒ ☐ ☐";
            telemetry.update();
        } else if (pos == 1) {
            telemetry.addData("Wobble Level: ", "Middle");
            telemetry.addData("Shipping Element Placement: ", "☐ ☒ ☐");
            elementDiagram = "☐ ☒ ☐";
            telemetry.update();
        } else if (pos == 2) {
            telemetry.addData("Wobble Level: ", "Top");
            telemetry.addData("Shipping Element Placement: ", "☐ ☐ ☒");
            elementDiagram = "☐ ☐ ☒";
            telemetry.update();
        }

        arm.moveToPosition(300);

        telemetry.addData("Shipping Element Placement: ", elementDiagram);
        telemetry.addLine("Ang: " + getAngle());
        telemetry.addLine("Pos: " + odometry.outStr);
        telemetry.update();

        moveTicksBack(500, 4000, 0.4, 20, this);
        sleep(500);
        turnToV2(93, 4000, this);
        sleep(500);

        pos = 2;

        if(pos == 0){
            arm.moveBottom();
            sleep(1500);
            moveTicksBack(490, 4000, 0.4, 20, this);
        }else if(pos == 1){
            arm.moveMid();
            sleep(1500);
            moveTicksBack(550, 4000, 0.4, 20, this);

        }else{
            arm.moveTop();
            sleep(1500);
            moveTicksBack(550, 4000, 0.4, 20, this);
        }



        sleep(500);
        arm.dump();
        sleep(500);


        //600
        moveTicksFront(550, 4000, 0.4, 20, this);
        container.dumpBlock();
        sleep(500);
        arm.moveToPosition(300);
        sleep(500);

        turnToV2(180, 4000, this);
        sleep(500);

        moveTicksBack(200, 3000, 0.4, 20, this);

        turnToV2(-92, 4000, this);
        sleep(500);

        moveTicksBack(975, 6000, 0.2, 20, this);
        sleep(500);

        startBlueCarousel();
        sleep(3000);
        stopCarousel();

        //manouver to avoid driving over capstone
        moveTicksFront(200, 4000, 0.4, 20, this); 
        sleep(500);

        turnToV2(-35, 4000, this);

        moveTicksBack(1000, 4000, 0.4, 20, this);
        sleep(500);
    }
}