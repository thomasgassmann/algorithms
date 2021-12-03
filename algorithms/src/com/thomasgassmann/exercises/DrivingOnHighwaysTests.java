package com.thomasgassmann.exercises;

import com.thomasgassmann.graphs.Graph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DrivingOnHighwaysTests {
    @Test
    public void checkDrivingOnHighways1() {
        var graph = new Graph();
        var a = graph.addVertex("A");
        var b = graph.addVertex("B");
        var c = graph.addVertex("C");
        var d = graph.addVertex("D");

        graph.addDirectedEdge(a, b);
        graph.addDirectedEdge(b, c);
        graph.addDirectedEdge(c, d);
        graph.addDirectedEdge(d, b);

        Assertions.assertFalse(DrivingOnHighways.DrivingOnHighways(graph));
    }

    @Test
    public void checkDrivingOnHighways2() {
        var graph = new Graph();
        var a = graph.addVertex("A");
        var b = graph.addVertex("B");
        var c = graph.addVertex("C");
        var d = graph.addVertex("D");
        var e = graph.addVertex("E");
        var f = graph.addVertex("F");
        var h = graph.addVertex("H");
        var i = graph.addVertex("I");
        var j = graph.addVertex("J");
        var k = graph.addVertex("K");
        var l = graph.addVertex("L");

        graph.addDirectedEdge(a, b);
        graph.addDirectedEdge(a, f);
        graph.addDirectedEdge(b, c);
        graph.addDirectedEdge(c, j);
        graph.addDirectedEdge(c, d);
        graph.addDirectedEdge(c, a);
        graph.addDirectedEdge(d, e);
        graph.addDirectedEdge(e, c);
        graph.addDirectedEdge(f, i);
        graph.addDirectedEdge(f, h);
        graph.addDirectedEdge(h, l);
        graph.addDirectedEdge(h, k);
        graph.addDirectedEdge(k, e);

        Assertions.assertFalse(DrivingOnHighways.DrivingOnHighways(graph));
    }

    @Test
    public void checkDrivingOnHighways3() {
        var graph = new Graph();
        var a = graph.addVertex("A");
        var b = graph.addVertex("B");
        var c = graph.addVertex("C");
        var d = graph.addVertex("D");
        var e = graph.addVertex("E");
        var f = graph.addVertex("F");
        var h = graph.addVertex("H");
        var k = graph.addVertex("K");

        graph.addDirectedEdge(a, b);
        graph.addDirectedEdge(a, f);
        graph.addDirectedEdge(b, c);
        graph.addDirectedEdge(c, d);
        graph.addDirectedEdge(c, a);
        graph.addDirectedEdge(d, e);
        graph.addDirectedEdge(e, c);
        graph.addDirectedEdge(f, h);
        graph.addDirectedEdge(h, k);
        graph.addDirectedEdge(k, e);

        Assertions.assertTrue(DrivingOnHighways.DrivingOnHighways(graph));
    }
}
