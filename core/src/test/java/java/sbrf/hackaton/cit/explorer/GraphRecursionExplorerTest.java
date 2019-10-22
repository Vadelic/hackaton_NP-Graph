package java.sbrf.hackaton.cit.explorer;

import org.junit.Before;
import org.junit.Test;
import sbrf.hackaton.cit.core.Edge;
import sbrf.hackaton.cit.core.Route;
import sbrf.hackaton.cit.core.Vertex;
import sbrf.hackaton.cit.explorer.DfsExplorer;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Stanislav Bausov on 08.10.2019.
 */
public class GraphRecursionExplorerTest {
    private DfsExplorer explorer;

    @Before
    public void setUp() throws Exception {
        explorer = new DfsExplorer(null); // init
    }

    @Test
    public void routeSearch() {
        final Edge road = null;
        final Vertex point = null;

        List<Route> routes = explorer.routeSearch(point);// test

        assertEquals("found size", 0, routes.size());
    }

    @Test(expected = NullPointerException.class)
    public void routeSearch_nulls() {
        explorer.routeSearch(null);
    }
}