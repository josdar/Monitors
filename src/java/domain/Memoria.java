package domain;

public class Memoria {
    double sga;
    double sharedPool;
    double freeSga;
    double freeSharedPool;
    double usedSga;
    double usedSharedPool;
    

    public Memoria() {
        
    }

    public Memoria(double sga, double sharedPool, double freeSga, double freeSharedPool, double usedSga, double usedSharedPool) {
        this.sga = sga;
        this.sharedPool = sharedPool;
        this.freeSga = freeSga;
        this.freeSharedPool = freeSharedPool;
        this.usedSga = usedSga;
        this.usedSharedPool = usedSharedPool;
    }

    public double getFreeSga() {
        return freeSga;
    }

    public void setFreeSga(double freeSga) {
        this.freeSga = freeSga;
    }

    public double getFreeSharedPool() {
        return freeSharedPool;
    }

    public void setFreeSharedPool(double freeSharedPool) {
        this.freeSharedPool = freeSharedPool;
    }

    public double getUsedSga() {
        return usedSga;
    }

    public void setUsedSga(double usedSga) {
        this.usedSga = usedSga;
    }

    public double getUsedSharedPool() {
        return usedSharedPool;
    }

    public void setUsedSharedPool(double usedSharedPool) {
        this.usedSharedPool = usedSharedPool;
    }

    public double getSga() {
        return sga;
    }

    public void setSga(double sga) {
        this.sga = sga;
    }

    public double getSharedPool() {
        return sharedPool;
    }

    public void setSharedPool(double sharedPool) {
        this.sharedPool = sharedPool;
    }
  
    
    
}
