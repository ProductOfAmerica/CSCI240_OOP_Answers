package Project11.Basic;
/*
 * Copyright Clint Staley 2015
 */


public class StepDspCounter implements Steppable, Displayable {
    private Vector loc;
    private Vector vlc;

    public StepDspCounter() {
        loc = new Vector();
        vlc = new Vector(1.0, 1.0);
    }




    @Override
    public Vector getLoc() {
        return loc;
    }

    @Override
    public Vector getVlc() {
        return vlc;
    }

    @Override
    public void step() {
        loc.augmentBy(vlc);
    }



    public static void main(String[] args) {
        StepDspCounter sdc = new StepDspCounter();

        Displayable dsp = sdc;

        Steppable stp = sdc;


        for (int i = 0; i < 5; i++) {
            stp.step();
            System.out.printf("At step %d: loc is %s and vlc is %s\n", i,
                    dsp.getLoc().toString(), dsp.getVlc().toString());
        }
    }
}