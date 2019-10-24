package sbrf.hackaton.cit.domain;

import sbrf.hackaton.cit.core.Cursor;
import sbrf.hackaton.cit.core.FixedRoute;
import sbrf.hackaton.cit.core.RouteBlock;
import sbrf.hackaton.cit.core.Vertex;
import sbrf.hackaton.cit.explorer.Explorer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;

import static sbrf.hackaton.cit.domain.AtmStatus.*;


/**
 * Created by Komyshenets on 29.09.2019.
 */
public class Car extends Cursor {
    private final Explorer explorer;
    private final LinkedList<LinkedList<RouteBlock<Road, Atm>>> happenedWays = new LinkedList<>();
    private final LinkedList<RouteBlock<Road, Atm>> currentWay = new LinkedList<>();
    private final LinkedList<RouteBlock> planedPath = new LinkedList<>();
    private double usedTime = 0;
    private String name;

    public Car(String name, int time, int weight, Atm start, Function<Car, Explorer> getExplorer) {
        super(time, weight);
        this.name = name;
        this.currentWay.addLast(new RouteBlock<>(null, start));
        explorer = getExplorer.apply(this);
        start.setStatus(VISITED);
    }

    @Override
    public Car clone() {
        return (Car) super.clone();
    }

    /**
     * @return
     */
    public FixedRoute goToNextPoint() {
        cleanPlanedWay();

        Atm last = currentWay.getLast().getVertex();
        FixedRoute fixedRoute = explorer.routeSearch(last);

        RouteBlock<Road, Atm> firstDestination = fixedRoute.getFirstDestination();
        ArrayList<RouteBlock> planedPath = fixedRoute.getPlanedPath();

        visitAtm(firstDestination);
        setPlaneWay(planedPath);
        return fixedRoute;
    }

    private void setPlaneWay(ArrayList<RouteBlock> planedPath) {
        for (RouteBlock routeBlock : planedPath) {
            Atm atmPlaned = (Atm) routeBlock.getVertex();
            atmPlaned.setStatus(PLANNED);
            this.planedPath.addLast(routeBlock);

        }
    }

    private void cleanPlanedWay() {
        planedPath.stream().map(block -> (Atm) block.getVertex()).forEach(atm -> atm.setStatus(FREE));
        planedPath.clear();
    }


    private void visitAtm(RouteBlock<Road, Atm> block) {
        Atm atm = block.getVertex();
        atm.setStatus(VISITED);
        currentWay.addLast(block);
        usedTime += block.getDistanceWithTraffic();


    }

    //    Atm atm = block.getVertex();
//        currentWay.addLast(block);
//    usedTime += block.getDistanceWithTraffic();
//        if (!atm.isOut()) {
//        atm.setStatus(VISITED);
//    }else{
//
//    }
//        happenedWays.addLast((LinkedList<RouteBlock<Road, Atm>>) currentWay.clone());
//}
    @Override
    public boolean isAvailableWay(RouteBlock block) {
        return ((Atm) block.getVertex()).status == AtmStatus.FREE
                && super.isAvailableWay(block);
    }


    @Override
    protected double leftEdgeValue() {
        return timeMax - usedTime;
    }

    @Override
    protected double leftVertexValue() {
        return super.leftVertexValue() - currentWay.stream().map(RouteBlock::getVertex).mapToDouble(Atm::getValue).sum();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", name + "[", "]")
                .add("usedTime=" + usedTime)
                .add("currentWeight=" + (currentWay.stream()
                        .distinct()
                        .map(RouteBlock::getVertex)
                        .mapToDouble(Vertex::getValue)
                        .sum()))
                .add("currentWay=" + currentWay.stream().map(RouteBlock::getVertex).collect(Collectors.toList()))
                .add("planedPath=" + planedPath)
                .toString();
    }

    public boolean atFinish() {
        return currentWay.getLast().getVertex().isOut();
    }
}
