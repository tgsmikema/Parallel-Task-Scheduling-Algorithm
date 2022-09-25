package solutiontree;

import org.graphstream.graph.Node;
import org.graphstream.stream.file.FileSource;
import org.graphstream.stream.file.FileSourceDOT;
import solution.Digraph;
import solution.SolutionTree;

import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTreeUnitTest {

    private Digraph loadGraph(String graphName) {
        String relativePath = "examples/" + graphName + "/in.dot";
        Digraph graph = new Digraph("solution." + graphName);
        FileSource fileSource = new FileSourceDOT();
        fileSource.addSink(graph);
        try {
            fileSource.readAll(relativePath);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return graph;
    }

    private int countSolutions(SolutionTree solutionTree) {
        int count = 0;
        for (Node node: solutionTree.getAllNodes()) {
            if (node.getOutDegree() == 0) {
                count++;
            }
        }
        return count;
    }

//    @Test
//    public void graph1OneProcessor() {
//        Digraph digraph = loadGraph("g1");
//        SolutionTree solutionTree = SolutionTree.getSolutionTree(digraph, 1);
//        assertEquals(2, countSolutions(solutionTree));
//    }
}
