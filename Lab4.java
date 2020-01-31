public class Lab4
{
    public static void turnRight()
    {
        Robot.turnLeft();
        Robot.turnLeft();
        Robot.turnLeft();
    }

    public static void turnAround()
    {
        Robot.turnLeft();
        Robot.turnLeft();
    }

    public static void backUp()
    {
        turnAround();
        Robot.move();
        turnAround();
    }

    public static void darkenColumn()
    {
        //darkens one column until reaches end
        while(Robot.frontIsClear())
        {

            Robot.move();
            Robot.makeDark();
        }
    }

    public static void completeColumn()
    {
        //scans one column for shading, then shades it. 
        if(Robot.onDark())
        {
            turnRight();
            Robot.move();
            Robot.turnLeft();

        }
        while(Robot.frontIsClear())
        {
            Robot.move();
            if(Robot.onDark())
            {
                turnAround();
                darkenColumn();

            }
        }
        Robot.turnLeft();
        while(Robot.frontIsClear())
        {
            Robot.move();
            Robot.turnLeft();
            completeColumn();
        }

    }

    public static void completeBars()
    {
        Robot.turnLeft();
        completeColumn();

    }

    public static void testCompleteBars1()
    {
        Robot.load("bars1.txt");
        Robot.setDelay(0.025);
        completeBars();
    }

    public static void testCompleteBars2()
    {
        Robot.load("bars2.txt");
        Robot.setDelay(0.025);
        completeBars();
    }

    public static void makeLightandDark()
    {
        //finds dark tiles, then makes it light and adds a dark tile on right column
        while(Robot.frontIsClear())
        {
            Robot.move();
            if(Robot.onDark())
            {
                Robot.makeLight();
                turnRight();
                Robot.move();
                Robot.turnLeft();
                placeDarkReturn();

            }
        }
    }

    public static void placeDarkReturn()
    {
        // darkens the ride column by one square, and return to first column

        while(Robot.onDark())
        {
            Robot.move();
        }
        Robot.makeDark();
        turnAround();
        while(Robot.frontIsClear())
        {
            Robot.move();
        }
        turnRight();
        Robot.move();
        turnRight();
        makeLightandDark();
    }

    public static void combinePiles()
    {
        if(Robot.onDark())
        {
            Robot.makeLight();
            turnRight();
            Robot.move();
            Robot.turnLeft();
            placeDarkReturn();

        }
        makeLightandDark();

    }

    public static void testCombinePiles1()
    {
        Robot.load("piles1.txt");
        Robot.setDelay(0.025);
        combinePiles();
    }

    public static void testCombinePiles2()
    {
        Robot.load("piles2.txt");
        Robot.setDelay(0.025);
        combinePiles();
    }

    public static void connectDots()
    {
        while (Robot.onDark())
        {
            moveTwo();
            if (Robot.onDark())
            {
                darkenMiddleTile();
            }
            else
            {
                turnRightAndCheck();
                if (Robot.onDark())
                {
                    darkenMiddleTile();
                }
                else
                {
                    turnAroundAndCheck();
                    if (Robot.onDark())
                    {
                        darkenMiddleTile();   
                    }
                }
            }
        }

    }

    public static void darkenMiddleTile()
    {
        //makes tile before it dark, then returns to the previous tile.
        backUp();
        Robot.makeDark();
        Robot.move();
    }

    public static void turnAroundAndCheck()
    {
        //robot turns around and moves 4 tiles to check
        doubleBackUp();
        turnAround();
        moveTwo();
    }

    public static void turnRightAndCheck()
    {
        //robot backs up, and turns right, and moves two tiles.
        doubleBackUp();
        turnRight();
        moveTwo();    
    }

    public static void moveTwo()
    {
        //robot moves two tiles
        Robot.move();
        Robot.move();
    }

    public static void doubleBackUp()
    {
        //robot moves two behind, and turns around
        turnAround();
        moveTwo();
        turnAround();
    }

    public static void testConnectDots1()
    {
        Robot.load("connect1.txt");
        Robot.setDelay(0.025);
        connectDots();
    }

    public static void testConnectDots2()
    {
        Robot.load("connect2.txt");
        Robot.setDelay(0.025);
        connectDots();
    }
}
    
    


