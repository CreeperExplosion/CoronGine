package solution.engine.Util;

public class Timer {

    private boolean started;

    private long startTime;

    public Timer() {
        
    }

    public void start(){
        if(started)
            return;
        startTime = System.currentTimeMillis();
        started =  true;
    }

    public void stop(){
        if(!started)
            return;
        started = false;
    }

    public long getTime(){

        if (!started)
            return -1;

       return System.currentTimeMillis() - startTime;
    }

}