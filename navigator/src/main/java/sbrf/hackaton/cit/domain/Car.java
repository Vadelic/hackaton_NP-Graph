package sbrf.hackaton.cit.domain;

import sbrf.hackaton.cit.core.*;
import sbrf.hackaton.cit.explorer.DfsExplorer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringJoiner;

import static sbrf.hackaton.cit.domain.AtmStatus.*;


/**
 * Created by Komyshenets on 29.09.2019.
 */
public class Car extends Cursor {
    private final DfsExplorer dfsExplorer;
    private final LinkedList<Atm> currentWay = new LinkedList<>();
    private final LinkedList<RouteBlock> planedPath = new LinkedList<>();
    private double usedTime = 0;

    public Car(int time, int weight, Atm start) {
        super(time, weight);
        this.currentWay.addLast(start);
        dfsExplorer = new DfsExplorer(this);
    }

    /**
     * @return
     */
    public FixedRoute goToNextPoint() {
        cleanPlanedWay();

        Atm last = currentWay.getLast();
        FixedRoute fixedRoute = dfsExplorer.routeSearch(last);

        RouteBlock<Road, Atm> firstDestination = fixedRoute.getFirstDestination();
        ArrayList<RouteBlock> planedPath = fixedRoute.getPlanedPath();

        visitAtm(firstDestination);
        setPlaneWay(planedPath);
        return fixedRoute;
    }

    private void setPlaneWay(ArrayList<RouteBlock> planedPath) {
        for (RouteBlock routeBlock : planedPath) {
            Atm atmPlaned = (Atm) routeBlock.getVertex();
            atmPlaned.setStatus(PLANED);
            this.planedPath.addLast(routeBlock);

        }
    }

    private void cleanPlanedWay() {
        planedPath.stream().map(block -> (Atm) block.getVertex()).forEach(atm -> atm.setStatus(FREE));
        planedPath.clear();
    }


    private void visitAtm(RouteBlock<Road, Atm> firstDestination) {
        Atm atm = firstDestination.getVertex();
        atm.setStatus(VISITED);
        currentWay.addLast(atm);
        usedTime += firstDestination.getEdge().getDistanceWithTraffic();


    }

    @Override
    public boolean isAvailableWay(Edge targetRoad, Vertex targetPoint) {
        return ((Atm) targetPoint).isAvailable()
                && super.isAvailableWay(targetRoad, targetPoint);
    }

    @Override
    protected double leftEdgeValue() {
        return timeMax - usedTime;
    }

    @Override
    protected double leftVertexValue() {
        return moneyMax - currentWay.stream().distinct().mapToDouble(Atm::getValue).sum();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Car.class.getSimpleName() + "[", "]")
                .add("currentWay=" + currentWay)
                .add("planedPath=" + planedPath)
                .add("usedTime=" + usedTime)
                .toString();
    }
}
